package pages;

import generic_pages.CommonArticlesPage;
import generic_pages.CommonTestReportPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

import java.util.List;


public class ArticlesPage extends CommonArticlesPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static ArticlesPage articlesPage;
    private static LoginPage loginPage;


    @AndroidFindBy(id = "com.care_pro:id/tv_enter")
    AndroidElement entertainmentTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Articles']")
    AndroidElement articles;
    @AndroidFindBy(id = "com.care_pro:id/rl_add")
    AndroidElement uploadnewtestreportButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_addArticles_list")
    AndroidElement addicon;
    @AndroidFindBy(id = "com.care_pro:id/et_title_addArticle")
    AndroidElement articletitleInputBox;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Health']")
    AndroidElement health;
    @AndroidFindBy(id = "com.care_pro:id/et_description_addArticle")
    AndroidElement articledescriptionInputBox;
    @AndroidFindBy(id = "com.care_pro:id/et_artic_name_addArticle")
    AndroidElement artistnameInputBox;
    @AndroidFindBy(id = "com.care_pro:id/tv_artist_image_addArticle")
    AndroidElement artistimageicon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select photo from gallery']")
    AndroidElement selectphotofromgallery;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    AndroidElement photos;
    @AndroidFindBy(id = "com.care_pro:id/rl_add_test")
    AndroidElement sentButton;
    @AndroidFindBy(id = "com.care_pro:id/tv_article_image_addArticle")
    AndroidElement articleimageicon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Camera']")
    AndroidElement photo;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']")
    AndroidElement photoselect;
    @AndroidFindBy(id = "com.care_pro:id/tv_submit_addArticle")
    AndroidElement submitButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_menu_articleDetails")
    AndroidElement articledetails;
    @AndroidFindBy(id = "com.care_pro:id/iv_select")
    AndroidElement selectcheckbox;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement yespopupButton;
    @AndroidFindBy(id = "com.care_pro:id/no_text_popup")
    AndroidElement fullsizeButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit']")
    private static AndroidElement edit;
    @AndroidFindBy(id = "com.care_pro:id/iv_update_addArticle")
    private static AndroidElement tickIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
    private static AndroidElement delete;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"TODO\"])[13]")
    private static AndroidElement favarticle;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"TODO\"])[12]")
    private static AndroidElement unfavarticle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='See all']")
    private static AndroidElement seeall;



    public ArticlesPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static ArticlesPage getArticlesPageInstance() {
        if (articlesPage == null) {
            articlesPage = new ArticlesPage();
        }
        return articlesPage;
    }

    @Override
    public boolean addarticle(String title,String description,String artist) throws InterruptedException {
        boolean isAddArticle=false;
        commonFunctions.clickElement(entertainmentTab, 5);
        commonFunctions.clickElement(articles, 5);
        commonFunctions.clickElement(addicon,5);
        commonFunctions.sendKey(articletitleInputBox,title,5);
        commonFunctions.sendKey(articledescriptionInputBox,description,5);
        commonFunctions.sendKey(artistnameInputBox,artist,5);
        commonFunctions.clickElement(artistimageicon,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(fullsizeButton,5);
        commonFunctions.clickElement(articleimageicon,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(fullsizeButton,5);
        commonFunctions.clickElement(submitButton,5);
        commonFunctions.clickElement(health,5);
        if (driver.findElementsByXPath("//android.widget.TextView[@text='"+title+"']").size()>0){
            isAddArticle=true;
        }
        driver.findElementByXPath("//android.widget.TextView[@text='"+title+"']").click();
        commonFunctions.clickElement(articledetails,5);
        commonFunctions.clickElement(delete,5);
        commonFunctions.clickElement(yespopupButton,5);
        Thread.sleep(2000);
        //commonFunctions.navigateback();
        //commonFunctions.navigateback();



        return isAddArticle;
    }

    @Override
    public boolean updatearticle(String title, String description, String artist, String update) throws InterruptedException {
        boolean isUpdateArticle=false;
        //commonFunctions.clickElement(entertainmentTab, 5);
        //commonFunctions.clickElement(articles, 5);
        commonFunctions.navigateback();
        commonFunctions.clickElement(addicon,5);
        commonFunctions.sendKey(articletitleInputBox,title,5);
        commonFunctions.sendKey(articledescriptionInputBox,description,5);
        commonFunctions.sendKey(artistnameInputBox,artist,5);
        commonFunctions.clickElement(artistimageicon,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(fullsizeButton,5);
        commonFunctions.clickElement(articleimageicon,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(fullsizeButton,5);
        commonFunctions.clickElement(submitButton,5);
        commonFunctions.clickElement(health,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+title+"']").click();
        commonFunctions.clickElement(articledetails,5);
        commonFunctions.clickElement(edit,5);
        commonFunctions.clear(articledescriptionInputBox,5);
        commonFunctions.sendKey(articledescriptionInputBox,update,5);
        commonFunctions.clickElement(tickIcon,5);
        if (driver.findElementsByXPath("//android.widget.TextView[@text='"+update+"']").size()>0 && driver.findElementsByXPath("//android.widget.Toast[@text='article update successfully']").size()>0){
            isUpdateArticle=true;
        }
        commonFunctions.clickElement(articledetails,5);
        commonFunctions.clickElement(delete,5);
        commonFunctions.clickElement(yespopupButton,5);



        return isUpdateArticle;
    }

    @Override
    public boolean selectarticleasfavorite(String title,String description,String artist) throws InterruptedException {
        boolean isFavoriteArticle=false;
        commonFunctions.navigateback();
//        commonFunctions.clickElement(entertainmentTab, 5);
//        commonFunctions.clickElement(articles, 5);
        commonFunctions.clickElement(addicon,5);
        commonFunctions.sendKey(articletitleInputBox,title,5);
        commonFunctions.sendKey(articledescriptionInputBox,description,5);
        commonFunctions.sendKey(artistnameInputBox,artist,5);
        commonFunctions.clickElement(artistimageicon,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(fullsizeButton,5);
        commonFunctions.clickElement(articleimageicon,5);
        commonFunctions.clickElement(selectphotofromgallery,5);
        commonFunctions.clickElement(photos,5);
        commonFunctions.clickElement(photo,5);
        commonFunctions.clickElement(photoselect,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(fullsizeButton,5);
        commonFunctions.clickElement(submitButton,5);
        commonFunctions.clickElement(health,5);
       List<WebElement> el=driver.findElementsById("com.care_pro:id/iv_articleFav");
       el.get(2).click();
       // commonFunctions.clickElement(favarticle,5);
        commonFunctions.clickElement(seeall,5);
        Thread.sleep(2000);
        if (driver.getPageSource().contains(title)){
            isFavoriteArticle=true;
        }
        commonFunctions.navigateback();
        Thread.sleep(1000);
        commonFunctions.scrolldown();
        Thread.sleep(1000);
        commonFunctions.scrolldown();
        Thread.sleep(1000);
        commonFunctions.scrolldown();
        Thread.sleep(1000);
        commonFunctions.scrolldown();
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.TextView[@text='Favourite']").size()>0 && driver.findElementsByXPath("//android.widget.TextView[@text='"+title+"']").size()==3){
            isFavoriteArticle=true;
        }
        el=driver.findElementsById("com.care_pro:id/iv_articleFav");
        el.get(2).click();
        if (driver.findElementsByXPath("//android.widget.TextView[@text='"+title+"']").size()==2){
            isFavoriteArticle=true;
        }
        else{
            isFavoriteArticle=false;
        }
        driver.findElementByXPath("//android.widget.TextView[@text='"+title+"']").click();
        commonFunctions.clickElement(articledetails,5);
        commonFunctions.clickElement(delete,5);
        commonFunctions.clickElement(yespopupButton,5);




//        commonFunctions.clickElement(selectcheckbox,5);
//        commonFunctions.clickElement(deleteicon,5);
//        commonFunctions.clickElement(yespopupButton,5);

        return isFavoriteArticle;
    }


}

