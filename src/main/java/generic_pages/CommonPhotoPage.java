package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages.NotePage;
import pages.PhotoPage;
import utils.Constants;
import utils.GlobalVars;

public abstract class CommonPhotoPage {

    private static CommonPhotoPage commonPhotoPagePage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonPhotoPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonPhotoPagePage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonPhotoPagePage = PhotoPage.getPhotoPageInstance();
                    break;
            }
        }
        return commonPhotoPagePage;

    }

    public abstract boolean addphotofromgallery_crop(String folder) throws InterruptedException;
    public abstract boolean addphotofromgallery_full(String folder) throws InterruptedException;
    public abstract boolean addphotofromcamera_crop() throws InterruptedException;
    public abstract boolean addphotofromcamera_full() throws InterruptedException;
    public abstract boolean slidephoto() throws InterruptedException;
    public abstract boolean choosefavoritephoto(String folder) throws InterruptedException;
    public abstract boolean negativescenerios(String folder) throws InterruptedException;


}

