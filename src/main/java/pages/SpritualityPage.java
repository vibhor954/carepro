package pages;

import generic_pages.CommonEmailPage;
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

public class SpritualityPage extends CommonSpritualityPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static SpritualityPage spritualityPage;
    private static LoginPage loginPage;
    boolean isMeditationCourse=false;
    boolean isSpritualVideos=false;




    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Spirituality']")
    AndroidElement sprituality;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Meditation Course']")
    AndroidElement meditationcourse;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Spiritual Videos']")
    AndroidElement spritualvideos;




    public SpritualityPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static SpritualityPage getSpritualityPageInstance() {
        if (spritualityPage == null) {
            spritualityPage = new SpritualityPage();
        }
        return spritualityPage;
    }

    @Override
    public boolean spritualitymeditation() {


        try {
            //commonFunctions.clickElement(email,5);
            commonFunctions.clickElement(sprituality, 5);
            commonFunctions.clickElement(meditationcourse, 5);
            Thread.sleep(2000);
            if (driver.findElementsByXPath("//android.widget.TextView[@text='Meditation Course']").size()>0){
                isMeditationCourse=true;
            }
            driver.navigate().back();
            driver.navigate().back();
            Utils.logFunctionLevelLogs(isMeditationCourse, "spritaulitymeditation" + globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in spritaulitymeditation method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********spritaulitymeditation method ended" + globalVars.getPlatform() + "*********");

        return isMeditationCourse;
    }

    @Override
    public boolean spritualityspritualvideos() {
        try {

            commonFunctions.clickElement(sprituality, 5);
            commonFunctions.clickElement(spritualvideos, 5);
            Thread.sleep(2000);
            commonFunctions.scrolldown();
            Thread.sleep(2000);

            if (driver.findElementsByXPath("//android.widget.TextView[@text='Watch now']").size()>0){
                isSpritualVideos=true;
            }
            driver.navigate().back();
            driver.navigate().back();
            Utils.logFunctionLevelLogs(isSpritualVideos, "spritualityspritualvideos" + globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in spritualityspritualvideos method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********spritualityspritualvideos method ended" + globalVars.getPlatform() + "*********");

        return isSpritualVideos;
    }


}

