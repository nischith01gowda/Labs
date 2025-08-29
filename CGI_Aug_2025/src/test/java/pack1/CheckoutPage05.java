package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage05 {
    WebDriver driver;

    By addressDetails = By.xpath("//h2[contains(text(),'Address Details')]");
    By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");

    public CheckoutPage05(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAddressDisplayed() {
        return driver.findElement(addressDetails).isDisplayed();
    }

    public void placeOrder() {
        driver.findElement(placeOrderBtn).click();
    }
}