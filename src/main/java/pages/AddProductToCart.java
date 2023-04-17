package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductToCart {
    public AddProductToCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/div[2]/article/div/div[1]/a/img")
    WebElement productBtn;
    @FindBy(id = "group_1")
    WebElement sizeBtn;
    @FindBy(className = "material-icons touchspin-up")
    WebElement quantityBtn;
    @FindBy(className = "btn btn-primary add-to-cart")
    WebElement addToCartBtn;
    @FindBy(className = "btn btn-primary")
    WebElement proceedToCheckoutBtn;

    public void goToProductPage() {
        productBtn.click();
    }

    public void chooseQuantity() {
        for (int i = 0; i < 5; i++) {
            quantityBtn.click();
        }
    }
    public void addToCart() {
        addToCartBtn.click();
    }
    public void gotoProceedToCheckOut() {
        proceedToCheckoutBtn.click();

    }
}















