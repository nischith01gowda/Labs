package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage05 {
    WebDriver driver;

    By firstAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By viewCartLink = By.xpath("//u[text()='View Cart']");

    public ProductsPage05(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstItemToCart() {
        driver.findElement(firstAddToCart).click();
    }

    public void viewCart() {
        driver.findElement(viewCartLink).click();
    }
}

