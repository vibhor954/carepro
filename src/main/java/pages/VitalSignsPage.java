package pages;

import generic_pages.CommonMedicineSchedulePage;
import generic_pages.CommonVitalSignsPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//import io.appium.java_client.android.AndroidKeyCode;

public class VitalSignsPage extends CommonVitalSignsPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static VitalSignsPage vitalSignsPage;
    private static LoginPage loginPage;
    boolean isVitalSignsAdded = false;
    boolean isVitalSignsAddedWithOtherOption = false;
    boolean isVitalSignsUpdated=false;
    boolean isVerifySearch=false;
    boolean isVerifyNegativeScenerios=false;


    @AndroidFindBy(id = "com.care_pro:id/tv_concierge")
    AndroidElement conciergeTab;
    @AndroidFindBy(id = "com.care_pro:id/pickdate_txt")
    AndroidElement dateInputBox;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.GridView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.TextView")
    AndroidElement vitalsigns;
    @AndroidFindBy(id = "com.care_pro:id/pickdate_txt")
    AndroidElement selectdate;
    @AndroidFindBy(id = "com.care_pro:id/rl_add_vitalsign")
    AndroidElement addvitalsignsButton;
    @AndroidFindBy(id = "com.care_pro:id/tv_item_name")
    AndroidElement selectsource;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SELECT TEST TYPE']")
    AndroidElement selecttesttype;
    @AndroidFindBy(id = "com.care_pro:id/unit_ext")
    AndroidElement addunit;
    @AndroidFindBy(id = "com.care_pro:id/rl_addvital_sign")
    AndroidElement submitButton;
    @AndroidFindBy(id = "com.care_pro:id/testtype_layout")
    AndroidElement selecttesttypeupdate;
    @AndroidFindBy(id = "com.care_pro:id/search_edittext")
    AndroidElement searchInputBox;
    @AndroidFindBy(id = "com.care_pro:id/tv_make_appoi")
    AndroidElement makeappointmentButton;
    @AndroidFindBy(id = "com.care_pro:id/tv_add_medicine")
    AndroidElement addmedicineButton2;
    @AndroidFindBy(id = "com.care_pro:id/docor_name_manually")
    AndroidElement sourcenameInputBox;
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
    @AndroidFindBy(id = "com.care_pro:id/no_text_popup")
    AndroidElement yesButton;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement noButton;
    @AndroidFindBy(id = "com.care_pro:id/Search_txt")
    AndroidElement search;


    public VitalSignsPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static VitalSignsPage getVitalSignsPageInstance() {
        if (vitalSignsPage == null) {
            vitalSignsPage = new VitalSignsPage();
        }
        return vitalSignsPage;
    }

    @Override
    public boolean addvitalsigns(String name,String text,String units) throws InterruptedException {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(vitalsigns, 5);
        commonFunctions.clickElement(addvitalsignsButton, 5);
        commonFunctions.clickElement(selectdate, 5);
        commonFunctions.clickElement(okButton,5);
        commonFunctions.clickElement(selectsource,5);
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+name+"']").click();
        commonFunctions.clickElement(selecttesttype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+text+"']").click();
        commonFunctions.clickElement(addunit,5);
        commonFunctions.sendKey(addunit,units,5);
        commonFunctions.navigateback();
        commonFunctions.clickElement(submitButton,5);



        Thread.sleep(2000);

        if (driver.findElementsByXPath("//*[@text='"+text+"']").size()>0 ){
            isVitalSignsAdded=true;
        }

        return isVitalSignsAdded;

    }

    @Override
    public boolean addvitalsignsithotheroption(String name,String text,String units) throws InterruptedException {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(vitalsigns, 5);
        commonFunctions.clickElement(addvitalsignsButton, 5);
        commonFunctions.clickElement(selectdate, 5);
        commonFunctions.clickElement(okButton,5);
        commonFunctions.clickElement(selectsource,5);
        Thread.sleep(1000);
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        driver.findElementByXPath("//android.widget.TextView[@text='Other']").click();
        Thread.sleep(1000);
        commonFunctions.sendKey(sourcenameInputBox,name,5);
        commonFunctions.clickElement(selecttesttype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+text+"']").click();
        commonFunctions.clickElement(addunit,5);
        commonFunctions.sendKey(addunit,units,5);
        commonFunctions.navigateback();
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(2000);

        if (driver.findElementsByXPath("//*[@text='"+text+"']").size()>0 && driver.findElementsByXPath("//*[@text='"+name+"']").size()>0  ){
            isVitalSignsAddedWithOtherOption=true;
        }
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);

        return isVitalSignsAddedWithOtherOption;

    }

    @Override
    public boolean updatevitalsigns(String text, String name, String units, String update) throws InterruptedException {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(vitalsigns, 5);
        commonFunctions.clickElement(addvitalsignsButton, 5);
        commonFunctions.clickElement(selectdate, 5);
        commonFunctions.clickElement(okButton,5);
        commonFunctions.clickElement(selectsource,5);
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+text+"']").click();
        commonFunctions.clickElement(selecttesttype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+name+"']").click();
        commonFunctions.clickElement(addunit,5);
        commonFunctions.sendKey(addunit,units,5);
        commonFunctions.navigateback();
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+name+"']").click();
        commonFunctions.clickElement(selecttesttypeupdate,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+update+"']").click();
        commonFunctions.clickElement(submitButton,5);
        if (driver.findElementsByXPath("//*[@text='"+update+"']").size()>0 ){
            isVitalSignsUpdated=true;
        }
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);
        return isVitalSignsUpdated;
    }


    @Override
    public boolean verifysearch(String text, String name, String units) throws InterruptedException {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(vitalsigns, 5);
        commonFunctions.clickElement(addvitalsignsButton, 5);
        commonFunctions.clickElement(selectdate, 5);
        commonFunctions.clickElement(okButton,5);
        commonFunctions.clickElement(selectsource,5);
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+text+"']").click();
        commonFunctions.clickElement(selecttesttype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+name+"']").click();
        commonFunctions.clickElement(addunit,5);
        commonFunctions.sendKey(addunit,units,5);
        commonFunctions.navigateback();
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(2000);
        commonFunctions.clickElement(fromdatesearchButton,5);
        commonFunctions.clickElement(okButton,5);
        commonFunctions.clickElement(todatesearchButton,5);
        commonFunctions.clickElement(okButton,5);
        commonFunctions.clickElement(searchButton,5);


        if (driver.findElementsByXPath("//*[@text='"+name+"']").size()>0 && driver.findElementsByXPath("//*[@text='Clear']").size()>0 ){
            isVerifySearch=true;
        }
        commonFunctions.clickElement(searchButton,5);
        Thread.sleep(1000);
        if (isVerifySearch && driver.findElementsByXPath("//*[@text='Clear']").size()==0 ){
            isVerifySearch=true;
        }

        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);
        return isVerifySearch;
    }

    @Override
    public boolean vitalsigns_negativescenerios(String text, String name, String units) throws InterruptedException {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(vitalsigns, 5);
        commonFunctions.clickElement(addvitalsignsButton, 5);
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please select date']").size()>0 ){
            isVerifyNegativeScenerios=true;
        }
        commonFunctions.clickElement(selectdate, 5);
        commonFunctions.clickElement(okButton,5);
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please select test type']").size()>0 ){
            isVerifyNegativeScenerios=true;
        }
        else{
            isVerifyNegativeScenerios=false;
        }
        commonFunctions.clickElement(selecttesttype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+name+"']").click();
        commonFunctions.clickElement(submitButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please enter unit']").size()>0 ){
            isVerifyNegativeScenerios=true;
        }
        else{
            isVerifyNegativeScenerios=false;
        }
        commonFunctions.clickElement(addunit,5);
        commonFunctions.sendKey(addunit,units,5);
        commonFunctions.navigateback();
        commonFunctions.clickElement(submitButton,5);
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(noButton,5);
        commonFunctions.clickElement(search,5);
        if (driver.findElementsByXPath("//android.widget.TextView[@text='"+text+"']").size()>0){
            isVerifyNegativeScenerios=true;
        }
        else{
            isVerifyNegativeScenerios=false;
        }

        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);


        return isVerifyNegativeScenerios;
    }

}

