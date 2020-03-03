package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages.PhotoPage;
import pages.TestReportPage;
import utils.Constants;
import utils.GlobalVars;

public abstract class CommonTestReportPage {

    private static CommonTestReportPage commonTestReportPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonTestReportPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonTestReportPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonTestReportPage = TestReportPage.getTestReportPageInstance();
                    break;
            }
        }
        return commonTestReportPage;

    }

    public abstract boolean uploadtestreport(String reportname,String doctor,String test,String folder,String description) throws InterruptedException;
    public abstract boolean uploadtestreportwithotheroption(String reportname,String doctor,String test,String folder,String description) throws InterruptedException;
    public abstract boolean updatetestreport(String reportname,String doctor,String test,String folder,String description) throws InterruptedException;

}

