package pack1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("nischith11@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@1234");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		 driver.findElement(By.linkText("Components")).click();
		 driver.findElement(By.linkText("Monitors (2)")).click();
		 
		 driver.findElement(By.id("input-limit")).sendKeys("25");
		 driver.findElement(By.xpath("//button[contains(@onclick,\"cart.add('42'\")]")).click();

		 driver.findElement(By.linkText("Apple Cinema 30\"")).click();
		 driver.findElement(By.linkText("Specification")).click();
	        if (driver.findElement(By.id("tab-specification")).isDisplayed()) {
	            System.out.println("Specification details visible");
	        }
	     driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List'][@class='btn btn-default']")).click();
	     WebElement wishMsg= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
	     System.out.println("Message: " + wishMsg.getText());
	     
	     driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Mobile");
	     driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	     driver.findElement(By.id("description")).click();
	     driver.findElement(By.id("button-search")).click();
	     driver.findElement(By.linkText("HTC Touch HD")).click();
	     
	     WebElement qty = driver.findElement(By.id("input-quantity"));
	     qty.clear();
	     qty.sendKeys("3");
	     driver.findElement(By.id("button-cart")).click();
	     WebElement msg= driver.findElement(By.cssSelector(".alert-success"));
	     System.out.println("Message: " + msg.getText());
	     driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
	     if (driver.findElement(By.linkText("HTC Touch HD")).isDisplayed()) {
	    	 System.out.println("✅ HTC Touch HD is in the cart");
	        }
	     driver.findElement(By.linkText("Checkout")).click();
	     driver.findElement(By.linkText("My Account")).click();
	     driver.findElement(By.linkText("Logout")).click();
	     if (driver.findElement(By.xpath("//h1[text()='Account Logout']")).isDisplayed()) {
	         System.out.println("Logout successful");
	        }
	     driver.findElement(By.linkText("Continue")).click();
	     driver.quit();
	}

}
