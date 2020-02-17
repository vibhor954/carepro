package utils;

import logger.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class CommonFunctions {
    static GlobalVars globalVars;
    public static CommonFunctions commonFunctions;
    public static Logger logger;


    public static CommonFunctions getInstance(){
        globalVars=GlobalVars.getInstance();
        logger= Log.getInstance();
        if(commonFunctions==null){
            switch(globalVars.getPlatform()){
                case Constants.ANDROID:
                    commonFunctions=new CommonFunctionsMobile();
                    break;

            }
        }
        commonFunctions.assignDriverObject();
        return commonFunctions;



    }

    public abstract boolean clickElement(WebElement element, int timeOutInSsec);
    public abstract void sendKey(WebElement element, String key,  int timeOutInSsec);
    public abstract boolean isElementDisplayed(WebElement element,  int timeOutInSsec);
    public abstract String getElementText(WebElement element,  int timeOutInSsec);
    public abstract void manageImplicitTimeOut(long timeOutInSsec);
    public abstract void assignDriverObject();

}
