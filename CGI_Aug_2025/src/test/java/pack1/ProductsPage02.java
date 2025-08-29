package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage02 {
    WebDriver driver;

    By productsNav = By.xpath("//a[@href='/products']");
    By firstProduct = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By thirdProduct = By.xpath("(//a[contains(text(),'Add to cart')])[3]");
    By continueShopping = By.xpath("//button[text()='Continue Shopping']");
    By viewCart = By.xpath("//u[text()='View Cart']");

    public ProductsPage02(WebDriver driver) {
        this.driver = driver;
    }

    public void goToProducts() {
        driver.findElement(productsNav).click();
    }

    public void addFirstProduct() {
        driver.findElement(firstProduct).click();
        driver.findElement(continueShopping).click();
    }

    public void addThirdProduct() {
        driver.findElement(thirdProduct).click();
        driver.findElement(viewCart).click();
    }
}
