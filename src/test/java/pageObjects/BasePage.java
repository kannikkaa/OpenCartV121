package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {//parent of all the pageObjects classes, bec it has constructor
    //which is implemented by each and evry class, same for each class, so that i wont have  to creaet
    //constructor foe each class
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
//to achieve reusability