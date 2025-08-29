package pack1;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Project_REG_EndToEnd_05 {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    HomePage05 home;
    LoginPage05 login;
    ProductsPage05 products;
    CartPage05 cart;
    CheckoutPage05 checkout;
    PaymentPage05 payment;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ExtentSparkReporter reporter = new ExtentSparkReporter("Project_REG_EndToEnd_05_report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        driver.get("https://automationexercise.com/");

        home = new HomePage05(driver);
        login = new LoginPage05(driver);
        products = new ProductsPage05(driver);
        cart = new CartPage05(driver);
        checkout = new CheckoutPage05(driver);
        payment = new PaymentPage05(driver);
    }

    @DataProvider(name = "userData05")
    public Object[][] getUserData() {
        return new Object[][]{
                {"virat0018@gmail.com", "virat"}
        };
    }

    @Test(dataProvider = "userData05")
    public void cartPersistenceFlow(String email, String password) {
        test = extent.createTest("Cart Persistence Flow");

        // Login
        home.goToLogin();
        login.login(email, password);
        Assert.assertTrue(login.isLoggedIn(), "Login failed!");
        test.pass("Login successful");

        // Add item to cart
        home.goToProducts();
        products.addFirstItemToCart();
        products.viewCart();
        Assert.assertTrue(cart.isCartDisplayed(), "Cart not displayed!");
        test.pass("Item added to cart");

        // Logout
        home.logout();
        Assert.assertTrue(login.isLoginHeaderDisplayed(), "Logout failed!");
        test.pass("Logout successful");

        // Login again
        login.login(email, password);
        Assert.assertTrue(login.isLoggedIn(), "Re-login failed!");
        test.pass("Re-login successful");

        // Verify cart persists
        home.goToCart();
        Assert.assertTrue(cart.isCartDisplayed(), "Cart is empty after re-login!");
        test.pass("Cart persists after re-login");

        // Checkout
        cart.proceedToCheckout();
        Assert.assertTrue(checkout.isAddressDisplayed(), "Checkout page not displayed!");
        test.pass("Checkout page displayed");

        checkout.placeOrder();

        // Payment
        payment.enterPaymentDetails("Virat Kohli", "4111111111111111", "533", "12", "2030");
        Assert.assertTrue(payment.isOrderConfirmed(), "Order not confirmed!");
        test.pass("Order confirmed successfully");
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}