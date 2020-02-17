package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.util.*;

//This class will have all the global variables to be used across the classes and packages
public class GlobalVars {
    //TODO: Remove
    static GlobalVars globalVars;
    private AppiumDriver driver;
    //private WebDriver webDriver;
    private Properties prop;
    private String workingDir;
    private String platform;
    private String deviceNameAndroid;
    private String platformVersionAndroid;
    private String appiumServerIp;
    private String appiumServerPort;
    private String apkFileName;
    private String deviceNameIOS;
    private String ipaFileName;
    private String udid;
    private String xcodeOrgId;
    private String xcodeSigningId;
    private String updateWDABundleId;
    private boolean connectHardwareKeyboard;
    private String automationname;
    private String platformVersionIOS;
    private String url;
    private String devKey;
    private String buildName;
    private String testPlanID;
    private List<String> mailRecipientList = new ArrayList<String>();
    private boolean jiraFlag = false;
    private boolean testLinkFlag = false;
    private boolean mailFlag = false;
    private boolean isHomePageSetup = false;
    private boolean isAwsRun = false;
    private boolean isAutoStartAppium = false;
    private String jiraUrl;
    private String jiraUserName;
    private String jiraPassword;
    private String jiraDefectAssignee;
    private List<String> testCaseListRunModeTrue = new ArrayList<>();
    private Map<String, DataElements> classDataElementMap=new HashMap<>();
    private String appPackage;
    private String appActivity;
    private String appWaitPackage;
    private String uatUrl;
    private String testLinkBuildName;
    private String testLinkPlanId;
    private String testLinkDevKey;
    private String testLinkUrl;
    private int maxRetry;
    private long implicitWait;
    private String senderEmailId;
    private String senderEmailPassword;
    private String jiraProjectName;
    private String jiraDefectType;


