package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages.ArticlesPage;
import pages.TestReportPage;
import utils.Constants;
import utils.GlobalVars;

public abstract class CommonArticlesPage {

    private static CommonArticlesPage commonArticlesPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonArticlesPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonArticlesPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonArticlesPage = ArticlesPage.getArticlesPageInstance();
                    break;
            }
        }
        return commonArticlesPage;

    }

    public abstract boolean addarticle(String title,String description,String artist) throws InterruptedException;
    public abstract boolean updatearticle(String title,String description,String artist,String update) throws InterruptedException;
    public abstract boolean selectarticleasfavorite(String title,String description,String artist) throws InterruptedException;
//    public abstract boolean negativescenerios(String reportname,String doctor,String test,String folder,String description) throws InterruptedException;

}

