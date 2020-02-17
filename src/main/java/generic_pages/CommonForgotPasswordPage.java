package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages.ForgotPasswordPage;
import utils.Constants;
import utils.GlobalVars;


// Compare this to a default method in an interface Java 8
public abstract class CommonForgotPasswordPage {

    private static CommonForgotPasswordPage commonForgotPasswordPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonForgotPasswordPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonForgotPasswordPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonForgotPasswordPage = pages.ForgotPasswordPage.getForgotPasswordPageInstance();
                    break;
            }
        }
        return commonForgotPasswordPage;

    }

    public abstract boolean forgotpasswordwithinvaliddata(String message, String regsitered_email,String password,String invalid_email) throws InterruptedException;
}

