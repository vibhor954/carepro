package pages;

import generic_pages.CommonDoctorAppointmentPage;
import generic_pages.CommonMedicineSchedulePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//import io.appium.java_client.android.AndroidKeyCode;

public class MedicineSchedulePage extends CommonMedicineSchedulePage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static MedicineSchedulePage doctorsAppointmentPage;
    private static LoginPage loginPage;
    boolean isVerifyAddMedicine = false;
    boolean isVerifyAddMedicineWithOtherOption = false;
    boolean isVerifySearch=false;
    boolean isMedicineDeleted=false;
    boolean isMedicineUpdated=false;
    boolean isSetReminder=false;
    int value;


    @AndroidFindBy(id = "com.care_pro:id/tv_concierge")
    AndroidElement conciergeTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Doctor List']")
    AndroidElement doctorlist;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.GridView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView\n")
    AndroidElement medicineschedule;
    @AndroidFindBy(id = "com.care_pro:id/et_name")
    AndroidElement medicinenameInputBox;
    @AndroidFindBy(id = "com.care_pro:id/rl_add_medicine")
    AndroidElement addmedicineButton;
    @AndroidFindBy(id = "com.care_pro:id/No_ofdays")
    AndroidElement numberofdaysInputBox;
    @AndroidFindBy(id = "com.care_pro:id/tv_item_name")
    AndroidElement selectdoctor;
    @AndroidFindBy(id = "com.care_pro:id/end_date")
    AndroidElement medicineenddate;
    @AndroidFindBy(id = "com.care_pro:id/start_date")
    AndroidElement medicinestartdate;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='06:00 AM']")
    AndroidElement medicinetime;
    @AndroidFindBy(id = "com.care_pro:id/search_edittext")
    AndroidElement searchInputBox;
    @AndroidFindBy(id = "com.care_pro:id/tv_make_appoi")
    AndroidElement makeappointmentButton;
    @AndroidFindBy(id = "com.care_pro:id/tv_add_medicine")
    AndroidElement addmedicineButton2;
    @AndroidFindBy(id = "com.care_pro:id/docor_name_manually")
    AndroidElement enterdoctornameInputBox;
    @AndroidFindBy(id = "com.care_pro:id/startDateTv")
    AndroidElement startdatesearchButton;
    @AndroidFindBy(id = "com.care_pro:id/endDateTv")
    AndroidElement enddatesearchButton;
    @AndroidFindBy(id = "com.care_pro:id/date_picker_day")
    AndroidElement datepickerstartdate;
    @AndroidFindBy(id = "com.care_pro:id/ok")
    AndroidElement okButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_select")
    AndroidElement selectallcheckbox;
    @AndroidFindBy(id = "com.care_pro:id/iv_remove")
    AndroidElement deleteIcon;
    @AndroidFindBy(id = "com.care_pro:id/no_text_popup")
    AndroidElement yesButton;
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



    public MedicineSchedulePage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static MedicineSchedulePage getMedicineSchedulePageInstance() {
        if (doctorsAppointmentPage == null) {
            doctorsAppointmentPage = new MedicineSchedulePage();
        }
        return doctorsAppointmentPage;
    }

    @Override
    public boolean verifyaddmedicine(String text,String name,String days) throws InterruptedException {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(medicineschedule, 5);
        commonFunctions.clickElement(addmedicineButton, 5);
        commonFunctions.clickElement(selectdoctor, 5);
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+name+"']").click();
        commonFunctions.sendKey(medicinenameInputBox, text, 5);
        commonFunctions.sendKey(numberofdaysInputBox,days,5);
        String startdate=commonFunctions.getElementText(medicinestartdate,5);
        String enddate=commonFunctions.getElementText(medicineenddate,5);
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.clickElement(medicinetime,5);
        commonFunctions.clickElement(addmedicineButton2,5);
        Thread.sleep(2000);


        if (driver.findElementsByXPath("//*[@text='"+startdate+"']").size()>0 && driver.findElementsByXPath("//*[@text='"+enddate+"']").size()>0 && driver.findElementsByXPath("//*[@text='"+text+"']").size()>0){
            isVerifyAddMedicine=true;
        }
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);
        return isVerifyAddMedicine;

    }

    @Override
    public boolean verifyaddmedicinewithotheroption(String text, String name, String days) throws InterruptedException {
//        commonFunctions.clickElement(conciergeTab, 5);
//        commonFunctions.clickElement(medicineschedule, 5);
        commonFunctions.clickElement(addmedicineButton, 5);
        commonFunctions.clickElement(selectdoctor, 5);
        Thread.sleep(2000);
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
        commonFunctions.sendKey(enterdoctornameInputBox,"Vibhor",5);
        commonFunctions.sendKey(medicinenameInputBox, text, 5);
        commonFunctions.sendKey(numberofdaysInputBox,days,5);
        String startdate=commonFunctions.getElementText(medicinestartdate,5);
        String enddate=commonFunctions.getElementText(medicineenddate,5);
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.clickElement(medicinetime,5);
        commonFunctions.clickElement(addmedicineButton2,5);
        Thread.sleep(2000);
        if (driver.findElementsByXPath("//*[@text='"+startdate+"']").size()>0 && driver.findElementsByXPath("//*[@text='"+enddate+"']").size()>0 && driver.findElementsByXPath("//*[@text='"+text+"']").size()>0){
            isVerifyAddMedicineWithOtherOption=true;
        }
        System.out.println(isVerifyAddMedicineWithOtherOption);
        return isVerifyAddMedicineWithOtherOption;
    }

    @Override
    public boolean verifysearch_medicine(String text, String name, String days) throws InterruptedException {
//        commonFunctions.clickElement(conciergeTab, 5);
//        commonFunctions.clickElement(medicineschedule, 5);
        commonFunctions.clickElement(addmedicineButton, 5);
        commonFunctions.clickElement(selectdoctor, 5);
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+name+"']").click();
        commonFunctions.sendKey(medicinenameInputBox, text, 5);
        commonFunctions.sendKey(numberofdaysInputBox,days,5);
        String startdate=commonFunctions.getElementText(medicinestartdate,5);
        String enddate=commonFunctions.getElementText(medicineenddate,5);
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.clickElement(medicinetime,5);
        commonFunctions.clickElement(addmedicineButton2,5);
        Thread.sleep(2000);
        commonFunctions.sendKey(searchInputBox,text,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath( "//*[@text='"+text+"']").size()>0){
            isVerifySearch=true;
        }
        commonFunctions.clear(searchInputBox,5);
        commonFunctions.clickElement(startdatesearchButton,5);
        commonFunctions.clickElement(datepickerstartdate,5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        String day= formatter.format(today);
        String arr[]= day.split("-");
       int num1= Integer.parseInt(arr[2]);
       int num2=num1-3;
       String val=String.valueOf(num2);
        driver.findElementByXPath("//android.view.View[@index='"+val+"']").click();
        commonFunctions.clickElement(okButton,5);
        commonFunctions.clickElement(enddatesearchButton,5);
        commonFunctions.clickElement(datepickerstartdate,5);
        commonFunctions.clickElement(okButton,5);
        if (driver.findElementsByXPath( "//*[@text='"+text+"']").size()>0){
            isVerifySearch=true;
        }
        else{
            isVerifySearch=false;
        }
        commonFunctions.clear(searchInputBox,5);
        commonFunctions.clickElement(allsearchButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath( "//*[@text='"+text+"']").size()>0){
            isVerifySearch=true;
        }
        else{
            isVerifySearch=false;
        }
        driver.findElementByXPath( "//*[@text='"+text+"']").click();
        commonFunctions.clear(medicinenameInputBox,5);
        commonFunctions.sendKey(medicinenameInputBox,text+"1",5);
        commonFunctions.clickElement(addmedicineButton2,5);
        if (driver.findElementsByXPath( "//*[@text='"+text+"1"+"']").size()>0){
            isMedicineUpdated=true;
        }
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//*[@text='Medicine deleted successfully']").size()>0 && isVerifySearch==true && isMedicineUpdated==true) {
            isMedicineDeleted=true;
        }
        return isVerifySearch;
    }

    @Override
    public boolean verifysetreminder(String text, String name, String days) throws InterruptedException {
//        commonFunctions.clickElement(conciergeTab, 5);
//        commonFunctions.clickElement(medicineschedule, 5);
        commonFunctions.clickElement(addmedicineButton, 5);
        commonFunctions.clickElement(selectdoctor, 5);
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+name+"']").click();
        commonFunctions.sendKey(medicinenameInputBox, text, 5);
        commonFunctions.sendKey(numberofdaysInputBox,days,5);
        String startdate=commonFunctions.getElementText(medicinestartdate,5);
        String enddate=commonFunctions.getElementText(medicineenddate,5);
        commonFunctions.clickElement(setreminderToggle,5);
        commonFunctions.scrolldown();
        commonFunctions.scrolldown();
        commonFunctions.clickElement(medicinetime,5);
        commonFunctions.clickElement(addmedicineButton2,5);
        Thread.sleep(3000);
        System.out.println("Here");
        Thread.sleep(5000);
        commonFunctions.navigateback();
        commonFunctions.navigateback();
        commonFunctions.clickElement(moreImage,5);
        commonFunctions.clickElement(reminder,5);
        Thread.sleep(2000);

        if (driver.findElementsByXPath("//android.widget.TextView[@text='All Activities and Schedules']").size()>0){
            isSetReminder=true;
        }
        commonFunctions.navigateback();
        commonFunctions.clickElement(medicineschedule,5);
        commonFunctions.clickElement(selectallcheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);

        return isSetReminder;
    }


}

