package pages;

import generic_pages.CommonSignupPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Utils;


public class SignupPage extends CommonSignupPage
{
    private AppiumDriver driver;
    static CommonFunctions commonFunctions=null;
    private static SignupPage signupPage;


    public SignupPage() {
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctions.getInstance();
    }
    public static SignupPage getSignupPageInstance(){
        if(signupPage==null){
            signupPage=new SignupPage();
        }
        return signupPage;
    }
    
    




}


