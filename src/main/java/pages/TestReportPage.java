package pages;

import generic_pages.CommonPhotoPage;
import generic_pages.CommonTestReportPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;


public class TestReportPage extends CommonTestReportPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static TestReportPage testReportPage;
    private static LoginPage loginPage;


    @AndroidFindBy(id = "com.care_pro:id/tv_concierge")
    AndroidElement conciergeTab;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.GridView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView")
    AndroidElement testreport;
    @AndroidFindBy(id = "com.care_pro:id/rl_add")
    AndroidElement uploadnewtestreportButton;
    @AndroidFindBy(id = "com.care_pro:id/et_test_name")
    AndroidElement entertestreportname;
    @AndroidFindBy(id = "com.care_pro:id/tv_item_name")
    AndroidElement selectdoctor;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Test Type']")
    AndroidElement selecttesttype;
    @AndroidFindBy(id = "com.care_pro:id/pick_pdf")
    AndroidElement pdf;
    @AndroidFindBy(id = "com.care_pro:id/pick_img")
    AndroidElement image;
    @AndroidFindBy(id = "com.android.documentsui:id/icon_mime")
    AndroidElement recent;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[4]")
    AndroidElement descriptioninputBox2;
    @AndroidFindBy(id = "com.care_pro:id/et_test_dsc")
    AndroidElement descriptioninputBox;
    @AndroidFindBy(id = "com.care_pro:id/rl_add_test")
    AndroidElement sentButton;
    @AndroidFindBy(id = "com.care_pro:id/docor_name_manually")
    AndroidElement enterdoctorname;
    @AndroidFindBy(id = "com.care_pro:id/Choose_from_Library_txt")
    AndroidElement gallery;
    @AndroidFindBy(className = "android.widget.LinearLayout")
    AndroidElement report;
    @AndroidFindBy(id = "com.care_pro:id/rl_send_to_caregiver")
    AndroidElement sendtouserButton;
    @AndroidFindBy(xpath = "//*[@text='Update Test Report']")
    AndroidElement sentButton2;
    @AndroidFindBy(id = "com.care_pro:id/iv_select")
    AndroidElement selectcheckbox;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement yespopupButton;
    @AndroidFindBy(id = "com.care_pro:id/no_text_popup")
    AndroidElement yespopupButton2;
    @AndroidFindBy(id = "com.care_pro:id/rl_update_test_report")
    private static AndroidElement updatetestreportButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_remove")
    private static AndroidElement deleteicon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Activities and Schedules']")
    private static AndroidElement allactivitiesandschedulesmessage;



    public TestReportPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static TestReportPage getTestReportPageInstance() {
        if (testReportPage == null) {
            testReportPage = new TestReportPage();
        }
        return testReportPage;
    }

    @Override
    public boolean uploadtestreport(String reportname,String doctor,String test,String file,String description) throws InterruptedException {
        boolean isReportUploaded=false;
        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(testreport, 5);
        commonFunctions.clickElement(uploadnewtestreportButton,5);
        commonFunctions.sendKey(entertestreportname,reportname,5);
        commonFunctions.clickElement(selectdoctor, 5);
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+doctor+"']").click();
        commonFunctions.clickElement(selecttesttype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+test+"']").click();
        commonFunctions.clickElement(image,5);
        commonFunctions.clickElement(gallery,5);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.GridView/android.widget.FrameLayout[1]/android.widget.ImageView[3]").click();
        commonFunctions.sendKey(descriptioninputBox,description,5);
        commonFunctions.clickElement(sentButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Add test report successfully']").size()>0 && driver.findElementsByXPath("//android.widget.TextView[@text='"+doctor+"']").size()>0 && driver.findElementsByXPath("//android.widget.TextView[@text='"+test+"']").size()>0 ){
            isReportUploaded=true;
        }
        commonFunctions.clickElement(selectcheckbox,5);
        commonFunctions.clickElement(deleteicon,5);
        commonFunctions.clickElement(yespopupButton2,5);

        return isReportUploaded;
    }

    @Override
    public boolean uploadtestreportwithotheroption(String reportname,String doctor,String test,String user,String description) throws InterruptedException {

            boolean isReportUploaded = false;
            boolean isReportSent = false;
            commonFunctions.clickElement(conciergeTab, 5);
            commonFunctions.clickElement(testreport, 5);

            commonFunctions.clickElement(uploadnewtestreportButton, 5);
            commonFunctions.sendKey(entertestreportname, reportname, 5);
            commonFunctions.clickElement(selectdoctor, 5);
            Thread.sleep(1000);
            commonFunctions.scrolldown();
        Thread.sleep(1000);
            commonFunctions.scrolldown();
        Thread.sleep(1000);
            commonFunctions.scrolldown();
        Thread.sleep(1000);
            commonFunctions.scrolldown();
        Thread.sleep(1000);
            commonFunctions.scrolldown();
        Thread.sleep(1000);
            commonFunctions.scrolldown();
        Thread.sleep(1000);
//            commonFunctions.scrolldown();
//            commonFunctions.scrolldown();
            driver.findElementByXPath("//android.widget.TextView[@text='Other']").click();
            Thread.sleep(1000);
            commonFunctions.sendKey(enterdoctorname, doctor, 5);
            commonFunctions.clickElement(selecttesttype, 5);
            driver.findElementByXPath("//android.widget.TextView[@text='" + test + "']").click();
            commonFunctions.clickElement(image, 5);
            commonFunctions.clickElement(gallery, 5);
            driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.GridView/android.widget.FrameLayout[1]/android.widget.ImageView[3]").click();
            commonFunctions.sendKey(descriptioninputBox, description, 5);
            //Thread.sleep(1000);
           // driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
            //commonFunctions.clickElement(sentButton, 5);
            Thread.sleep(1000);
            WebElement element = driver.findElementByXPath("//*[@text='Send']");
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
          // System.out.println(driver.findElementsByXPath("//*[@text='Send']").size());
          //List<WebElement> el=driver.findElementsByXPath("//*[@text='Send']");
         // el.get(0).click();
           
            if (driver.findElementsByXPath("//android.widget.Toast[@text='Add test report successfully']").size() > 0 && driver.findElementsByXPath("//android.widget.TextView[@text='" + doctor + "']").size() > 0 && driver.findElementsByXPath("//android.widget.TextView[@text='" + test + "']").size() > 0) {
                isReportUploaded = true;
            }
            commonFunctions.clickElement(report, 5);
            commonFunctions.clickElement(sendtouserButton, 5);
            commonFunctions.clickElement(selectdoctor, 5);
            Thread.sleep(1000);
            driver.findElementByXPath("//android.widget.TextView[@text='" + user + "']").click();
            commonFunctions.clickElement(sendtouserButton, 5);
            if (driver.findElementsByXPath("//android.widget.Toast[@text='Report successfully send']").size() > 0) {
                isReportSent = true;
            }
            if (isReportUploaded && isReportSent) {
                isReportUploaded = true;
            }
            commonFunctions.clickElement(selectcheckbox, 5);
            commonFunctions.clickElement(deleteicon, 5);
            commonFunctions.clickElement(yespopupButton2, 5);

        return isReportUploaded;

        }





    @Override
    public boolean updatetestreport(String reportname,String doctor,String test,String updated,String description,String sendtouser) throws InterruptedException {
        boolean isReportUpdated=false;
        boolean isReportSentToUser=false;

        commonFunctions.clickElement(conciergeTab, 5);
        commonFunctions.clickElement(testreport, 5);
        commonFunctions.clickElement(uploadnewtestreportButton,5);
        commonFunctions.sendKey(entertestreportname,reportname,5);
        commonFunctions.clickElement(selectdoctor, 5);
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+doctor+"']").click();
        commonFunctions.clickElement(selecttesttype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+test+"']").click();
        commonFunctions.clickElement(image,5);
        commonFunctions.clickElement(gallery,5);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.GridView/android.widget.FrameLayout[1]/android.widget.ImageView[3]").click();
        commonFunctions.sendKey(descriptioninputBox,description,5);
        commonFunctions.clickElement(sentButton,5);
        Thread.sleep(1000);

        driver.findElementByXPath("//android.widget.TextView[@text='"+reportname+"']").click();
        commonFunctions.clickElement(updatetestreportButton,5);
        commonFunctions.clear(descriptioninputBox,5);
        commonFunctions.sendKey(descriptioninputBox,updated,5);
        //commonFunctions.clickElement(sentButton,5);
        commonFunctions.clickElement(sentButton2,5);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Update test report successfully']").size()>0 && driver.findElementsByXPath("//android.widget.TextView[@text='"+updated+"']").size()>0){
            isReportUpdated=true;
        }

        commonFunctions.clickElement(sendtouserButton,5);
        commonFunctions.clickElement(selectdoctor,10);
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+sendtouser+"']").click();
        commonFunctions.clickElement(sendtouserButton,5);
        Thread.sleep(3000);

        if (driver.findElementsByXPath("//android.widget.Toast[@text='Report successfully sent']").size()>0){
            isReportSentToUser=true;
        }
        if (isReportUpdated && isReportSentToUser){
            isReportUpdated=true;
        }
        else{
            isReportUpdated=false;
        }

        commonFunctions.clickElement(selectcheckbox,5);
        commonFunctions.clickElement(deleteicon,5);
        commonFunctions.clickElement(yespopupButton,5);


        return isReportUpdated;
    }

    @Override
    public boolean negativescenerios(String reportname, String doctor, String test, String folder, String description) throws InterruptedException {
        boolean isVerifyNegativeScenerios=false;

        //commonFunctions.clickElement(conciergeTab, 5);
        //commonFunctions.clickElement(testreport, 5);
        commonFunctions.clickElement(uploadnewtestreportButton,5);
        commonFunctions.clickElement(sentButton,5);
        commonFunctions.sendKey(entertestreportname,reportname,5);
        commonFunctions.clickElement(sentButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please select doctor']").size()>0){
            isVerifyNegativeScenerios=true;
        }
        commonFunctions.clickElement(selectdoctor, 5);
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+doctor+"']").click();
        commonFunctions.clickElement(sentButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please select test type']").size()>0){
            isVerifyNegativeScenerios=true;
        }
        else{
            isVerifyNegativeScenerios=false;
        }
        Thread.sleep(1000);
        commonFunctions.clickElement(selecttesttype,5);
        driver.findElementByXPath("//android.widget.TextView[@text='"+test+"']").click();
        commonFunctions.clickElement(sentButton,5);
        Thread.sleep(2000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please select test report image']").size()>0){
            isVerifyNegativeScenerios=true;
        }
        else{
            isVerifyNegativeScenerios=false;
        }
        commonFunctions.clickElement(image,5);
        commonFunctions.clickElement(gallery,5);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.GridView/android.widget.FrameLayout[1]/android.widget.ImageView[3]").click();
        commonFunctions.clickElement(sentButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Write description here about your test report']").size()>0){
            isVerifyNegativeScenerios=true;
        }
        else{
            isVerifyNegativeScenerios=false;
        }
        commonFunctions.sendKey(descriptioninputBox,description,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(sentButton,5);
        commonFunctions.clickElement(deleteicon,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(yespopupButton2,5);
//        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please select test report']").size()>0){
//            isVerifyNegativeScenerios=true;
//        }
//        else{
//            isVerifyNegativeScenerios=false;
//        }
        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.TextView[@text='"+reportname+"']").click();
        commonFunctions.clickElement(sendtouserButton,5);
        commonFunctions.clickElement(sendtouserButton,5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//android.widget.Toast[@text='Please select user']").size()>0){
            isVerifyNegativeScenerios=true;
        }
        else{
            isVerifyNegativeScenerios=false;
        }
        commonFunctions.navigateback();
        commonFunctions.navigateback();
        Thread.sleep(5000);
        commonFunctions.clickElement(selectcheckbox,10);
        Thread.sleep(1000);
        commonFunctions.clickElement(deleteicon,5);
        Thread.sleep(1000);
        commonFunctions.clickElement(yespopupButton2,5);
        return isVerifyNegativeScenerios;
    }


}

