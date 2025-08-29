package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage05 {
    WebDriver driver;

    By cartTable = By.xpath("//table[@id='cart_info_table']");
    By proceedToCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    public CartPage05(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartDisplayed() {
        return driver.findElement(cartTable).isDisplayed();
    }

    public void proceedToCheckout() {
        driver.findElement(proceedToCheckout).click();
    }
}