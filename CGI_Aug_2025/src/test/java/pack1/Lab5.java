package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		//Part 1
		
		System.out.println("Title is : "+ driver.getTitle());
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		String expectedheading = "Register Account";
		WebElement heading = driver.findElement(By.xpath("/html/body/div[2]/div/div/h1"));
		String actualheading = heading.getText();
		if (expectedheading.equals(actualheading)) {
            System.out.println("Heading verified " +actualheading);
        } else {
            System.out.println("Heading Verification failed. Actual: " + actualheading);
        }
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		WebElement warningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
	        String actualWarning = warningMsg.getText();
	        String expectedWarning = "Warning: You must agree to the Privacy Policy!";
	        if (actualWarning.contains(expectedWarning)) {
	            System.out.println("Warning verification passed: " + actualWarning);
	        } else {
	            System.out.println("Warning verification failed. Actual: " + actualWarning);
	        }
	    //Part 2 
	        //Entering 33 characters first name
	        String firstName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"; 
	        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
	        firstNameField.sendKeys(firstName);
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();
	        
	         // Verifying error message
	        
	        try {
	            WebElement firstNameError = driver.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']"));
	            if (firstNameError.isDisplayed()) {
	                System.out.println("First Name validation failed: 33 chars not accepted");
	            }
	        } catch (Exception e) {
	            System.out.println("First Name accepted 33 characters (no error)");
	        }
	        
	        //entering last name with 33 characters
	        
	        String lastName33 = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"; 
	        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
	        lastNameField.sendKeys(lastName33);
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();
	        
	        //Verifying error message
	        
	        try {
	            WebElement lastNameError = driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']"));
	            if (lastNameError.isDisplayed()) {
	                System.out.println("Last Name validation failed: 33 chars not accepted");
	            }
	        } catch (Exception e) {
	            System.out.println("Last Name accepted 33 characters (no error)");
	        }
	        
	        //Entering valid email id
	        
	        WebElement emailField = driver.findElement(By.id("input-email"));
	        emailField.sendKeys("nischith11@gmail.com");
	        
	        //Entering valid telephone number
	        
	        WebElement phoneField = driver.findElement(By.id("input-telephone"));
	        String validPhone = "9076642100";
	        phoneField.sendKeys(validPhone);
	        
	        //Part 4
	        
	        // Password 
	        driver.findElement(By.id("input-password")).sendKeys("Test@1234");
	        driver.findElement(By.id("input-confirm")).sendKeys("Test@1234");
	        
	     //Newsletter
	        WebElement newsletterYes = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
	        newsletterYes.click();
	        
	        driver.findElement(By.name("agree")).click();
	        
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();
	       
	        driver.findElement(By.id("input-firstname")).clear();
	        driver.findElement(By.id("input-firstname")).sendKeys("Test");
	        driver.findElement(By.id("input-lastname")).clear();
	        driver.findElement(By.id("input-lastname")).sendKeys("User");
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();
	        
	        WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
	        if (successMsg.isDisplayed()) {
	            System.out.println("✅ Registration successful: " + successMsg.getText());
	        } else {
	            System.out.println("❌ Registration failed!");
	        }
	        
	        driver.findElement(By.xpath("//a[text()='Continue']")).click();

	        WebElement orderHistoryLink = driver.findElement(By.xpath("//a[text()='View your order history']"));
	        orderHistoryLink.click();
	        
	        
	}
	
}
