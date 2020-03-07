package pages;

import generic_pages.CommonCameraPage;
import generic_pages.CommonMoviePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;


public class MoviePage extends CommonMoviePage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static MoviePage moviePage;
    private static LoginPage loginPage;


    @AndroidFindBy(id = "com.care_pro:id/tv_enter")
    AndroidElement entertainmentTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Movies']")
    AndroidElement movies;
    @AndroidFindBy(id = "com.care_pro:id/add_movie_img")
    AndroidElement addIcon;
    @AndroidFindBy(id = "com.care_pro:id/et_title_addMusic")
    AndroidElement movietitleInputBox;
    @AndroidFindBy(id = "com.care_pro:id/et_description_addMusic")
    AndroidElement moviedescriptionInputBox;
    @AndroidFindBy(id = "com.care_pro:id/et_artics_addMusic")
    AndroidElement artistnameInputBox;
    @AndroidFindBy(id = "com.care_pro:id/tv_fileName_addMusic")
    AndroidElement moviefile;
    @AndroidFindBy(id = "com.care_pro:id/iv_select")
    AndroidElement selectcheckbox;
    @AndroidFindBy(id = "com.care_pro:id/name_artist_popup")
    AndroidElement movietype;
    @AndroidFindBy(id = "com.care_pro:id/iv_delet_icon")
    private static AndroidElement deleteicon;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement yesButton;
    @AndroidFindBy(id = "com.care_pro:id/tv_ImageName_addMusic")
    AndroidElement movieimage;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.GridView/android.widget.FrameLayout[2]/android.widget.ImageView[3]")
    AndroidElement file;
    AndroidElement selectphotofromgallery;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    AndroidElement photos;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Camera']")
    AndroidElement photo;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']")
    AndroidElement photoselect;
    @AndroidFindBy(id = "com.care_pro:id/no_text_popup")
    AndroidElement fullsizeButton;
    @AndroidFindBy(id = "com.care_pro:id/tv_submit_addMusic")
    AndroidElement submitButton;
    @AndroidFindBy(id = "com.care_pro:id/progressMessage")
    AndroidElement uploading;




    public MoviePage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static MoviePage getMoviePageInstance() {
        if (moviePage == null) {
            moviePage = new MoviePage();
        }
        return moviePage;
    }

    @Override
    public boolean addmovie(String title,String description,String type,String artist) throws InterruptedException {

        boolean isPicSaved=false;
        try {
        commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(movies, 5);
        commonFunctions.clickElement(addIcon,5);
        commonFunctions.sendKey(movietitleInputBox,title,5);
        commonFunctions.sendKey(moviedescriptionInputBox,title,5);
        commonFunctions.clickElement(movietype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+type+"']").click();
        commonFunctions.sendKey(artistnameInputBox,artist,5);
        commonFunctions.clickElement(moviefile,5);
        commonFunctions.clickElement(file,5);
        commonFunctions.clickElement(movieimage,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        commonFunctions.clickElement(fullsizeButton,5);
        commonFunctions.clickElement(submitButton,5);
        commonFunctions.waitforelementinvisible(uploading,30);

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


}

