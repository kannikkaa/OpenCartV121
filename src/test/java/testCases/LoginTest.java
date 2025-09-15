package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void verify_login() {
        logger.info("starting login test");

        try {
            //Home page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //Login Page
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();

            //MyAccount page
            MyAccountPage myAc = new MyAccountPage(driver);
            boolean targetPage = myAc.isMyAccountPageExists();
            // Assert.assertEquals(targetPage, true, "Login failed");
            Assert.assertTrue(targetPage);
            myAc.clickDesktop();
        } catch (Exception e) {
            Assert.fail("Login test failed due to exception: " + e.getMessage());
        }
        logger.info(" Finished login test");
    }
}
