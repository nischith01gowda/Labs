package pack1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab8_Lab3TestCase {
    WebDriver driver;

    @Test
    public void test() {
        System.out.println("Checking Flow of - Desktops - Mac - Add to Cart");

        WebElement desktopsTab = driver.findElement(By.linkText("Desktops"));
        desktopsTab.click();

        WebElement macLink = driver.findElement(By.linkText("Mac (1)"));
        macLink.click();

        WebElement sortDropdown = driver.findElement(By.id("input-sort"));	        // Sorting A-Z
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A - Z)");

        WebElement addToCartBtn = driver.findElement(By.xpath("//button[contains(@onclick,'cart.add')]"));
        addToCartBtn.click();
        Assert.assertTrue(addToCartBtn.isDisplayed());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is before method");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/index.php?");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is after method");
        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is after class");
    }

    
    
}