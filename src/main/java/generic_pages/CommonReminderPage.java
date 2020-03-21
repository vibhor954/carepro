package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages.CameraPage;
import pages.ReminderPage;
import utils.Constants;
import utils.GlobalVars;

public abstract class CommonReminderPage {

    private static CommonReminderPage commonReminderPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonReminderPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonReminderPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonReminderPage = ReminderPage.getReminderPageInstance();
                    break;
            }
        }
        return commonReminderPage;

    }

    public abstract boolean addreminder(String title) throws InterruptedException;
    public abstract boolean deletereminder() throws InterruptedException;

}

