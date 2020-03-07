package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages.CameraPage;
import pages.MoviePage;
import utils.Constants;
import utils.GlobalVars;

public abstract class CommonMoviePage {

    private static CommonMoviePage commonMoviePage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonMoviePage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonMoviePage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonMoviePage = MoviePage.getMoviePageInstance();
                    break;
            }
        }
        return commonMoviePage;

    }

    public abstract boolean addmovie(String title,String description,String type,String artist) throws InterruptedException;

}

