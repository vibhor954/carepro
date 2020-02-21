package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import utils.Constants;
import utils.GlobalVars;


// Compare this to a default method in an interface Java 8
public abstract class CommonDoctorAppointmentPage {

    private static CommonDoctorAppointmentPage commonDoctorAppointmentPagePage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonDoctorAppointmentPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonDoctorAppointmentPagePage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonDoctorAppointmentPagePage = pages.DoctorAppointmentPage.getDoctorAppointmentPageInstance();
                    break;
            }
        }
        return commonDoctorAppointmentPagePage;

    }

    public abstract boolean verifysearch(String text) throws InterruptedException;
    public abstract boolean makedoctorappointment(String text,String month,String days);
    public abstract boolean verifypastdateappointment(String text,String day) throws InterruptedException;
    public abstract boolean makedoctorappointment_doctornotavailable(String text);

}

