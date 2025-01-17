package pages;

import generic_pages.CommonArticlesPage;
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


public class MusicPage extends CommonMusicPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static MusicPage musicPage;
    private static LoginPage loginPage;


    @AndroidFindBy(id = "com.care_pro:id/tv_enter")
    AndroidElement entertainmentTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Music']")
    AndroidElement music;
    @AndroidFindBy(id = "com.care_pro:id/name_artist_popup")
    AndroidElement musictype;
    @AndroidFindBy(id = "com.care_pro:id/add_music_music")
    AndroidElement addicon;
    @AndroidFindBy(id = "com.care_pro:id/et_title_addMusic")
    AndroidElement musictitleInputBox;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Health']")
    AndroidElement health;
    @AndroidFindBy(id = "com.care_pro:id/et_description_addMusic")
    AndroidElement musicdescriptionInputBox;
    @AndroidFindBy(id = "com.care_pro:id/et_artics_addMusic")
    AndroidElement artistnameInputBox;
    @AndroidFindBy(id = "com.care_pro:id/tv_fileName_addMusic")
    AndroidElement musicfile;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select photo from gallery']")
    AndroidElement selectphotofromgallery;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    AndroidElement photos;
    @AndroidFindBy(id = "com.care_pro:id/rl_add_test")
    AndroidElement sentButton;
    @AndroidFindBy(id = "com.care_pro:id/tv_ImageName_addMusic")
    AndroidElement musicimageicon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Camera']")
    AndroidElement photo;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']")
    AndroidElement photoselect;
    @AndroidFindBy(id = "com.care_pro:id/tv_submit_addMusic")
    AndroidElement submitButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_menu_articleDetails")
    AndroidElement articledetails;
    @AndroidFindBy(id = "com.care_pro:id/iv_select")
    AndroidElement selectcheckbox;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement yespopupButton;
    @AndroidFindBy(id = "com.care_pro:id/no_text_popup")
    AndroidElement fullsizeButton;
    @AndroidFindBy(id = "com.android.documentsui:id/icon_mime")
    private static AndroidElement fileselect;
    @AndroidFindBy(id = "com.care_pro:id/iv_update_addMusic")
    private static AndroidElement tickIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete Music']")
    private static AndroidElement delete;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Music']")
    private static AndroidElement editmusic;
    @AndroidFindBy(id = "com.care_pro:id/iv_more_musiclist_item")
    private static AndroidElement listitem;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='See all']")
    private static AndroidElement seeall;
    @AndroidFindBy(id = "com.care_pro:id/iv_player_icon")
    private static AndroidElement playicon;
    @AndroidFindBy(id = "com.care_pro:id/lv_play_musicplay")
    private static AndroidElement pauseicon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Get Info']")
    private static AndroidElement getinfo;
    @AndroidFindBy(id = "com.care_pro:id/iv_download_musiclist_item")
    private static AndroidElement downloadicon;




    public MusicPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static MusicPage getMusicPageInstance() {
        if (musicPage == null) {
            musicPage = new MusicPage();
        }
        return musicPage;
    }

    @Override
    public boolean addmusic(String title,String description,String type,String artist) throws InterruptedException {
        boolean isAddMusic=false;
        commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(music, 5);
        commonFunctions.clickElement(addicon,5);
        commonFunctions.sendKey(musictitleInputBox,title,5);
        commonFunctions.sendKey(musicdescriptionInputBox,description,5);
        commonFunctions.clickElement(musictype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+type+"']").click();
        commonFunctions.sendKey(artistnameInputBox,artist,5);
        commonFunctions.clickElement(musicfile,5);
        commonFunctions.clickElement(fileselect,5);
        commonFunctions.clickElement(musicimageicon,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        //Thread.sleep(1000);
        commonFunctions.clickElement(fullsizeButton,5);
       // Thread.sleep(2000);
        commonFunctions.clickElement(submitButton,5);

        Thread.sleep(10000);
        System.out.println(driver.getPageSource());

        if (driver.getPageSource().contains(title)){
            isAddMusic=true;
        }
      List<WebElement> el= driver.findElementsByXPath("//*[@text='See all']");
        el.get(1).click();
        Thread.sleep(2000);
        if (driver.getPageSource().contains(title)){
            isAddMusic=true;
        }
        commonFunctions.clickElement(listitem,5);
        commonFunctions.clickElement(delete,5);
        commonFunctions.clickElement(yespopupButton,5);

        return isAddMusic;
    }

    @Override
    public boolean updatemusic(String title,String description,String type,String artist,String updated) throws InterruptedException {
        boolean isUpdateMusic=false;
//        commonFunctions.clickElement(entertainmentTab, 5);
//        commonFunctions.clickElement(music, 5);
        commonFunctions.navigateback();
        commonFunctions.clickElement(addicon,5);
        commonFunctions.sendKey(musictitleInputBox,title,5);
        commonFunctions.sendKey(musicdescriptionInputBox,description,5);
        commonFunctions.clickElement(musictype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+type+"']").click();
        commonFunctions.sendKey(artistnameInputBox,artist,5);
        commonFunctions.clickElement(musicfile,5);
        commonFunctions.clickElement(fileselect,5);
        commonFunctions.clickElement(musicimageicon,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        commonFunctions.clickElement(fullsizeButton,5);
        commonFunctions.clickElement(submitButton,5);

        Thread.sleep(10000);

        List<WebElement> el= driver.findElementsByXPath("//*[@text='See all']");
        el.get(1).click();
        Thread.sleep(2000);
        if (driver.getPageSource().contains(title)){
            isUpdateMusic=true;
        }
        commonFunctions.clickElement(listitem,5);
        commonFunctions.clickElement(editmusic,5);
        commonFunctions.clear(musictitleInputBox,5);
        commonFunctions.sendKey(musictitleInputBox,updated,5);
        commonFunctions.clickElement(tickIcon,5);
        Thread.sleep(4000);
        if (driver.findElementsByXPath("//android.widget.TextView[@text='"+updated+"']").size()>0){
            isUpdateMusic=true;
        }
        commonFunctions.clickElement(listitem,5);
        commonFunctions.clickElement(delete,5);
        commonFunctions.clickElement(yespopupButton,5);

        return isUpdateMusic;
    }

    @Override
    public boolean play_pause() {
        boolean isPlayPause=false;
        //commonFunctions.clickElement(entertainmentTab, 5);
        //commonFunctions.clickElement(music, 5);
        commonFunctions.navigateback();
        commonFunctions.clickElement(playicon,5);
        commonFunctions.clickElement(pauseicon,5);
        isPlayPause= commonFunctions.clickElement(pauseicon,5);

        return isPlayPause;
    }

    @Override
    public boolean selectmusicasfavorite_unfavorite(String title, String description, String type, String artist) throws InterruptedException {

        boolean isfavorite=false;
        boolean isunfavorite=false;
        try {
            commonFunctions.navigateback();
        //commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(music, 5);
        commonFunctions.clickElement(addicon,5);
        commonFunctions.sendKey(musictitleInputBox,title,5);
        commonFunctions.sendKey(musicdescriptionInputBox,description,5);
        commonFunctions.clickElement(musictype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+type+"']").click();
        commonFunctions.sendKey(artistnameInputBox,artist,5);
        commonFunctions.clickElement(musicfile,5);
        commonFunctions.clickElement(fileselect,5);
        commonFunctions.clickElement(musicimageicon,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        commonFunctions.clickElement(fullsizeButton,5);
        commonFunctions.clickElement(submitButton,5);

        Thread.sleep(10000);
        commonFunctions.scrolldown();
        Thread.sleep(1000);
        commonFunctions.scrolldown();
        Thread.sleep(1000);
        commonFunctions.scrolldown();
        Thread.sleep(1000);
        System.out.println(driver.findElementsById("com.care_pro:id/iv_musicFav").size());
       List<WebElement> el= driver.findElementsById("com.care_pro:id/iv_musicFav");
       el.get(2).click();
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Favorite successfully']").size()>0 && driver.findElementsByXPath("//android.widget.TextView[@text='Favourite']").size()>0){
            isfavorite=true;
        }
        el= driver.findElementsById("com.care_pro:id/iv_musicFav");
        el.get(2).click();
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Unfavorite successfully']").size()>0){
            isunfavorite=true;
        }
        if(isfavorite && isunfavorite){
            isfavorite=true;
        }
        else {
            isfavorite=false;
        }
        commonFunctions.navigateback();
        commonFunctions.clickElement(music,5);
        List<WebElement> element= driver.findElementsByXPath("//*[@text='See all']");
        element.get(1).click();
        commonFunctions.clickElement(listitem,5);
        commonFunctions.clickElement(delete,5);
        commonFunctions.clickElement(yespopupButton,5);
        } catch (Exception e) {
            Log.error("Exception occurred in selectmusicasfavorite_unfavorite method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("********** selectmusicasfavorite_unfavorite method ended" + globalVars.getPlatform() + "*********");
        return isfavorite;
    }

    @Override
    public boolean getinfo_download(String title, String description, String type, String artist) throws InterruptedException {
        boolean isVerifyGetInfo=false;
        boolean isDownload=false;
        try{
            //        commonFunctions.clickElement(entertainmentTab, 5);
//        commonFunctions.clickElement(music, 5);
            commonFunctions.navigateback();
        commonFunctions.clickElement(addicon,5);
        commonFunctions.sendKey(musictitleInputBox,title,5);
        commonFunctions.sendKey(musicdescriptionInputBox,description,5);
        commonFunctions.clickElement(musictype,5);
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+type+"']").click();
        commonFunctions.sendKey(artistnameInputBox,artist,5);
        commonFunctions.clickElement(musicfile,5);
        commonFunctions.clickElement(fileselect,5);
        commonFunctions.clickElement(musicimageicon,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        commonFunctions.clickElement(fullsizeButton,5);
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(80000);
        List<WebElement> el= driver.findElementsByXPath("//*[@text='See all']");
        el.get(1).click();
        commonFunctions.clickElement(listitem,5);
        commonFunctions.clickElement(delete,5);
        commonFunctions.clickElement(yespopupButton,5);
        commonFunctions.clickElement(listitem,5);
        commonFunctions.clickElement(getinfo,5);
        Thread.sleep(1000);
        if (driver.findElementsById("com.care_pro:id/tv_startDuration_musicdetail").size()>0 && driver.findElementsById("com.care_pro:id/tv_totalDuration_musicdetail").size()>0 &&  driver.findElementsById("com.care_pro:id/iv_play_musicdetail").size()>0){
            isVerifyGetInfo=true;
        }
        commonFunctions.navigateback();
        commonFunctions.clickElement(downloadicon,5);
            if (driver.findElementsById("android:id/progress").size()>0){
                isDownload=true;
            }
            if (isVerifyGetInfo && isDownload){
                isVerifyGetInfo=true;
            }
        } catch (Exception e) {
            Log.error("Exception occurred in getinfo_download method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("********** getinfo_download method ended " + globalVars.getPlatform() + "*********");

        return isVerifyGetInfo;
    }


}

