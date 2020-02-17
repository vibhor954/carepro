package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AndroidBase extends TestBase{
    static String driverUrl;
    static DesiredCapabilities capabilities;
    static GlobalVars globalVars;
    static AppiumDriver driver;

    @Override
    public void initializeDriver() {
        globalVars=GlobalVars.getInstance();
        capabilities=new DesiredCapabilities();
        driverUrl="http://"+globalVars.getAppiumServerIp()+":"+globalVars.getAppiumServerPort()+"/wd/hub";
        if(driver==null){
            if(globalVars.getIsAwsRun())
                initializeDriverWithoutCapabilities();
            else
                initializeDriverWithCapabilities();
        }

    }


    public void initializeDriverWithoutCapabilities() {
        try{
            globalVars.setDriver(new AndroidDriver(new URL(driverUrl), capabilities));
            driver = globalVars.getDriver();
            driver.manage().timeouts().implicitlyWait(globalVars.getImplicitWait(), TimeUnit.SECONDS);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void initializeDriverWithCapabilities() {
        try{
            capabilities.setCapability(Constants.DEVICE_NAME, globalVars.getDeviceNameAndroid());
            capabilities.setCapability(Constants.PLATFORM_VERSION, globalVars.getPlatformVersionAndroid());
            capabilities.setCapability(Constants.PLATFORM_NAME, globalVars.getPlatform());
            capabilities.setCapability(Constants.NEW_COMMAND_TIMEOUT, 50000);
            //capabilities.setCapability(Constants.AUTOMATION_NAME, globalVars.getAutomationname());
            capabilities.setCapability(Constants.LOCATION_SERVICES_AUTHORIZED, true);
            capabilities.setCapability(Constants.AUTO_GRANT_PERMISSIONS, true);
            capabilities.setCapability(Constants.APP_PACKAGE, globalVars.getAppPackage());
            capabilities.setCapability(Constants.APP_ACTIVITY, globalVars.getAppActivity());
            capabilities.setCapability(Constants.APP_WAIT_PACKAGE, globalVars.getAppWaitPackage());
            capabilities.setCapability("noReset",false);
          //  capabilities.setCapability(MobileCapabilityType.APP,);
            
           // capabilities.setCapability("autoGrantPermissions", true);
            if(driver == null){
                globalVars.setDriver(new AndroidDriver(new URL(driverUrl), capabilities));
                driver=globalVars.getDriver();
                driver.manage().timeouts().implicitlyWait(globalVars.getImplicitWait(), TimeUnit.SECONDS);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }


    @Override
    public void closeDriver(){
        //if(driver!=null)
          //  driver.quit();

    }
}
