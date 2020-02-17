package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages.SignupPage;
import utils.Constants;
import utils.GlobalVars;


public abstract class CommonSignupPage {

    private static CommonSignupPage commonSignupPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonSignupPage getInstance(){
        globalVars=GlobalVars.getInstance();
        logger= Log.getInstance();
        if(commonSignupPage ==null){
            switch(globalVars.getPlatform()){
                case Constants.ANDROID:
                	commonSignupPage = SignupPage.getSignupPageInstance();
                    break;
            }
        }
        return commonSignupPage;

    }


    
    

}

