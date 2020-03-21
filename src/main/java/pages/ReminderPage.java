package pages;

import generic_pages.CommonCameraPage;
import generic_pages.CommonReminderPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;


public class ReminderPage extends CommonReminderPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static ReminderPage reminderPage;
    private static LoginPage loginPage;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reminder']")
    AndroidElement reminder;
    @AndroidFindBy(id = "com.care_pro:id/tv_add_reminder")
    AndroidElement addreminder;
    @AndroidFindBy(id = "com.care_pro:id/et_title")
    AndroidElement remindertitleInputBox;
    @AndroidFindBy(id = "com.care_pro:id/iv_select")
    AndroidElement selectcheckbox;
    @AndroidFindBy(id = "com.care_pro:id/btn_submit_reminder")
    AndroidElement submitreminder;
    @AndroidFindBy(id = "com.care_pro:id/iv_remove")
    private static AndroidElement deleteicon;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement yesButton;
    @AndroidFindBy(id = "com.care_pro:id/tv_when_time")
    AndroidElement time;
    @AndroidFindBy(id = "android:id/minutes")
    AndroidElement minutes;
    @AndroidFindBy(id = "com.care_pro:id/alarm_title_text")
    AndroidElement alarmtitle;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    AndroidElement ok;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Clock']")
    AndroidElement clock;
    @AndroidFindBy(id = "android:id/toggle_mode")
    AndroidElement toggle;
    @AndroidFindBy(id = "android:id/input_minute")
    AndroidElement toggleminutes;



    public ReminderPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static ReminderPage getReminderPageInstance() {
        if (reminderPage == null) {
            reminderPage = new ReminderPage();
        }
        return reminderPage;
    }

    @Override
    public boolean addreminder(String title) throws InterruptedException {
        int mins=0;
        int mints=0;
        boolean isReminderAdded=false;
        try {
            Thread.sleep(2000);
        commonFunctions.scrolldown();
        commonFunctions.clickElement(reminder, 5);
        commonFunctions.clickElement(addreminder,5);
        commonFunctions.sendKey(remindertitleInputBox,title,5);
        commonFunctions.clickElement(time,5);
        commonFunctions.clickElement(toggle,5);
       String minutes_text=commonFunctions.getElementText(toggleminutes,5);
       mins= Integer.parseInt(minutes_text);
       if(mints<=56) {
           mints = mins + 3;
       }
       else{
           mints=02;
       }

       String str=String.valueOf(mints);
       commonFunctions.sendKey(toggleminutes,str,5);
       commonFunctions.clickElement(ok,5);

      commonFunctions.clickElement(submitreminder,5);
      Thread.sleep(1000);


        if (driver.findElementsByXPath("//android.widget.Toast[@text='Reminder added successfully']").size()>0 && driver.findElementsByXPath("//*[@text='"+title+"']").size()>0  ){
            isReminderAdded=true;
        }
        else{
            isReminderAdded=false;
        }
            System.out.println(isReminderAdded);
        commonFunctions.navigateback();
        Thread.sleep(139000);
            if (driver.findElementsById("com.care_pro:id/alarm_title_text").size()>0){
                isReminderAdded=true;
            }
            else{
                isReminderAdded=false;
            }

        commonFunctions.navigateback();

        } catch (Exception e) {
            Log.error("Exception occurred in addreminder method " + e.getMessage());
            e.printStackTrace();
        }
        Log.info("********** addreminder method ended " + globalVars.getPlatform() + "*********");
        return isReminderAdded;
    }

    @Override
    public boolean deletereminder() throws InterruptedException {
        boolean isReminderDeleted=false;
        commonFunctions.scrolldown();
        commonFunctions.clickElement(reminder, 5);

        commonFunctions.clickElement(selectcheckbox,5);
        commonFunctions.clickElement(deleteicon,5);
        commonFunctions.clickElement(yesButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Reminder deleted successfully']").size()>0){
            isReminderDeleted=true;
        }
        return isReminderDeleted;
    }


}

