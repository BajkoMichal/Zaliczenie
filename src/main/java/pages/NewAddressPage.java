package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {

    public NewAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-alias")
    WebElement aliasInput;
    @FindBy(id = "field-address1")
    WebElement addressInput;
    @FindBy(id = "field-city")
    WebElement cityInput;
    @FindBy(id = "field-id_state")
    Select stateInput;
    @FindBy(id = "field-postcode")
    WebElement postcodeInput;
    @FindBy(id = "field-id_country")
    Select countryInput;
    @FindBy(id = "field-phone")
    WebElement phoneInput;
    @FindBy(xpath = "//*[contains(text(), 'Save')]")
    WebElement saveBtn;

    public void addNewAddress(String alias, String address, String city, String postalcode, String phone) {
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        stateInput.selectByValue("1");
        postcodeInput.sendKeys(postalcode);
        countryInput.selectByValue("17");
        phoneInput.sendKeys(phone);
        saveBtn.click();

    }




}
