package pack1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Project_REG_EndToEnd_02 {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        ExtentSparkReporter spark = new ExtentSparkReporter("Project_REG_EndToEnd_02_report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DataProvider(name = "userData")
    public Object[][] getData() {
        return new Object[][]{
                {"virat0018@gmail.com", "virat"}
        };
    }

    @Test(dataProvider = "userData")
    public void fullUserFlow(String email, String password) {
        test = extent.createTest("Full User Flow");

        driver.get("https://automationexercise.com/");

        // Login
        LoginPage02 loginPage = new LoginPage02(driver);
        loginPage.goToLoginPage();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isLoggedIn(), "Login failed!");
        test.pass("Login successful");

        // Add products
        ProductsPage02 productsPage = new ProductsPage02(driver);
        productsPage.goToProducts();
        productsPage.addFirstProduct();
        productsPage.addThirdProduct();

        // Verify cart
        CartPage02 cartPage = new CartPage02(driver);
        Assert.assertEquals(cartPage.getCartItemCount(), 2, "Cart should contain 2 items");
        test.pass("Two items added to cart successfully");

        // Remove second item
        cartPage.removeSecondItem();
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Only 1 item should remain");
        test.pass("Removed second item successfully");

        // Checkout
        cartPage.proceedToCheckout();
        CheckoutPage02 checkoutPage = new CheckoutPage02(driver);
        Assert.assertTrue(checkoutPage.isAddressVisible(), "Address details not visible");

        checkoutPage.placeOrder();
        checkoutPage.enterPaymentDetails("Virat", "4111111111111111", "543", "12", "2030");
        Assert.assertTrue(checkoutPage.isOrderConfirmed(), "Order confirmation not displayed!");
        test.pass("Checkout completed successfully");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}
