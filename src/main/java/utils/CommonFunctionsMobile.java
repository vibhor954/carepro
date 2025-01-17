package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    public boolean clear(WebElement element, int timeOutInSsec) {
        boolean isElementCleared=false;
        try{
            manageImplicitTimeOut(0);
            wait=new WebDriverWait(driver, timeOutInSsec);
            //wait.until(ExpectedConditions.visibilityOf(element)).click();
            wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
            isElementCleared=true;
        }
        catch (Exception e) {
            logger.error("Exception occurred in clear method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
        Utils.logFunctionLevelLogs(isElementCleared, "clear");
        return isElementCleared;
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
    @Override
    public void scrolldown() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width / 2);
        int starty = (int) (size.height / 2);

        int endx = startx;
        int endy = starty -400;

        TouchAction ts = new TouchAction(driver);
        //for(int i=0;i<=3;i++) {
        ts.press(PointOption.point(startx,starty ))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endx,endy )).release().perform();
    }

    @Override
    public void navigateback() {
        driver.navigate().back();
    }

    @Override
    public void waitforelementinvisible(WebElement element,long timeOutInSsec) {
        try{

            manageImplicitTimeOut(0);
            WebDriverWait wait = null;
            wait=new WebDriverWait(driver, timeOutInSsec);
            wait.until(ExpectedConditions.invisibilityOf(element));
        }catch(Exception e){
            logger.error("Exception occurred in waitforelementinvisible method: "+e.getMessage());
            e.printStackTrace();
            manageImplicitTimeOut(globalVars.getImplicitWait());

        }
        manageImplicitTimeOut(globalVars.getImplicitWait());

    }

    @Override
    public boolean waitforelementvisible(WebElement element, long timeOutInSsec) {
        try{

            manageImplicitTimeOut(0);
            WebDriverWait wait = null;
            wait=new WebDriverWait(driver, timeOutInSsec);
            wait.until(ExpectedConditions.visibilityOf(element));


        }catch(Exception e){
            logger.error("Exception occurred in waitforelementvisible method: "+e.getMessage());
            e.printStackTrace();
            manageImplicitTimeOut(globalVars.getImplicitWait());
            return false;

        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
        return true;
    }


}
