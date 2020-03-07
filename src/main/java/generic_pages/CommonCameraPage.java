package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages.CameraPage;
import pages.MusicPage;
import utils.Constants;
import utils.GlobalVars;

public abstract class CommonCameraPage {

    private static CommonCameraPage commonCameraPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonCameraPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonCameraPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonCameraPage = CameraPage.getCameraPageInstance();
                    break;
            }
        }
        return commonCameraPage;

    }

    public abstract boolean savepic_fullsize() throws InterruptedException;
    public abstract boolean savepic_cropped() throws InterruptedException;

}

