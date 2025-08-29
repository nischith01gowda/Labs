package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage02 {
    WebDriver driver;
    WebDriverWait wait;

    By cartItems = By.xpath("//tr[contains(@id,'product')]");
    By deleteSecondItem = By.xpath("(//a[@class='cart_quantity_delete'])[2]");
    By checkoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    public CartPage02(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int getCartItemCount() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size();
    }

    public void removeSecondItem() {
        int before = getCartItemCount();
        driver.findElement(deleteSecondItem).click();
    
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(cartItems, before));
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
