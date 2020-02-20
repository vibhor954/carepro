package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import utils.Constants;
import utils.GlobalVars;


// Compare this to a default method in an interface Java 8
public abstract class CommonSocialPage {

    private static CommonSocialPage commonSocialPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonSocialPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonSocialPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonSocialPage = pages.SocialPage.getSocialPageInstance();
                    break;
            }
        }
        return commonSocialPage;

    }

    public abstract boolean verifyfacebook();
    public abstract boolean verifytwitter();

}

