package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import utils.Constants;
import utils.GlobalVars;


// Compare this to a default method in an interface Java 8
public abstract class CommonVitalSignsPage {

    private static CommonVitalSignsPage commonVitalSignsPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonVitalSignsPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonVitalSignsPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonVitalSignsPage = pages.VitalSignsPage.getVitalSignsPageInstance();
                    break;
            }
        }
        return commonVitalSignsPage;

    }

    public abstract boolean addvitalsigns(String text,String name,String days) throws InterruptedException;
    public abstract boolean addvitalsignsithotheroption(String text,String name,String days) throws InterruptedException;
    public abstract boolean updatevitalsigns(String text,String name,String days,String update) throws InterruptedException;
    public abstract boolean verifysearch(String text,String name,String days) throws InterruptedException;

}

