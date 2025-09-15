package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.RealGroup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

import java.time.Duration;

public class AccountRegistrationTest extends BaseClass{


   @Test(groups = {"Regression", "Master"})
    void verify_account_registration(){
       //here 1 test case can use multiple page object classes, its using 2 page objects classes
       logger.info("Starting test case....");

try {
    HomePage hp = new HomePage(driver);
    hp.clickMyAccount();
    hp.clickRegister();

    AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
    regpage.setFirstName(randomString().toUpperCase());
    regpage.setLastName(randomString().toUpperCase());
    regpage.setEmail(randomString() + "@gmail.com");//now u can run this test n number of times, bec u have not hardcoded the mail here
    regpage.setTelephone((randomNum()));

    String password = randomAlphaNumeric();
    regpage.setPassword(password);
    regpage.setConfirmPswrd(password);
    regpage.setNewsletter();
    regpage.clickAgree();

    logger.info("Agreed to the privacy policy...");

    regpage.clickContinue();

    String msg = regpage.getConfirmationMsg();
    Assert.assertEquals(msg, "Your Account Has Been Created!");
    logger.info("Registration successful....");
}
catch(Exception e){
    logger.error("Test failed...");
}
       }

   }
//we will seperate all those methods which are req in multiple test cases, like teardown, setup, randowmString, randomNum, randomAlphaNumeric


