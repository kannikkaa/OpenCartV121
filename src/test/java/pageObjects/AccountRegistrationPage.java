package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
    WebDriver driver;

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirm;

    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement chkNewsLetter;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement btnAgree;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;


    public void setFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastName.sendKeys(lname);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String phoneNo) {
        txtTelephone.sendKeys(phoneNo);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void setConfirmPswrd(String password) {
        txtConfirm.sendKeys(password);
    }

    public void setNewsletter() {
        chkNewsLetter.click();
    }

    public void clickAgree() {
        btnAgree.click();
    }

    public void clickContinue() {
        btnContinue.click();
        //or u can use these options
        //btncontinue.submit();

        //Actions act = new Actions();
        //act.moveToElement(btncontinue).click().perform();

        //JavascriptExecutor js = new (JavascriptExecutor)driver;
        //js.executeScript(arguments[0].click();", btncontinue);

        //btncontinue.sendKeys(Keys.RETURN);

        //WebDriverWait mywait = new WebDriver(driver, Duration.ofSeconds(10));
        //mywait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();
    }

    public String getConfirmationMsg(){
        try{
            return (msgConfirmation.getText());
        }
        catch (Exception e){
            return (e.getMessage());
        }
    }

}
