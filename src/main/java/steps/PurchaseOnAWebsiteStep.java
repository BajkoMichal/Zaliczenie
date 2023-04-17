package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.AddProductToCart;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderConfirmPage;


import java.time.Duration;

public class PurchaseOnAWebsiteStep {

    public static WebDriver driver;
    public String url = "https://mystore-testlab.coderslab.pl";

    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Given("The user is on the main page, logs into their account by providing their {string} and {string} and goes to the clothing section.")
    public void logIntoApp(String Email, String Password) {
        HomePage homePage2 = new HomePage(driver);
        homePage2.goToSingInPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        homePage2.logIntoAccount(Email, Password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        homePage2.goToClothesPage();
    }

    @When("The user selects the desired product, selects the size, adds the selected numbers od items to the cart and proceeds to checkout.")
    public void goToProductPage() {
        AddProductToCart addProductToCart = new AddProductToCart(driver);
        addProductToCart.goToProductPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        addProductToCart.chooseQuantity();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        addProductToCart.addToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        addProductToCart.gotoProceedToCheckOut();
    }

    @And("The user confirms the delivery address, selects the delivery method, chooses the appropriate payment method, accepts the terms and conditions, and clicks the button to confirm the order.")
    public void goToCheckoutPage() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.goToCheckout();

    }

    @Then("The user receives confirmation of the successful purchase of the item and takes a screenshot of the information.")
    public void verifyOrderComplete() {
        OrderConfirmPage orderConfirmPage = new OrderConfirmPage(driver);
        Assert.assertEquals(orderConfirmPage.getAccountHeader(), "YOUR ORDER IS CONFIRMED");

    }

    @And("The browser is closed")
    public void tearDown() {
        driver.quit();
    }
}



