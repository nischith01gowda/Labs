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
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Test
    public void fullUserFlow() {
        test = extent.createTest("Full User Flow");
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("virat0018@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("virat");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        WebElement loggedIn = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedIn.isDisplayed(), "Login failed!");
        test.pass("Login successful");
        
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[3]")).click();
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        List<WebElement> cartItems = driver.findElements(By.xpath("//tr[contains(@id,'product')]"));
        Assert.assertEquals(cartItems.size(), 2, "Cart should contain 2 items");
        test.pass("Two items added to cart successfully");

        
        driver.findElement(By.xpath("(//a[@class='cart_quantity_delete'])[2]")).click();
        List<WebElement> remainingItems = driver.findElements(By.xpath("//table[@id='cart_info_table']//tr[contains(@id,'product')]"));
        Assert.assertEquals(remainingItems.size(), 2, "Only 1 item should remain");
        test.pass("Removed second item successfully");
        
        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
        WebElement address = driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]"));
        Assert.assertTrue(address.isDisplayed(), "Address details not visible");
        driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
        driver.findElement(By.name("name_on_card")).sendKeys("Virat");
        driver.findElement(By.name("card_number")).sendKeys("4111111111111111");
        driver.findElement(By.name("cvc")).sendKeys("543");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("2030");
        driver.findElement(By.id("submit")).click();
        WebElement confirmation = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]"));
        Assert.assertTrue(confirmation.isDisplayed(), "Order confirmation not displayed!");
        test.pass("Checkout completed successfully");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush(); 
    }
}
