package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import utils.Constants;
import utils.GlobalVars;


// Compare this to a default method in an interface Java 8
public abstract class CommonEmailPage {

    private static CommonEmailPage commonEmailPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonEmailPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonEmailPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonEmailPage = pages.EmailPage.getEmailPageInstance();
                    break;
            }
        }
        return commonEmailPage;

    }

    public abstract void composeemail(String to, String subject,String description);
    public abstract boolean verifymailsent(String text);
    public abstract boolean verifymailreceived(String text) throws InterruptedException;
    public abstract boolean performsearch() throws InterruptedException;
    public abstract boolean deletetrashemails();
    public abstract boolean deleteinboxemails();
    public abstract boolean deletesentemails();
    public abstract boolean verifyemailfunctionality();
    public abstract boolean emailnegativecases(String to,String subject,String description) throws InterruptedException;
}

