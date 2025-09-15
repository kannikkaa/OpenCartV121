package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

/* Data  valid -> login success -> test pass - logout
     Data  valid -> login failed -> test fail

     Data  invalid -> login success -> test fail
     Data  invalid -> login failed -> test pass - logout
   */
public class LoginDDT extends BaseClass {//DATA DRIVEN TESTCASE

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "datadriven")
  public  void  verify_DDT(String email, String password, String expResult){

        logger.info(" starting Login DDT...");
      //Home page
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //Login Page
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(password);
            lp.clickLogin();

            //MyAccount page
            MyAccountPage myAc = new MyAccountPage(driver);
            boolean targetPage = myAc.isMyAccountPageExists();

            //data is valid -> if(login success: assert true) & else(login unsuccess; assert fail)
            if (expResult.equalsIgnoreCase("Valid")) {
                if (targetPage) {
                    Assert.assertTrue(true);
                    myAc.clickLogout();
                } else {
                    Assert.fail();
                }
            }

            //data is invalid -> if(login success: assert fail) & else(login unsuccess: assert true)
            if (expResult.equalsIgnoreCase("invalid")) {
                if (targetPage) {
                    myAc.clickLogout();
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred in LoginDDT test case: {}", e.getMessage());
           Assert.fail();
        } finally {
            logger.info("finished test case LoginDDT..");
        }

  }
}
