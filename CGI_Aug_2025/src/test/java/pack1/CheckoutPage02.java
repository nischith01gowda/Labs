package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage02 {
    WebDriver driver;

    By addressDetails = By.xpath("//h2[contains(text(),'Address Details')]");
    By placeOrder = By.xpath("//a[contains(text(),'Place Order')]");
    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");
    By submitBtn = By.id("submit");
    By confirmationMsg = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");

    public CheckoutPage02(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAddressVisible() {
        return driver.findElement(addressDetails).isDisplayed();
    }

    public void placeOrder() {
        driver.findElement(placeOrder).click();
    }

    public void enterPaymentDetails(String name, String number, String cvcCode, String month, String year) {
        driver.findElement(nameOnCard).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(number);
        driver.findElement(cvc).sendKeys(cvcCode);
        driver.findElement(expiryMonth).sendKeys(month);
        driver.findElement(expiryYear).sendKeys(year);
        driver.findElement(submitBtn).click();
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(confirmationMsg).isDisplayed();
    }
}
