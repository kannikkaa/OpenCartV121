package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class HomePage extends BasePage {
    //not to escape from this line of code//PageFactory.initElements(driver, this); in each class
    //we just made basePage class, now each class must implement it, bec it is not a default constructor

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement clickAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement clickRegister;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    WebElement linkLogin;


    public void clickMyAccount() {
        clickAccount.click();
    }

    public void clickRegister() {
        clickRegister.click();
    }

    public void clickLogin(){
        linkLogin.click();
    }


}
