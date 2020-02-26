package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages.NotePage;
import utils.Constants;
import utils.GlobalVars;


// Compare this to a default method in an interface Java 8
public abstract class CommonNotePage {

    private static CommonNotePage commonNotesPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonNotePage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonNotesPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonNotesPage = NotePage.getNotesPageInstance();
                    break;
            }
        }
        return commonNotesPage;

    }

    public abstract boolean addnote(String from,String description) throws InterruptedException;
    public abstract boolean note_negativescenerios(String from,String description) throws InterruptedException;
    public abstract boolean updatenote(String from,String description,String updated) throws InterruptedException;
    public abstract boolean verifysearch(String from,String description) throws InterruptedException;

}