    public static GlobalVars getInstance() {
        if (globalVars == null)
            globalVars = new GlobalVars();
        return globalVars;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }

//    public WebDriver getWebDriver() {
//        return webDriver;
//    }
//
//    public void setWebDriver(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDeviceNameAndroid() {
        return deviceNameAndroid;
    }

    public void setDeviceNameAndroid(String deviceNameAndroid) {
        this.deviceNameAndroid = deviceNameAndroid;
    }

    public String getPlatformVersionAndroid() {
        return platformVersionAndroid;
    }

    public void setPlatformVersionAndroid(String platformVersionAndroid) {
        this.platformVersionAndroid = platformVersionAndroid;
    }

    public String getAppiumServerIp() {
        return appiumServerIp;
    }

    public void setAppiumServerIp(String appiumServerIp) {
        this.appiumServerIp = appiumServerIp;
    }

    public String getAppiumServerPort() {
        return appiumServerPort;
    }

    public void setAppiumServerPort(String appiumServerPort) {
        this.appiumServerPort = appiumServerPort;
    }

    public String getApkFileName() {
        return apkFileName;
    }

    public void setApkFileName(String apkFileName) {
        this.apkFileName = apkFileName;
    }

    public String getDeviceNameIOS() {
        return deviceNameIOS;
    }

    public void setDeviceNameIOS(String deviceNameIOS) {
        this.deviceNameIOS = deviceNameIOS;
    }

    public String getIpaFileName() {
        return ipaFileName;
    }

    public void setIpaFileName(String ipaFileName) {
        this.ipaFileName = ipaFileName;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getXcodeOrgId() {
        return xcodeOrgId;
    }

    public void setXcodeOrgId(String xcodeOrgId) {
        this.xcodeOrgId = xcodeOrgId;
    }

    public String getXcodeSigningId() {
        return xcodeSigningId;
    }

    public void setXcodeSigningId(String xcodeSigningId) {
        this.xcodeSigningId = xcodeSigningId;
    }

    public String getUpdateWDABundleId() {
        return updateWDABundleId;
    }

    public void setUpdateWDABundleId(String updateWDABundleId) {
        this.updateWDABundleId = updateWDABundleId;
    }

    public boolean isConnectHardwareKeyboard() {
        return connectHardwareKeyboard;
    }

    public void setConnectHardwareKeyboard(boolean connectHardwareKeyboard) {
        this.connectHardwareKeyboard = connectHardwareKeyboard;
    }

    public String getAutomationname() {
        return automationname;
    }

    public void setAutomationname(String automationname) {
        this.automationname = automationname;
    }

    public String getPlatformVersionIOS() {
        return platformVersionIOS;
    }

    public void setPlatformVersionIOS(String platformVersionIOS) {
        this.platformVersionIOS = platformVersionIOS;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDevKey() {
        return devKey;
    }

    public void setDevKey(String devKey) {
        this.devKey = devKey;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getTestPlanID() {
        return testPlanID;
    }

    public void setTestPlanID(String testPlanID) {
        this.testPlanID = testPlanID;
    }

    public List<String> getMailRecipientList() {
        return mailRecipientList;
    }

    public void setMailRecipientList(List<String> mailRecipientList) {
        this.mailRecipientList = mailRecipientList;
    }

    public boolean getJiraFlag() {
        return jiraFlag;
    }

    public void setJiraFlag(boolean jiraFlag) {
        this.jiraFlag = jiraFlag;
    }

    public boolean isTestLinkFlag() {
        return testLinkFlag;
    }

    public void setTestLinkFlag(boolean testLinkFlag) {
        this.testLinkFlag = testLinkFlag;
    }

    public boolean getIsMailFlag() {
        return mailFlag;
    }

    public void setIsMailFlag(boolean mailFlag) {
        this.mailFlag = mailFlag;
    }

    public boolean getIsHomePageSetup() {
        return isHomePageSetup;
    }

    public void setIsHomePageSetup(boolean isHomePageSetup) {
        this.isHomePageSetup = isHomePageSetup;
    }

    public boolean getIsAwsRun() {
        return isAwsRun;
    }

    public void setIsAwsRun(boolean isAwsRun) {
        this.isAwsRun = isAwsRun;
    }

    public boolean getIsAutoStartAppium() {
        return isAutoStartAppium;
    }

    public void setIsAutoStartAppium(boolean isAutoStartAppium) {
        this.isAutoStartAppium = isAutoStartAppium;
    }

    public String getJiraUrl() {
        return jiraUrl;
    }

    public void setJiraUrl(String jiraUrl) {
        this.jiraUrl = jiraUrl;
    }

    public String getJiraUserName() {
        return jiraUserName;
    }

    public void setJiraUserName(String jiraUserName) {
        this.jiraUserName = jiraUserName;
    }

    public String getJiraPassword() {
        return jiraPassword;
    }

    public void setJiraPassword(String jiraPassword) {
        this.jiraPassword = jiraPassword;
    }

    public String getJiraDefectAssignee() {
        return jiraDefectAssignee;
    }

    public void setJiraDefectAssignee(String jiraDefectAssignee) {
        this.jiraDefectAssignee = jiraDefectAssignee;
    }

    public List<String> getTestCaseListRunModeTrue() {
        return testCaseListRunModeTrue;
    }

    public void setTestCaseListRunModeTrue(String testCaseListRunModeTrue) {
        this.testCaseListRunModeTrue.add(testCaseListRunModeTrue);
    }

    public Map<String, DataElements> getClassDataElementMap() {
        return classDataElementMap;
    }

    public void setClassDataElementMap(Map<String, DataElements> classDataElementMap) {
        for(Map.Entry<String, DataElements> entry: classDataElementMap.entrySet()){
            this.classDataElementMap.put(entry.getKey(), entry.getValue());
        }
    }

    public String getFirstParam(String methodName) {
        return getClassDataElementMap().get(methodName).getParams().trim().split(",")[0];
    }

    public String getSecondParam(String methodName) {
        return getClassDataElementMap().get(methodName).getParams().trim().split(",")[1];
    }

    public String getThirdParam(String methodName) {
        return getClassDataElementMap().get(methodName).getParams().trim().split(",")[2];
    }

    public String getFourthParam(String methodName) {
        return getClassDataElementMap().get(methodName).getParams().trim().split(",")[3];
    }
    public String getFifthParam(String methodName) {
        return getClassDataElementMap().get(methodName).getParams().trim().split(",")[4];
    }

    public String getLog4jPath() {
        return getWorkingDir() + "/log4j.xml";
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public String getAppWaitPackage() {
        return appWaitPackage;
    }

    public void setAppWaitPackage(String appWaitPackage) {
        this.appWaitPackage = appWaitPackage;
    }

    public String getWebDriverPath() {
        return getWorkingDir() + "/src/main/resources/Drivers/chromedriver";
    }

    public String getUatUrl() {
        return uatUrl;
    }

    public void setUatUrl(String uatUrl) {
        this.uatUrl = uatUrl;
    }

    public String getTestLinkBuildName() {
        return testLinkBuildName;
    }

    public void setTestLinkBuildName(String testLinkBuildName) {
        this.testLinkBuildName = testLinkBuildName;
    }

    public String getTestLinkPlanId() {
        return testLinkPlanId;
    }

    public void setTestLinkPlanId(String testLinkPlanId) {
        this.testLinkPlanId = testLinkPlanId;
    }

    public String getTestLinkDevKey() {
        return testLinkDevKey;
    }

    public void setTestLinkDevKey(String testLinkDevKey) {
        this.testLinkDevKey = testLinkDevKey;
    }

    public String getTestLinkUrl() {
        return testLinkUrl;
    }

    public void setTestLinkUrl(String testLinkUrl) {
        this.testLinkUrl = testLinkUrl;
    }

    public int getMaxRetry() {
        return maxRetry;
    }

    public void setMaxRetry(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    public long getImplicitWait() {
        return implicitWait;
    }

    public void setImplicitWait(long implicitWait) {
        this.implicitWait = implicitWait;
    }

    public String getSenderEmailId() {
        return senderEmailId;
    }

    public void setSenderEmailId(String senderEmailId) {
        this.senderEmailId = senderEmailId;
    }

    public String getSenderEmailPassword() {
        return senderEmailPassword;
    }

    public void setSenderEmailPassword(String senderEmailPassword) {
        this.senderEmailPassword = senderEmailPassword;
    }

    public String getJiraProjectName() {
        return jiraProjectName;
    }

    public void setJiraProjectName(String jiraProjectName) {
        this.jiraProjectName = jiraProjectName;
    }

    public String getJiraDefectType() {
        return jiraDefectType;
    }

    public void setJiraDefectType(String jiraDefectType) {
        this.jiraDefectType = jiraDefectType;
    }

}
