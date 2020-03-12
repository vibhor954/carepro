package pages;

import generic_pages.CommonNotePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

//import io.appium.java_client.android.AndroidKeyCode;

public class NotePage extends CommonNotePage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static NotePage notesPage;
    private static LoginPage loginPage;
    boolean isNoteAdded = false;
    boolean isNoteUpdated = false;
    boolean isVerifySearch=false;
    boolean isVerifyNoteNegativeScenerios=false;


    @AndroidFindBy(id = "com.care_pro:id/tv_concierge")
    AndroidElement conciergeTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select from User']")
    AndroidElement selectfromuser;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.GridView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView")
    AndroidElement note;
    @AndroidFindBy(id = "com.care_pro:id/pickdate_txt")
    AndroidElement selectdate;
    @AndroidFindBy(id = "com.care_pro:id/add_txt")
    AndroidElement addnote;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select to User']")
    AndroidElement selecttouser;
    @AndroidFindBy(xpath = "\"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView")
    AndroidElement fromuser;
    @AndroidFindBy(id = "com.care_pro:id/et_note_dsc")
    AndroidElement descriptioninputBox;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView\n")
    AndroidElement fromText;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView\n")
    AndroidElement to;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView\n")
    AndroidElement touser;
    @AndroidFindBy(id = "com.care_pro:id/tv_make_appoi")
    AndroidElement makeappointmentButton;
    @AndroidFindBy(id = "com.care_pro:id/tv_add_note")
    AndroidElement addnote2;
    @AndroidFindBy(id = "com.care_pro:id/search_edittext")
    AndroidElement searchinputBox;
    @AndroidFindBy(id = "com.care_pro:id/from_pickdate_filter")
    AndroidElement fromdatesearchButton;
    @AndroidFindBy(id = "com.care_pro:id/to_pickdate_filter")
    AndroidElement todatesearchButton;
    @AndroidFindBy(id = "com.care_pro:id/search_filter")
    AndroidElement searchButton;
    @AndroidFindBy(id = "com.care_pro:id/ok")
    AndroidElement okButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_select")
    AndroidElement selectallcheckbox;
    @AndroidFindBy(id = "com.care_pro:id/iv_remove")
    AndroidElement deleteIcon;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement yesButton;
    @AndroidFindBy(id = "com.care_pro:id/no_text_popup")
    AndroidElement noButton;
    @AndroidFindBy(id = "com.care_pro:id/allBtn")
    AndroidElement allsearchButton;
    @AndroidFindBy(id = "com.care_pro:id/tb_doc_appoint")
    AndroidElement setreminderToggle;
    @AndroidFindBy(id = "com.care_pro:id/iv_more")
    private static AndroidElement moreImage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reminder']")
    private static AndroidElement reminder;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Activities and Schedules']")
    private static AndroidElement allactivitiesandschedulesmessage;



    public NotePage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static NotePage getNotesPageInstance() {
        if (notesPage == null) {
            notesPage = new NotePage();
        }
        return notesPage;
    }

    @Override
    public boolean addnote(String from,String description) throws InterruptedException {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(note, 5);
        commonFunctions.clickElement(addnote,5);
        commonFunctions.clickElement(selectfromuser, 5);

        Thread.sleep(1000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView\n").click();
       //commonFunctions.clickElement(fromuser,5);
       String from_text=commonFunctions.getElementText(fromText,5);
        commonFunctions.clickElement(selecttouser,5);
        Thread.sleep(1000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView\n").click();
        String to_text=commonFunctions.getElementText(to,5);
        commonFunctions.sendKey(descriptioninputBox,description,5);
        commonFunctions.clickElement(addnote2,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Note added successfully']").size()>0 ){
            isNoteAdded=true;
        }
        Thread.sleep(1000);
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);

        return isNoteAdded;

    }

    @Override
    public boolean note_negativescenerios(String from, String description) throws InterruptedException {
//        commonFunctions.clickElement(conciergeTab, 5);
//        commonFunctions.clickElement(note, 5);
        commonFunctions.clickElement(addnote,5);
        commonFunctions.clickElement(addnote2,5);
        commonFunctions.clickElement(selectfromuser, 5);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView\n").click();
        //commonFunctions.clickElement(fromuser,5);
        String from_text=commonFunctions.getElementText(fromText,5);
        commonFunctions.clickElement(selecttouser,5);
        Thread.sleep(1000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView\n").click();
        String to_text=commonFunctions.getElementText(to,5);
        commonFunctions.sendKey(descriptioninputBox,description,5);
        commonFunctions.clickElement(addnote2,5);
        commonFunctions.clickElement(deleteIcon,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please select note']").size()>0 ){
            isVerifyNoteNegativeScenerios=true;
        }
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(noButton,5);
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please select note']").size()>0 ){
            isVerifyNoteNegativeScenerios=true;
        }
        else{
            isVerifyNoteNegativeScenerios=false;
        }
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);
        return isVerifyNoteNegativeScenerios;
    }


    @Override
    public boolean updatenote(String from,String description,String updated) throws InterruptedException {
//        commonFunctions.clickElement(conciergeTab, 5);
//        commonFunctions.clickElement(note, 5);
        commonFunctions.clickElement(addnote,5);
        commonFunctions.clickElement(selectfromuser, 5);

        Thread.sleep(1000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView\n").click();
        //commonFunctions.clickElement(fromuser,5);
        String from_text=commonFunctions.getElementText(fromText,5);
        commonFunctions.clickElement(selecttouser,5);
        Thread.sleep(1000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView\n").click();
        String to_text=commonFunctions.getElementText(to,5);
        commonFunctions.sendKey(descriptioninputBox,description,5);
        commonFunctions.clickElement(addnote2,5);
        Thread.sleep(1000);

        driver.findElementByXPath("//android.widget.TextView[@text='"+from_text+"']").click();
        commonFunctions.clear(descriptioninputBox,5);
        commonFunctions.sendKey(descriptioninputBox,updated,5);
        commonFunctions.clickElement(addnote2,5);

        if (driver.findElementsByXPath("//android.widget.Toast[@text='Note updated successfully']").size()>0 ){
            isNoteUpdated=true;
        }
        Thread.sleep(1000);
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);

        return isNoteUpdated;

    }

    @Override
    public boolean verifysearch(String from, String description) throws InterruptedException {
//        commonFunctions.clickElement(conciergeTab, 5);
//        commonFunctions.clickElement(note, 5);
        commonFunctions.clickElement(addnote,5);
        commonFunctions.clickElement(selectfromuser, 5);

        Thread.sleep(1000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView\n").click();
        //commonFunctions.clickElement(fromuser,5);
        String from_text=commonFunctions.getElementText(fromText,5);
        commonFunctions.clickElement(selecttouser,5);
        Thread.sleep(1000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView\n").click();
        String to_text=commonFunctions.getElementText(to,5);
        commonFunctions.sendKey(descriptioninputBox,description,5);
        commonFunctions.clickElement(addnote2,5);
        Thread.sleep(1000);
        commonFunctions.sendKey(searchinputBox,from_text,5);
        if (driver.findElementsByXPath("//*[@text='"+from_text+"']").size()>0){
            isVerifySearch=true;
        }
        return isVerifySearch;
    }


}

