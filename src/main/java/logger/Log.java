package logger;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    private static Logger logger;

    public static Logger getInstance(){
        if(logger==null)
            logger = Logger.getLogger(Log.class.getName());
        return logger;
    }


    public static void initializeLogProperties() {
        System.setProperty("org.freemarker.loggerLibrary", "none");
        System.setProperty("org.apache.log4j", "none");
        System.setProperty("org.apache.log4j.loggerLibrary", "none");
        getInstance();
        // setting up a FileAppender dynamically...
        try {
            SimpleLayout layout = new SimpleLayout();

            String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            timeStamp="log_"+timeStamp;

            FileAppender appender = new FileAppender(layout, "target/"+timeStamp+ ".txt",false);
            logger.addAppender(appender);

            logger.setLevel((Level) Level.DEBUG);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public static void startTestCase(String sTestCaseName){

        logger.info("****************************************************************************************");

        logger.info("****************************************************************************************");

        logger.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");

        logger.info("****************************************************************************************");

        logger.info("****************************************************************************************");

    }

    //This is to print log for the ending of the test case

    public static void endTestCase(String sTestCaseName){

        logger.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

        logger.info("X");

        logger.info("X");

        logger.info("X");

        logger.info("X");

    }

    // Need to create these methods, so that they can be called

    public static void info(String message) {
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        logger.info(timeStamp+"-"+message);

    }

    public static void warn(String message) {

        logger.warn(message);

    }

    public static void error(String message) {

        logger.error(message);

    }

    public static void fatal(String message) {

        logger.fatal(message);

    }

    public static void debug(String message) {

        logger.debug(message);

    }

}
