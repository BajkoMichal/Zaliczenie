package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import pages.*;

public class AddNewAddressStep {
    public static WebDriver driver;
    public String url = "https://mystore-testlab.coderslab.pl";

    @Given("The User is on the home page")
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }
    @When("The User selects option SignIn")
    public void goToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToSingInPage();

    }
    @And("The User enters the correct {string} address and {string} and then confirms the login details")
    public void logIntoApp(String email, String password) {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.logIntoApp(email, password);
    }
    @And("The user is taken to their account information page and selects Addresses")
    public void goToAddressesPage(){
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.goToAddressesPage();
    }
    @And("The User selects Create new address")
    public void gocreateNewAddress(){
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.goToCreateNewAddressPage();
    }
    @And("The User enters a correct {string}, {string}, {string}, {string}, country, {string} and confirms the data")
    public void createNewAddress(String alias, String address, String city, String postcode, String phone){
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.addNewAddress(alias, address,city, postcode, phone);
        //Select stateInput = new Select();
        //stateInput.selectByValue("1");


    }
    @Then("The User is informed about the correct addition of the address to the user account")
    public void getAccountHeader(){
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
    }
    @And("The browser is closed")
    public void tearDown() {
        driver.quit();
    }

}
