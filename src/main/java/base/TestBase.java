package base;

import logger.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestContext;
import utils.*;
import java.io.*;
import java.util.Properties;

public abstract class TestBase{
    static InputStream input = null;
    public static DataReader dataReader = null;
    private static TestBase testBase=null;
    private static GlobalVars globalVars;
    private static Properties prop;

    public static GlobalVars setup(String className){
        instantiateClasses();
        if(!globalVars.getTestCaseListRunModeTrue().isEmpty()){
            testBase.initGlobalVars(className);
            testBase.initializeDriver();
            initializeLoggingAndReporting();
        }
        return globalVars;
    }

    public static void instantiateClasses(){
        globalVars=GlobalVars.getInstance();
        testBase= getInstance();
        dataReader = DataReader.getInstance();
    }

    public abstract void initializeDriver();

    public static TestBase getInstance(){
        if(testBase==null) {
            switch (globalVars.getPlatform()){
                case Constants.ANDROID:
                    testBase=new AndroidBase();
                    break;
            }
        }
        return testBase;
    }

    private static void initializeConfigPropertiesData(){
        globalVars.setIsAwsRun(Boolean.parseBoolean(prop.getProperty(Constants.IS_AWS_RUN)));
        globalVars.setIsAutoStartAppium(Boolean.parseBoolean(prop.getProperty(Constants.IS_AUTO_START_APPIUM)));
        globalVars.setJiraUrl(prop.getProperty(Constants.JIRA_URL));
        globalVars.setJiraUserName(prop.getProperty(Constants.JIRA_USERNAME));
        globalVars.setJiraPassword(prop.getProperty(Constants.JIRA_PASSWORD));
        globalVars.setJiraDefectAssignee(prop.getProperty(Constants.JIRA_DEFECT_ASSIGNEE));
        globalVars.setAppPackage(prop.getProperty(Constants.APP_PACKAGE));
        globalVars.setAppActivity(prop.getProperty(Constants.APP_ACTIVITY));
        globalVars.setAppWaitPackage(prop.getProperty(Constants.APP_WAIT_PACKAGE));
        globalVars.setUatUrl(prop.getProperty(Constants.UAT_URL));
       // globalVars.setTestLinkBuildName(prop.getProperty(Constants.TESTLINK_BUILDNAME));
       // globalVars.setTestLinkPlanId(prop.getProperty(Constants.TESTLINK_TESTPLANID));
        //globalVars.setTestLinkDevKey(prop.getProperty(Constants.TESTLINK_DEVKEY));
        globalVars.setTestLinkUrl(prop.getProperty(Constants.TESTLINK_URL));
        //globalVars.setMaxRetry(Integer.parseInt(prop.getProperty(Constants.MAX_RETRY)));
        globalVars.setImplicitWait(Integer.parseInt(prop.getProperty(Constants.IMPLICIT_WAIT)));
        globalVars.setSenderEmailId(prop.getProperty(Constants.SENDER_EMAIL_ID));
        globalVars.setSenderEmailPassword(prop.getProperty(Constants.SENDER_EMAIL_PASSWORD));
        globalVars.setJiraProjectName(prop.getProperty(Constants.JIRA_PROJECT_NAME));
        globalVars.setJiraDefectType(prop.getProperty(Constants.JIRA_DEFECT_TYPE));
    }


    public static void initGlobalVars(String className){
        try {
            globalVars.setClassDataElementMap(dataReader.getClassData(className));
            globalVars.setProp(new Properties());
            prop=globalVars.getProp();
            globalVars.setWorkingDir(System.getProperty("user.dir"));
            input = TestBase.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(input);
            initializeConfigPropertiesData();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void initializeLoggingAndReporting()
    {
        //********** Auto Start Appium Server ***************
        if(!globalVars.getIsAwsRun()){
            if(globalVars.getIsAutoStartAppium())
                AppiumServer.startServer();

            Utils.initializeExtentReport();
            //DOMConfigurator.configure(globalVars.getLog4jPath());
            Log.initializeLogProperties();
           // TestLinkUtil.setTestPlan();
        }

    }

    public static void tearDownSuite(ITestContext context) {
        if(!globalVars.getTestCaseListRunModeTrue().isEmpty()){
            if(!globalVars.getIsAwsRun()){
                Utils.closeExtentTest();
                // ***** calling the mail send method only if mail flag is true**********
                if(globalVars.getIsMailFlag())
                    SendMailSSLWithAttachmentUtil.sendEmail(context);
                //************ Auto Stop Appium Server based on boolean flag ************
                if(globalVars.getIsAutoStartAppium())
                    AppiumServer.stopServer();

            }
            //testBase.closeDriver();
        }
    }

    public abstract void closeDriver();

}
