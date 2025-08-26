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

public class Lab8_Lab4TestCase {
    WebDriver driver;

    @Test
    public void testFlow() {
        System.out.println("Tesing flow");

        String expectedTitle = "Your Store";
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        WebElement desktopsTab = driver.findElement(By.linkText("Desktops"));
        desktopsTab.click();

        WebElement macLink = driver.findElement(By.linkText("Mac (1)"));
        macLink.click();

        WebElement macHeading = driver.findElement(By.xpath("//h2[text()='Mac']"));
        Assert.assertTrue(macHeading.isDisplayed());

        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A - Z)");

        driver.findElement(By.xpath("//button[contains(@onclick,'cart.add')]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");

        WebElement searchBtn = driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg"));
        searchBtn.click();

        WebElement searchHeading = driver.findElement(By.xpath("//h1[contains(text(),'Monitors')]"));
        Assert.assertTrue(searchHeading.isDisplayed());

        searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");

        WebElement searchInDescCheckbox = driver.findElement(By.name("description"));
        if(!searchInDescCheckbox.isSelected()) {
            searchInDescCheckbox.click();
        }
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        searchHeading = driver.findElement(By.xpath("//h1[contains(text(),'Monitors')]"));
        Assert.assertTrue(searchHeading.isDisplayed());
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

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is after test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is after suite");
    }
}