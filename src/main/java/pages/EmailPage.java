package pages;

import generic_pages.CommonEmailPage;
import generic_pages.CommonLoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Utils;

import java.time.Duration;

//import io.appium.java_client.android.AndroidKeyCode;

public class EmailPage extends CommonEmailPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static EmailPage emailPage;
    private static LoginPage loginPage;
    boolean isMailSent=false;
    boolean isMailReceived=false;
    boolean isSearchSuccess=false;
    boolean isTrashEmpty=false;
    boolean isInboxEmpty=false;
    boolean isSentEmpty=false;
    boolean isEmail=false;
    boolean isEmailSentWithoutReciepeient=true;
    boolean isComposeEmailPoupDisplayed=false;
    boolean isEmailSentWithInvalidEmail=true;
    boolean isEmailSentWithNonExistingEmail=true;



    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
    AndroidElement email;
    @AndroidFindBy(id = "com.care_pro:id/iv_composeMain_inbox")
    AndroidElement composeIcon;
    @AndroidFindBy(id = "com.care_pro:id/searchView")
    AndroidElement toinputBox;

    @AndroidFindBy(id = "com.care_pro:id/subject_compose")
    AndroidElement subjectinputBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Description']")
    AndroidElement descriptioninputBox;

    @AndroidFindBy(id = "com.care_pro:id/sendImg_composeEmail")
    AndroidElement sendemailIcon;
    private static AndroidElement moreImage;
    @AndroidFindBy(id = "com.care_pro:id/tablayoutTwoImg")
    AndroidElement sentTab;
    @AndroidFindBy(id = "com.care_pro:id/tablayoutOneImg")
    AndroidElement inboxTab;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement yesButton;
    @AndroidFindBy(xpath = "//*[@text='Add at least one recipient']")
    AndroidElement toastmessageText;
    @AndroidFindBy(id = "com.care_pro:id/iv_search_email")
    AndroidElement searchIcon;
    @AndroidFindBy(id = "com.care_pro:id/tablayoutThreeImg")
    AndroidElement trashIcon;
    @AndroidFindBy(id = "com.care_pro:id/emilMultipleCheckbox")
    AndroidElement selectallCheckbox;
    @AndroidFindBy(id = "com.care_pro:id/deleteImg")
    AndroidElement deleteIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No Emails found']")
    AndroidElement noemailfoundText;
    @AndroidFindBy(id = "com.care_pro:id/search_edittext_emaillist")
    AndroidElement searchInputBox;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Do you want to send message without subject and description?']")
    AndroidElement composeMailPopup;
    @AndroidFindBy(xpath = "//*[@text='No']")
    AndroidElement noTextPopup;



    public EmailPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static EmailPage getEmailPageInstance() {
        if (emailPage == null) {
            emailPage = new EmailPage();
        }
        return emailPage;
    }

    @Override
    public void composeemail(String to, String subject,String description) {


        try {
            commonFunctions.clickElement(email,5);
            commonFunctions.clickElement(composeIcon, 5);
            commonFunctions.sendKey(toinputBox,to,5);
            commonFunctions.sendKey(subjectinputBox,subject,5);
            commonFunctions.sendKey(descriptioninputBox,description,5);
            commonFunctions.clickElement(sendemailIcon, 5);
            isMailSent=true;
            Utils.logFunctionLevelLogs(isMailSent, "composeemail" + globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in composeemail method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********composeemail method ended" + globalVars.getPlatform() + "*********");

    }



    @Override
    public boolean verifymailsent(String text ) {
        try {
        commonFunctions.clickElement(sentTab,5);
        Thread.sleep(3000);
            System.out.println(driver.getPageSource());

        if (driver.getPageSource().contains(text)){
            isMailSent=true;
        }
        } catch (Exception e) {
            Log.error("Exception occurred in verifymailsent method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********verifymailsent method ended" + globalVars.getPlatform() + "*********");
        return isMailSent;
    }

    @Override
    public boolean verifymailreceived(String text) throws InterruptedException {
        try {
        commonFunctions.clickElement(inboxTab,5);
        Thread.sleep(2000);
        if (driver.getPageSource().contains(text)){
            isMailReceived=true;
        }
        } catch (Exception e) {
            Log.error("Exception occurred in verifymailreceived method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********verifymailreceived method ended" + globalVars.getPlatform() + "*********");
        return isMailReceived;
    }

    @Override
    public boolean performsearch() throws InterruptedException {
        commonFunctions.clickElement(searchIcon,5);
        commonFunctions.sendKey(searchInputBox,"vibhor954",5);
        Thread.sleep(2000);
        driver.navigate().back();
        if (driver.getPageSource().contains("vibhor954")){
            isSearchSuccess=true;
        }

        return isSearchSuccess;
    }

    @Override
    public boolean deletetrashemails() {
        commonFunctions.clickElement(trashIcon,5);
        commonFunctions.clickElement(selectallCheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);
        if (driver.findElementsByXPath("//android.widget.TextView[@text='No Emails found']").size()>0){
            isTrashEmpty=true;
        }
        return isTrashEmpty;
    }

    @Override
    public boolean deleteinboxemails() {
        commonFunctions.clickElement(selectallCheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);
        if (driver.findElementsByXPath("//android.widget.TextView[@text='No Emails found']").size()>0){
            isInboxEmpty=true;
        }
        return isInboxEmpty;
    }

    @Override
    public boolean deletesentemails() {
        commonFunctions.clickElement(sentTab,5);
        commonFunctions.clickElement(selectallCheckbox,5);
        commonFunctions.clickElement(deleteIcon,5);
        commonFunctions.clickElement(yesButton,5);
        if (driver.findElementsByXPath("//android.widget.TextView[@text='No Emails found']").size()>0){
            isSentEmpty=true;
        }
        return isSentEmpty;
    }

    @Override
    public boolean verifyemailfunctionality() {
        if (isMailSent && isMailReceived && isSearchSuccess && isTrashEmpty &&  isInboxEmpty && isSentEmpty   ){
            isEmail=true;
        }
        return isEmail;

    }

    @Override
    public boolean emailnegativecases(String to,String subject,String description) throws InterruptedException {
        boolean isVerifyEmailNegativeTestCases=false;

        commonFunctions.clickElement(composeIcon,5);
        commonFunctions.clickElement(sendemailIcon,5);
        if (driver.findElementsByXPath("//*[@text='Add at least one recipient']").size()>0){
            isVerifyEmailNegativeTestCases=true;
        }
        commonFunctions.sendKey(toinputBox,to,5);
        commonFunctions.clickElement(sendemailIcon,5);
        Thread.sleep(2000);
        if (driver.findElementsByXPath("//android.widget.TextView[@text='Do you want to send message without subject and description?']").size()>0){
            isVerifyEmailNegativeTestCases=true;
        }
        else{
            isVerifyEmailNegativeTestCases=false;
        }
        commonFunctions.clickElement(noTextPopup,5);
        commonFunctions.clear(toinputBox,5);
        commonFunctions.sendKey(toinputBox,"abc",5);
        commonFunctions.clickElement(sendemailIcon,5);
        if (driver.findElementsByXPath("//*[@text='Add at least one recipient']").size()>0){
            isVerifyEmailNegativeTestCases=true;
        }
        else{
            isVerifyEmailNegativeTestCases=false;
        }
        commonFunctions.clear(toinputBox,5);
        commonFunctions.sendKey(toinputBox,"cbd@gmail.com",5);
        commonFunctions.sendKey(subjectinputBox,subject,5);
        commonFunctions.sendKey(descriptioninputBox,description,5);
        commonFunctions.clickElement(sendemailIcon,5);

        if (driver.findElementsByXPath("//*[@text='Email address is not registered']").size()>0){
            isVerifyEmailNegativeTestCases=true;
        }else{
            isVerifyEmailNegativeTestCases=false;
        }
        commonFunctions.navigateback();

        return isVerifyEmailNegativeTestCases;
    }

}

