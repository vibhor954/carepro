package pages;

import generic_pages.CommonDoctorAppointmentPage;
import generic_pages.CommonSpritualityPage;
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
import java.util.List;

//import io.appium.java_client.android.AndroidKeyCode;

public class DoctorAppointmentPage extends CommonDoctorAppointmentPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static DoctorAppointmentPage doctorsAppointmentPage;
    private static LoginPage loginPage;
    boolean isVerifySearch = false;
    boolean isDoctorAppointment = false;
    boolean isPastDateAppointmentPossible=true;
    boolean isVerifyDoctorAppointment=false;
    int value;


    @AndroidFindBy(id = "com.care_pro:id/tv_concierge")
    AndroidElement conciergeTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Doctor List']")
    AndroidElement doctorlist;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.GridView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView\n")
    AndroidElement doctorappointment;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Eye']")
    AndroidElement eye;
    @AndroidFindBy(id = "com.care_pro:id/search_edittext")
    AndroidElement searchInputBox;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Doctor Appointments']")
    AndroidElement doctorappointments;
    @AndroidFindBy(id = "com.care_pro:id/iv_date_cal")
    AndroidElement calendarIcon;
    @AndroidFindBy(id = "com.care_pro:id/activity_main_pager_button_left_arrow")
    AndroidElement leftarrow;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.Toast")
    AndroidElement toastmessage;
    @AndroidFindBy(id = "com.care_pro:id/activity_main_pager_button_right_arrow")
    AndroidElement rightarrow;
    @AndroidFindBy(id = "com.care_pro:id/tv_make_appoi")
    AndroidElement makeappointmentButton;



    public DoctorAppointmentPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static DoctorAppointmentPage getDoctorAppointmentPageInstance() {
        if (doctorsAppointmentPage == null) {
            doctorsAppointmentPage = new DoctorAppointmentPage();
        }
        return doctorsAppointmentPage;
    }

    @Override
    public boolean verifysearch(String text) throws InterruptedException {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(doctorappointment, 5);
        commonFunctions.clickElement(doctorlist, 5);
        commonFunctions.clickElement(eye, 5);
        commonFunctions.sendKey(searchInputBox, text, 5);
        Thread.sleep(2000);

        if (driver.findElementsByXPath("//android.widget.TextView[@text='"+text+"']").size() > 0) {
            isVerifySearch = true;
        }
        commonFunctions.navigateback();
        commonFunctions.navigateback();

        return isVerifySearch;
    }

    @Override
    public boolean makedoctorappointment(String text,String month,String days) {
        try {

            commonFunctions.clickElement(conciergeTab, 5);
            commonFunctions.clickElement(doctorappointment, 5);
             commonFunctions.clickElement(doctorlist, 5);
            commonFunctions.clickElement(eye, 5);
            driver.findElementByXPath("//android.widget.TextView[@text='"+text+"']").click();
            commonFunctions.clickElement(calendarIcon,5);
            commonFunctions.clickElement(leftarrow,5);
            commonFunctions.clickElement(rightarrow,5);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate today = LocalDate.now();
           String day= formatter.format(today);
          String arr[]= day.split("-");
           for(int i=0;i<arr.length;i++){
                System.out.println(arr[i]);
            }
         int currentdate=  Integer.parseInt(arr[2]);
         int numberofdays= Integer.parseInt(days);
         int currentmonth= Integer.parseInt(month);
           for (int i=currentdate;i<=numberofdays;i++){
               if (driver.findElementsByXPath("//android.widget.LinearLayout[@content-desc="+i+"/"+currentmonth+"/2020]/android.widget.RelativeLayout/android.widget.FrameLayout").size()>0){
                   value=i;
                   break;
               }

           }


            // commonFunctions.clickElement(spritualvideos, 5);
            Thread.sleep(2000);
            commonFunctions.scrolldown();
            Thread.sleep(2000);

            if (driver.findElementsByXPath("//android.widget.TextView[@text='Watch now']").size() > 0) {
                isDoctorAppointment = true;
            }
            driver.navigate().back();
            driver.navigate().back();
            Utils.logFunctionLevelLogs(isDoctorAppointment, "spritualityspritualvideos" + globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in spritualityspritualvideos method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********spritualityspritualvideos method ended" + globalVars.getPlatform() + "*********");

        return isDoctorAppointment;
    }

    @Override
    public boolean verifypastdateappointment(String text,String day) throws InterruptedException {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(doctorappointment, 5);
        commonFunctions.clickElement(doctorlist, 5);
        commonFunctions.clickElement(eye, 5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+text+"']").click();
        commonFunctions.clickElement(calendarIcon,5);
        commonFunctions.clickElement(leftarrow,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+day+"']").click();
       if (driver.findElementsByXPath("/hierarchy/android.widget.Toast").size()>0){
           isPastDateAppointmentPossible=true;
       }
        return isPastDateAppointmentPossible;
    }

    @Override
    public boolean makedoctorappointment_doctornotavailable(String text) {
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(doctorappointment, 5);
        commonFunctions.clickElement(doctorlist, 5);
        commonFunctions.clickElement(eye, 5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+text+"']").click();

        if (driver.findElementsById("com.care_pro:id/tv_make_appoi").size()==0 && driver.findElementsByXPath("//*[@text='Doctor not Available']").size()>0){
            isVerifyDoctorAppointment=true;
        }
        System.out.println(isVerifyDoctorAppointment);
        return isVerifyDoctorAppointment;
    }


}

