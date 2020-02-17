package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import utils.Constants;
import utils.GlobalVars;


public abstract class CommonHomePage{

    private static CommonHomePage commonHomePage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonHomePage getInstance(){
        globalVars=GlobalVars.getInstance();
        logger= Log.getInstance();
        if(commonHomePage==null){
            switch(globalVars.getPlatform()){
                case Constants.ANDROID:
                    commonHomePage= pages.HomePage.getHomePageInstance();
                    break;
            }
        }
        return commonHomePage;

    }

    public abstract void homepageactivities();
    
    

}

