package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import utils.Constants;
import utils.GlobalVars;


// Compare this to a default method in an interface Java 8
public abstract class CommonSpritualityPage {

    private static CommonSpritualityPage commonSpritualityPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonSpritualityPage getInstance() {
        globalVars = GlobalVars.getInstance();
        logger = Log.getInstance();
        if (commonSpritualityPage == null) {
            switch (globalVars.getPlatform()) {
                case Constants.ANDROID:
                    commonSpritualityPage = pages.SpritualityPage.getSpritualityPageInstance();
                    break;
            }
        }
        return commonSpritualityPage;

    }

    public abstract boolean spritualitymeditation();
    public abstract boolean spritualityspritual(String text);

}

