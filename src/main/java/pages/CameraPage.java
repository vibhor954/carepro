package pages;

import generic_pages.CommonCameraPage;
import generic_pages.CommonMusicPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

import java.util.List;


public class CameraPage extends CommonCameraPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static CameraPage cameraPage;
    private static LoginPage loginPage;


    @AndroidFindBy(id = "com.care_pro:id/tv_enter")
    AndroidElement entertainmentTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Camera']")
    AndroidElement camera;
    @AndroidFindBy(id = "com.android.camera:id/shutter_button")
    AndroidElement takephotoButton;
    @AndroidFindBy(id = "com.android.camera:id/done_button")
    AndroidElement ok;
    @AndroidFindBy(id = "com.care_pro:id/iv_select")
    AndroidElement selectcheckbox;
    @AndroidFindBy(id = "com.care_pro:id/no_text_popup")
    AndroidElement fullsizeButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_delet_icon")
    private static AndroidElement deleteicon;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement yesButton;
    @AndroidFindBy(id = "com.care_pro:id/crop_image_menu_crop")
    AndroidElement crop;




    public CameraPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static CameraPage getCameraPageInstance() {
        if (cameraPage == null) {
            cameraPage = new CameraPage();
        }
        return cameraPage;
    }

    @Override
    public boolean savepic_fullsize() throws InterruptedException {

        boolean isPicSaved=false;
        try {
        //commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(camera, 5);
        commonFunctions.clickElement(takephotoButton,5);
        commonFunctions.clickElement(ok,5);
        commonFunctions.clickElement(fullsizeButton,5);


        if (driver.findElementsByXPath("//android.widget.Toast[@text='Add photo successfully']").size()>0 && driver.findElementsById("com.care_pro:id/iv_photo").size()>0 && driver.findElementsByXPath("//*[@text='Photo Gallery']").size()>0  ){
            isPicSaved=true;
        }
            commonFunctions.clickElement(selectcheckbox,5);
            commonFunctions.clickElement(deleteicon,5);
            commonFunctions.clickElement(yesButton,5);

        } catch (Exception e) {
            Log.error("Exception occurred in savepic_fullsize method " + e.getMessage());
            e.printStackTrace();
        }
        Log.info("********** savepic_fullsize method ended " + globalVars.getPlatform() + "*********");
        return isPicSaved;
    }

    @Override
    public boolean savepic_cropped() throws InterruptedException {
        boolean isPicSaved=false;
        try {
            commonFunctions.clickElement(entertainmentTab, 5);
            commonFunctions.clickElement(camera, 5);
            commonFunctions.clickElement(takephotoButton,5);
            commonFunctions.clickElement(ok,5);
            commonFunctions.clickElement(yesButton,5);
            commonFunctions.clickElement(crop,5);

            if (driver.findElementsByXPath("//android.widget.Toast[@text='Add photo successfully']").size()>0 && driver.findElementsById("com.care_pro:id/iv_photo").size()>0 && driver.findElementsByXPath("//*[@text='Photo Gallery']").size()>0  ){
                isPicSaved=true;
            }
            commonFunctions.clickElement(selectcheckbox,5);
            commonFunctions.clickElement(deleteicon,5);
            commonFunctions.clickElement(yesButton,5);
            commonFunctions.navigateback();

        } catch (Exception e) {
            Log.error("Exception occurred in savepic_cropped method " + e.getMessage());
            e.printStackTrace();
        }
        Log.info("********** savepic_cropped method ended " + globalVars.getPlatform() + "*********");
        return isPicSaved;
    }

}

