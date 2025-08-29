package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage05 {
    WebDriver driver;

    By loginLink = By.xpath("//a[@href='/login']");
    By logoutLink = By.xpath("//a[@href='/logout']");
    By productsLink = By.xpath("//a[@href='/products']");
    By cartLink = By.xpath("//a[@href='/view_cart']");

    public HomePage05(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLogin() {
        driver.findElement(loginLink).click();
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }

    public void goToProducts() {
        driver.findElement(productsLink).click();
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}