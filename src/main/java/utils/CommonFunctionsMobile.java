package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonFunctionsMobile extends CommonFunctions {
    //static AppiumDriver driver;
    static AppiumDriver driver;
    WebDriverWait wait;


    @Override
    public void assignDriverObject() {

        driver=globalVars.getDriver();
    }

    @Override
    public boolean clickElement(WebElement element, int timeOutInSsec) {
        boolean isElementClicked=false;
        try{
            manageImplicitTimeOut(0);
            wait=new WebDriverWait(driver, timeOutInSsec);
            //wait.until(ExpectedConditions.visibilityOf(element)).click();
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            isElementClicked=true;
        }
        catch (Exception e) {
            logger.error("Exception occurred in clickElement method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
        Utils.logFunctionLevelLogs(isElementClicked, "clickElement");
        return isElementClicked;
    }

    @Override
    public void sendKey(WebElement element, String key, int timeOutInSsec) {
        try {
            manageImplicitTimeOut(0);//Setting the implicit wait as zero as implicit and explicit wait do not work together
            wait=new WebDriverWait(driver, timeOutInSsec);
            wait.until(ExpectedConditions.visibilityOf(element)).clear();element.sendKeys(key);
            Utils.logFunctionLevelLogs(true, "sendKey");
        } catch (Exception e) {
            logger.error("Exception occurred in sendKey method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
    }

    @Override
    public boolean isElementDisplayed(WebElement element, int timeOutInSsec) {
        boolean isElementDisplayed=false;
        try {
            manageImplicitTimeOut(0);
            wait=new WebDriverWait(driver, timeOutInSsec);
            isElementDisplayed=wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

        } catch (Exception e) {
            isElementDisplayed=false;
            logger.error("Exception occurred in isElementDisplayed method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
        Utils.logFunctionLevelLogs(isElementDisplayed, "isElementDisplayed");
        return isElementDisplayed;
    }

    @Override
    public String getElementText(WebElement element, int timeOutInSsec) {
        String text="";
        try {
            manageImplicitTimeOut(0);
            wait=new WebDriverWait(driver, timeOutInSsec);
            text=wait.until(ExpectedConditions.visibilityOf(element)).getText();

        } catch (Exception e) {
            logger.error("Exception occurred in getElementText method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
        logger.info("Element text found :"+ text);
        return text;
    }

    @Override
    public void manageImplicitTimeOut(long timeOutInSsec) {
        try {
            driver.manage().timeouts().implicitlyWait(timeOutInSsec, TimeUnit.SECONDS);//Setting the implicit wait as zero as implicit and explicit wait do not work together
        } catch (Exception e) {
            logger.error("Exception occurred in manageImplicitTimeOut method: "+e.getMessage());
        }
    }

}
