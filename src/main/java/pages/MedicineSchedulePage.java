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
    boolean isVerifyDoctorAppointment=false;
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
        return isVerifyAddMedicine;

    }

    @Override
    public boolean verifyaddmedicinewithotheroption(String text, String name, String days) throws InterruptedException {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(medicineschedule, 5);
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
        commonFunctions.sendKey(searchInputBox,text,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath( "//*[@text='"+text+"']").size()>0){
            isVerifySearch=true;
        }
        System.out.println(isVerifySearch);
        return isVerifySearch;
    }


}

