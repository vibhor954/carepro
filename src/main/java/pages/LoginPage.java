package pages;

import generic_pages.CommonLoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginPage extends CommonLoginPage {
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static LoginPage loginPage;


    @AndroidFindBy(id = "com.care_pro:id/et_email")
    private static AndroidElement useridoremailInputBox;
    @AndroidFindBy(id = "com.care_pro:id/et_pass")
    private static AndroidElement passwordInputBox;
    @AndroidFindBy(id = "com.care_pro:id/tv_login")
    private static AndroidElement loginButton;
    @AndroidFindBy(id = "com.care_pro:id/iv_personal")
    private static AndroidElement personalImage;
    @AndroidFindBy(id = "com.care_pro:id/tb_rem")
    private static AndroidElement remembermeToggle;
    @AndroidFindBy(id = "com.care_pro:id/iv_more")
    private static AndroidElement moreImage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Logout']")
    AndroidElement logoutLink;
    @AndroidFindBy(id = "com.care_pro:id/yes_text_popup")
    AndroidElement yesButton;
    @AndroidFindBy(xpath = "//*[@text='Login id/password is wrong…']")
    AndroidElement toastmessageText;



    public LoginPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctions.getInstance();
    }

    public static LoginPage getLoginPageInstance() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    @Override
    public boolean loginwithvalidcredentials(String email, String password) {
        boolean isUserLoggedIn = false;

        try {

            // driver.startActivity(new Activity("com.example", "ActivityName"));

            commonFunctions.sendKey(useridoremailInputBox, email, 5);
            commonFunctions.sendKey(passwordInputBox, password, 5);
            commonFunctions.clickElement(remembermeToggle, 5);
            commonFunctions.clickElement(loginButton, 5);
            commonFunctions.clickElement(moreImage, 5);
            commonFunctions.clickElement(logoutLink, 5);
            commonFunctions.clickElement(yesButton, 5);
            String email_text = commonFunctions.getElementText(useridoremailInputBox, 5);

            if (email_text.equalsIgnoreCase(email)) {
                isUserLoggedIn = true;
            }

            Utils.logFunctionLevelLogs(isUserLoggedIn, "loginwithvalidcredentials" + globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in loginwithvalidcredentials method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********Login method ended" + globalVars.getPlatform() + "*********");
        return isUserLoggedIn;
    }

    @Override
    public boolean loginwithinvalidcredentials(String invalid_username, String invalid_password, String message, String valid_username, String valid_password) throws InterruptedException {
        boolean isUserLoggedIn = true;
        boolean isUserLoggedInAfterAppRepoen = false;
        boolean isPass = false;
        try {

        commonFunctions.clickElement(loginButton, 5);
        Thread.sleep(2000);
        if (driver.getPageSource().contains(message)) {
            isUserLoggedIn = false;
        }
        commonFunctions.sendKey(useridoremailInputBox, invalid_username, 5);
        commonFunctions.sendKey(passwordInputBox, invalid_password, 5);
        commonFunctions.clickElement(loginButton, 5);

        Thread.sleep(1000);
        if (driver.findElementsByXPath("//*[@text='Login id/password is wrong…']").size() > 0) {
            isUserLoggedIn = false;
        } else {
            isUserLoggedIn = true;
        }
        commonFunctions.clear(useridoremailInputBox, 5);
        commonFunctions.sendKey(useridoremailInputBox, valid_username, 5);
        commonFunctions.clear(passwordInputBox, 5);
        commonFunctions.sendKey(passwordInputBox, invalid_password, 5);
        commonFunctions.clickElement(loginButton, 5);
        Thread.sleep(1000);
        if (driver.findElementsByXPath("//*[@text='Login id/password is wrong…']").size() > 0) {
            isUserLoggedIn = false;
        } else {
            isUserLoggedIn = true;
        }
        commonFunctions.clear(useridoremailInputBox, 5);
        commonFunctions.sendKey(useridoremailInputBox, valid_username, 5);
        commonFunctions.clear(passwordInputBox, 5);
        commonFunctions.sendKey(passwordInputBox, valid_password, 5);
        commonFunctions.clickElement(loginButton, 5);
        Thread.sleep(2000);
        driver.runAppInBackground(Duration.ofSeconds(2));
        if (driver.findElementsById("com.care_pro:id/iv_more").size() > 0) {
            isUserLoggedInAfterAppRepoen = true;
        }

        if (isUserLoggedIn == false && isUserLoggedInAfterAppRepoen == true) {
            isPass = true;
        }
            Utils.logFunctionLevelLogs(isPass, "loginwithinvalidcredentials" + globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in loginwithinvalidcredentials method" + e.getMessage());
            e.printStackTrace();
        }
        Log.info("**********Login method ended" + globalVars.getPlatform() + "*********");

        return isPass;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public void login() throws IOException {
        File f=new File(System.getProperty("user.dir")+"//src//main//resources//commondata.properties");
        FileInputStream fs=new FileInputStream(f);
        Properties prop = new Properties();
        prop.load(fs);
        commonFunctions.sendKey(useridoremailInputBox, prop.getProperty("username"), 5);
        commonFunctions.sendKey(passwordInputBox, prop.getProperty("password"), 5);
        commonFunctions.clickElement(remembermeToggle, 5);
        commonFunctions.clickElement(loginButton, 5);
    }

}

