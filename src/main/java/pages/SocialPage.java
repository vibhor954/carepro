package pages;

import generic_pages.CommonSocialPage;
import generic_pages.CommonSpritualityPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Utils;

//import io.appium.java_client.android.AndroidKeyCode;

public class SocialPage extends CommonSocialPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static SocialPage socialPage;
    private static LoginPage loginPage;
    boolean isFacebookVerified=false;
    boolean isTwitterVerified=false;




    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Social']")
    AndroidElement social;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Facebook']")
    AndroidElement facebook;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Twitter']")
    AndroidElement twitter;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log in']")
    AndroidElement twitterloginButton;
    @AndroidFindBy(xpath = "//android.view.View[@text='Log in to Twitter']")
    AndroidElement twitterlogintext;




    public SocialPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static SocialPage getSocialPageInstance() {
        if (socialPage == null) {
            socialPage = new SocialPage();
        }
        return socialPage;
    }




    @Override
    public boolean verifyfacebook() {
        try {
            commonFunctions.clickElement(social, 5);
            commonFunctions.clickElement(facebook, 5);
            Thread.sleep(2000);
            if (driver.findElementsByAccessibilityId("CREATE NEW FACEBOOK ACCOUNT").size()>0){
                isFacebookVerified=true;
            }
            driver.navigate().back();
            Utils.logFunctionLevelLogs(isFacebookVerified, "verifyfacebook" + globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in verifyfacebook method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********verifyfacebook method ended" + globalVars.getPlatform() + "*********");

        return isFacebookVerified;
    }

    @Override
    public boolean verifytwitter() {
        try {
            commonFunctions.clickElement(twitter, 5);
            commonFunctions.clickElement(twitterloginButton,5);
            Thread.sleep(4000);
            if (driver.findElementsByXPath("//android.view.View[@text='Log in to Twitter']").size()>0){
                isTwitterVerified=true;
            }
            commonFunctions.navigateback();
            commonFunctions.navigateback();
            commonFunctions.navigateback();
            commonFunctions.navigateback();
            Utils.logFunctionLevelLogs(isTwitterVerified, "verifytwitter" + globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in verifytwitter method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********verifytwitter method ended" + globalVars.getPlatform() + "*********");

        return isTwitterVerified;
    }
}

