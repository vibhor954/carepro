package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import utils.Constants;
import utils.GlobalVars;


// Compare this to a default method in an interface Java 8
public abstract class CommonLoginPage{
    
    private static CommonLoginPage commonLoginPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonLoginPage getInstance(){
        globalVars=GlobalVars.getInstance();
        logger= Log.getInstance();
        if(commonLoginPage==null){
            switch(globalVars.getPlatform()){
                case Constants.ANDROID:
                    commonLoginPage= pages.LoginPage.getLoginPageInstance();
                    break;
            }
        }
        return commonLoginPage;

    }

    public abstract boolean loginwithvalidcredentials(String username, String password);

    public abstract boolean logout();
}

