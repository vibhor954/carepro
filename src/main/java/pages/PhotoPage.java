package pages;

import generic_pages.CommonNotePage;
import generic_pages.CommonPhotoPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

//import io.appium.java_client.android.AndroidKeyCode;

public class PhotoPage extends CommonPhotoPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static PhotoPage photoPage;
    private static LoginPage loginPage;
    boolean isNoteAdded = false;
    boolean isNoteUpdated = false;
    boolean isVerifySearch=false;
    boolean isVerifyNoteNegativeScenerios=false;


    @AndroidFindBy(id = "com.care_pro:id/tv_enter")
    AndroidElement entertainmentTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photo']")
    AndroidElement photo;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photo Gallery']")
    AndroidElement photogallery;
    @AndroidFindBy(id = "com.care_pro:id/rl_add")
    AndroidElement addphotoButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_add_icon")
    AndroidElement addIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select photo from gallery']")
    AndroidElement selectphotofromgallery;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    AndroidElement photos;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView\n")
    AndroidElement fromText;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']")
    AndroidElement photoselect;
    @AndroidFindBy(id = "com.care_pro:id/crop_image_menu_crop")
    AndroidElement crop;
    @AndroidFindBy(id = "com.care_pro:id/bt_submit")
    AndroidElement submitButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Capture photo from camera']")
    AndroidElement selectphotofromcamera;
    @AndroidFindBy(id = "com.android.camera:id/shutter_button")
    AndroidElement takephotoButton;
    @AndroidFindBy(id = "com.care_pro:id/tv_slide_photo")
    AndroidElement slidephoto;
    @AndroidFindBy(id = "com.android.camera:id/done_button")
    AndroidElement okButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_fav_icon")
    AndroidElement favicon;
    @AndroidFindBy(id = "com.care_pro:id/iv_fav")
    AndroidElement favicon2;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement yesButton;
    @AndroidFindBy(id = "com.care_pro:id/no_text_popup")
    AndroidElement noButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_select")
    AndroidElement selectcheckbox;
    @AndroidFindBy(id = "com.care_pro:id/tv_fav")
    AndroidElement favoritephoto;
    @AndroidFindBy(id = "com.care_pro:id/tv_delete")
    private static AndroidElement unfavoritephoto;
    @AndroidFindBy(id = "com.care_pro:id/iv_delet_icon")
    private static AndroidElement deleteicon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Activities and Schedules']")
    private static AndroidElement allactivitiesandschedulesmessage;



    public PhotoPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static PhotoPage getPhotoPageInstance() {
        if (photoPage == null) {
            photoPage = new PhotoPage();
        }
        return photoPage;
    }

    @Override
    public boolean addphotofromgallery_crop(String folder) throws InterruptedException {
        boolean isPhotoAdded=false;
        commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(photo, 5);
        commonFunctions.clickElement(photogallery,5);
        commonFunctions.clickElement(addphotoButton,5);
        commonFunctions.clickElement(addIcon, 5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+folder+"']").click();
        commonFunctions.clickElement(photoselect,5);
        commonFunctions.clickElement(yesButton,5);
        commonFunctions.clickElement(crop,5);
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Add photo successfully']").size()>0){
            isPhotoAdded=true;
        }
        Thread.sleep(2000);
        if(driver.findElementsById("com.care_pro:id/tv_no_data").size()==0){
            isPhotoAdded=true;
        }
        else
        {
            isPhotoAdded=false;
        }

        return isPhotoAdded;
    }

    @Override
    public boolean addphotofromgallery_full(String folder) throws InterruptedException {
        boolean isPhotoAdded=false;
        commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(photo, 5);
        commonFunctions.clickElement(photogallery,5);
        commonFunctions.clickElement(addphotoButton,5);
        commonFunctions.clickElement(addIcon, 5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+folder+"']").click();
        commonFunctions.clickElement(photoselect,5);
        commonFunctions.clickElement(noButton,5);
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Add photo successfully']").size()>0){
            isPhotoAdded=true;
        }
        Thread.sleep(2000);
        if(driver.findElementsById("com.care_pro:id/tv_no_data").size()==0){
            isPhotoAdded=true;
        }
        else
        {
            isPhotoAdded=false;
        }

        return isPhotoAdded;
    }

    @Override
    public boolean addphotofromcamera_crop() throws InterruptedException {
        boolean isPhotoAdded=false;
        commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(photo, 5);
        commonFunctions.clickElement(photogallery,5);
        commonFunctions.clickElement(addphotoButton,5);
        commonFunctions.clickElement(addIcon, 5);
        commonFunctions.clickElement(selectphotofromcamera,5);
        commonFunctions.clickElement(takephotoButton,5);
        commonFunctions.clickElement(okButton,5);
        commonFunctions.clickElement(yesButton,5);
        commonFunctions.clickElement(crop,5);
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Add photo successfully']").size()>0){
            isPhotoAdded=true;
        }
        Thread.sleep(2000);
        if(driver.findElementsById("com.care_pro:id/tv_no_data").size()==0){
            isPhotoAdded=true;
        }
        else
        {
            isPhotoAdded=false;
        }
        return isPhotoAdded;
    }

    @Override
    public boolean addphotofromcamera_full() throws InterruptedException {
        boolean isPhotoAdded=false;
        commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(photo, 5);
        commonFunctions.clickElement(photogallery,5);
        commonFunctions.clickElement(addphotoButton,5);
        commonFunctions.clickElement(addIcon, 5);
        commonFunctions.clickElement(selectphotofromcamera,5);
        commonFunctions.clickElement(takephotoButton,5);
        commonFunctions.clickElement(okButton,5);
        commonFunctions.clickElement(noButton,5);
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Add photo successfully']").size()>0){
            isPhotoAdded=true;
        }
        Thread.sleep(2000);
        if(driver.findElementsById("com.care_pro:id/tv_no_data").size()==0){
            isPhotoAdded=true;
        }
        else
        {
            isPhotoAdded=false;
        }
        return isPhotoAdded;
    }

    @Override
    public boolean slidephoto() throws InterruptedException {
        boolean isSlidePhoto=false;
        commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(photo, 5);
        commonFunctions.clickElement(photogallery,5);
        commonFunctions.clickElement(slidephoto,5);
        if (driver.findElementsByXPath("//android.widget.TextView[@text='Slide Photo']").size()>0){
            isSlidePhoto=true;
        }

        return isSlidePhoto;
    }

    @Override
    public boolean choosefavoritephoto(String folder) throws InterruptedException {
        boolean isFavouritePhoto=false;
        boolean isUnfavouritePhoto=false;
        commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(photo, 5);
        commonFunctions.clickElement(photogallery,5);
        commonFunctions.clickElement(addphotoButton,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(addIcon, 5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+folder+"']").click();
        commonFunctions.clickElement(photoselect,5);
        commonFunctions.clickElement(noButton,5);
        commonFunctions.clickElement(submitButton,5);
        commonFunctions.navigateback();
        commonFunctions.clickElement(photogallery,5);
        commonFunctions.clickElement(favicon2,5);
        commonFunctions.clickElement(favoritephoto,5);
        Thread.sleep(1000);
        if (driver.findElementsById("com.care_pro:id/iv_fav").size()>0 && driver.findElementsById("com.care_pro:id/tv_delete").size()>0 && driver.findElementsByXPath("//\tandroid.widget.TextView[@text='Favorite Photos']").size()>0){
            isFavouritePhoto=true;
        }
        commonFunctions.clickElement(selectcheckbox,5);
        commonFunctions.clickElement(unfavoritephoto,5);


        if (driver.findElementsByXPath("//android.widget.Toast[@text='Unfavorite photo successfully']").size()>0){
            isUnfavouritePhoto=true;
        }
        commonFunctions.navigateback();
        commonFunctions.clickElement(selectcheckbox,5);
        commonFunctions.clickElement(deleteicon,5);
        commonFunctions.clickElement(yesButton,5);
        if(isFavouritePhoto && isUnfavouritePhoto ){
            isFavouritePhoto=true;
        }



        return isFavouritePhoto;
    }

    @Override
    public boolean negativescenerios(String folder) throws InterruptedException {
        isVerifyNoteNegativeScenerios=false;
        commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(photo, 5);
        commonFunctions.clickElement(photogallery,5);
        commonFunctions.clickElement(addphotoButton,5);
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please choose a photo']").size()>0){
            isVerifyNoteNegativeScenerios=true;
        }
        commonFunctions.navigateback();
        commonFunctions.navigateback();
        commonFunctions.clickElement(photogallery,5);
        commonFunctions.clickElement(addphotoButton,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(addIcon, 5);
        commonFunctions.clickElement(selectphotofromcamera,5);
        commonFunctions.navigateback();
        if (driver.findElementsById("com.care_pro:id/iv_add_icon").size()>0){
            isVerifyNoteNegativeScenerios=true;
        }
        else{
            isVerifyNoteNegativeScenerios=false;
        }
        commonFunctions.navigateback();
        commonFunctions.clickElement(addIcon, 5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+folder+"']").click();
        commonFunctions.clickElement(photoselect,5);
        commonFunctions.clickElement(noButton,5);
        commonFunctions.clickElement(submitButton,5);
        commonFunctions.navigateback();
        commonFunctions.clickElement(photogallery,5);
        commonFunctions.clickElement(deleteicon,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please select photo']").size()>0){
            isVerifyNoteNegativeScenerios=true;
        }

        return isVerifyNoteNegativeScenerios;
    }


}

