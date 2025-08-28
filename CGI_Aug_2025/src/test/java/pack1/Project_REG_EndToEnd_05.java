package pack1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Project_REG_EndToEnd_05 {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ExtentSparkReporter reporter = new ExtentSparkReporter("Project_REG_EndToEnd_05_report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        driver.get("https://automationexercise.com/");
    }

    @Test
    public void cartPersistenceFlow() {
        test = extent.createTest("Cart Persistence Flow");

       
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("virat0018@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("virat");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        WebElement loggedIn = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedIn.isDisplayed(), "Login failed!");
        test.pass("Login successful");

        
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        WebElement cartTable = driver.findElement(By.xpath("//table[@id='cart_info_table']"));
        Assert.assertTrue(cartTable.isDisplayed(), "Cart is not displayed after adding item");
        test.pass("Item added to cart successfully");

        
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        WebElement loginPage = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginPage.isDisplayed(), "Logout failed!");
        test.pass("Logout successful");

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("virat0018@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("virat");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        WebElement loggedInAgain = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedInAgain.isDisplayed(), "Re-login failed!");
        test.pass("Re-login successful");

        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        WebElement cartAfterLogin = driver.findElement(By.xpath("//table[@id='cart_info_table']"));
        Assert.assertTrue(cartAfterLogin.isDisplayed(), "Cart is empty after re-login!");
        test.pass("Cart persists after re-login");

        
        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
        WebElement address = driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]"));
        Assert.assertTrue(address.isDisplayed(), "Checkout page not displayed!");
        test.pass("Checkout page opened");

        driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();

        // Payment
        driver.findElement(By.name("name_on_card")).sendKeys("Virat Kohli");
        driver.findElement(By.name("card_number")).sendKeys("4111111111111111");
        driver.findElement(By.name("cvc")).sendKeys("533");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("2030");
        driver.findElement(By.id("submit")).click();

        WebElement confirmation = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]"));
        Assert.assertTrue(confirmation.isDisplayed(), "Order confirmation not displayed!");
        test.pass("Order placed successfully after re-login");
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}
