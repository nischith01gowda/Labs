package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage02 {
    WebDriver driver;

    By emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By loginNav = By.xpath("//a[@href='/login']");
    By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");

    public LoginPage02(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.findElement(loginNav).click();
    }

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoggedIn() {
        return driver.findElement(loggedInAs).isDisplayed();
    }
}
