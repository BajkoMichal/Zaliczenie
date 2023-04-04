package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {

    public YourAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[3]/a/span")
    WebElement createNewAddressBtn;

    //@FindBy(xpath = "//*[contains(text(), 'Address successfully updated!')]")
    //WebElement accountHeader;

    public void goToCreateNewAddressPage() {
        createNewAddressBtn.click();
    }

   // public void getAccountHeader() {
       // Assert.assertTrue(accountHeader.isDisplayed());

   //}
}





