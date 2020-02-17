package pages;

import generic_pages.CommonForgotPasswordPage;
import generic_pages.CommonLoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Utils;

import java.time.Duration;

//import io.appium.java_client.android.AndroidKeyCode;

public class ForgotPasswordPage extends CommonForgotPasswordPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static ForgotPasswordPage forgotpasswordPage;


    @AndroidFindBy(id = "com.care_pro:id/tv_forgot_pass")
    private static AndroidElement forgotpasswordLink;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your registered email']")
    AndroidElement enteryourregisteredemailInputBox;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Proceed']")
    AndroidElement proceedButton;
    @AndroidFindBy(xpath = "//*[@text='The inserted Email is not associated with any account']")
    AndroidElement toastmessageText;
    @AndroidFindBy(id = "com.care_pro:id/iv_personal")
    private static AndroidElement personalImage;
    @AndroidFindBy(id = "com.care_pro:id/tb_rem")
    private static AndroidElement remembermeToggle;
    @AndroidFindBy(id = "com.care_pro:id/iv_more")
    private static AndroidElement moreImage;
    @AndroidFindBy(id = "com.care_pro:id/et_email")
    private static AndroidElement useridoremailInputBox;
    @AndroidFindBy(id = "com.care_pro:id/et_pass")
    private static AndroidElement passwordInputBox;
    @AndroidFindBy(id = "com.care_pro:id/tv_login")
    private static AndroidElement loginButton;


    public ForgotPasswordPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static ForgotPasswordPage getForgotPasswordPageInstance() {
        if (forgotpasswordPage == null) {
            forgotpasswordPage = new ForgotPasswordPage();
        }
        return forgotpasswordPage;
    }

    @Override
    public boolean forgotpasswordwithinvaliddata(String message, String regsitered_email, String password, String invalid_email) throws InterruptedException {
        boolean isAlertDisplayed = false;
        boolean isAlertDisplayed_NonExistingEmail = false;
        boolean isPass = false;

        try {

            commonFunctions.clickElement(forgotpasswordLink, 5);
            commonFunctions.clickElement(proceedButton, 5);
            Thread.sleep(2000);
            System.out.println(driver.getPageSource());
            if (driver.getPageSource().contains(message)) {
                isAlertDisplayed = true;
            }
            commonFunctions.sendKey(enteryourregisteredemailInputBox, regsitered_email, 5);
            commonFunctions.clickElement(proceedButton, 5);

            driver.navigate().back();
            driver.navigate().back();
            commonFunctions.sendKey(useridoremailInputBox, regsitered_email, 5);
            commonFunctions.sendKey(passwordInputBox, password, 5);
            //commonFunctions.clickElement(loginButton,5); Forgot_2 Step 2 needs to be placed after fix
            commonFunctions.clickElement(forgotpasswordLink, 5);
            commonFunctions.sendKey(enteryourregisteredemailInputBox, invalid_email, 5);
            commonFunctions.clickElement(proceedButton, 5);

            Thread.sleep(1000);
            if (driver.findElementsByXPath("//*[@text='The inserted Email is not associated with any account']").size() > 0) {
                isAlertDisplayed_NonExistingEmail = true;
            }

            if (isAlertDisplayed && isAlertDisplayed_NonExistingEmail) {
                isPass = true;
            }


            Utils.logFunctionLevelLogs(isAlertDisplayed, "forgotpasswordwithinvaliddata" + globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in forgotpasswordwithinvaliddata method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********forgotpasswordwithinvaliddata method ended" + globalVars.getPlatform() + "*********");
        return isPass;
    }

}

