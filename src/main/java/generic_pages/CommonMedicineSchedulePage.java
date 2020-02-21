package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import utils.Constants;
import utils.GlobalVars;


// Compare this to a default method in an interface Java 8
public abstract class CommonMedicineSchedulePage {

    private static CommonMedicineSchedulePage commonMedicineSchedulePage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonMedicineSchedulePage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonMedicineSchedulePage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonMedicineSchedulePage = pages.MedicineSchedulePage.getMedicineSchedulePageInstance();
                    break;
            }
        }
        return commonMedicineSchedulePage;

    }

    public abstract boolean verifyaddmedicine(String text,String name,String days) throws InterruptedException;
    public abstract boolean verifyaddmedicinewithotheroption(String text,String name,String days) throws InterruptedException;
    public abstract boolean verifysearch_medicine(String text,String name,String days) throws InterruptedException;

}

