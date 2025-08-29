package pack1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage05 {
    WebDriver driver;

    By emailInput = By.xpath("//input[@data-qa='login-email']");
    By passwordInput = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By loginHeader = By.xpath("//h2[text()='Login to your account']");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");

    public LoginPage05(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginHeaderDisplayed() {
        return driver.findElement(loginHeader).isDisplayed();
    }

    public boolean isLoggedIn() {
        return driver.findElement(loggedInText).isDisplayed();
    }
}
