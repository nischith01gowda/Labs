package pack1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC011_TestNG2 {
	WebDriver driver;
  @Test(dataProvider = "logindata")
  public void f(String username, String password) {
	  System.out.println("This is the test");
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  WebElement uname=driver.findElement(By.name("username"));
	  if(uname.isDisplayed())
	  {
		  uname.sendKeys(username);
		  System.out.println("Get placeholder:"+uname.getAttribute("placeholder"));
	  }
	  else{
		  System.out.println("username is not displayed");
          }
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("username")).sendKeys(Keys.ENTER);
	  WebElement dashboard= driver.findElement(By.xpath("//h6[text()='Dashboard']"));
	  if(dashboard.isDisplayed()) {
		  Assert.assertTrue(true);
	  }
	  else {
		  Assert.assertTrue(false);
	  }
  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  System.out.println("This is before method");
  }

  @AfterMethod
  public void afterMethod() {
		driver.quit();
	  System.out.println("This is after method");
  }


  @DataProvider
  public Object[][] logindata() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "pooja", "Welcome" },
    };
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
	  System.out.println("This is after Test");
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
