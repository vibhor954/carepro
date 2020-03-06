package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages.ArticlesPage;
import pages.MusicPage;
import utils.Constants;
import utils.GlobalVars;

public abstract class CommonMusicPage {

    private static CommonMusicPage commonMusicPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonMusicPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonMusicPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonMusicPage = MusicPage.getMusicPageInstance();
                    break;
            }
        }
        return commonMusicPage;

    }

    public abstract boolean addmusic(String title,String description,String type,String artist) throws InterruptedException;
    public abstract boolean updatemusic(String title,String description,String type,String artist,String updated) throws InterruptedException;
}

