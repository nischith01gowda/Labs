package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage05 {
    WebDriver driver;

    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");
    By payBtn = By.id("submit");
    By confirmationMsg = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");

    public PaymentPage05(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPaymentDetails(String name, String cardNum, String cvcCode, String month, String year) {
        driver.findElement(nameOnCard).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(cardNum);
        driver.findElement(cvc).sendKeys(cvcCode);
        driver.findElement(expiryMonth).sendKeys(month);
        driver.findElement(expiryYear).sendKeys(year);
        driver.findElement(payBtn).click();
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(confirmationMsg).isDisplayed();
    }
}