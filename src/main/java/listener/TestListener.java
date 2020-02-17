package listener;

import logger.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.*;

public class TestListener implements ITestListener {
    private static GlobalVars globalVars;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        globalVars=GlobalVars.getInstance();
        if(!globalVars.getIsAwsRun()){
            Utils.initializeExtentTest(iTestResult.getMethod().getMethodName());
            Log.startTestCase(iTestResult.getMethod().getMethodName());
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        if(!globalVars.getIsAwsRun()){
            Log.endTestCase(iTestResult.getTestName());
            Utils.closeExtentTest();
            /*if(testLinkFlag){
                if(TestLinkUtil.testLink.get()!=null){
                    for (Integer id : TestLinkUtil.testLink.get()) {
                        TestLinkUtil.setResult(id, ExecutionStatus.PASSED);
                    }
                }
            }*/
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        if(!globalVars.getIsAwsRun()) {
            Log.endTestCase(iTestResult.getTestName());
            Utils.closeExtentTest();
            try {
                /********* On failure of a test case, raise a bug on JIRA ******************/
//                if(globalVars.getJiraFlag()){ //GlobalVars.prop.getProperty(Constants.IS_CREATE_BUG).equalsIgnoreCase("true"
//                    JiraOperationsUtil.createJiraInstance(globalVars.getJiraUrl(), globalVars.getJiraUserName(), globalVars.getJiraPassword());
//                    JiraOperationsUtil.createNewIssue("Test Automation Bug: " +iTestResult.getName() ,
//                            "Test failed for test case: " + iTestResult.getName(),
//                            "AutomatedTestExecutionBug", globalVars.getJiraDefectAssignee());
//                }
                /*if(testLinkFlag){
                    if(TestLinkUtil.testLink.get()!=null){
                        for (Integer id : TestLinkUtil.testLink.get()) {
                            TestLinkUtil.setResult(id, ExecutionStatus.FAILED);
                        }
                    }
                }*/
                Utils.captureScreenshot(iTestResult);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        /*if(testLinkFlag){
            if(TestLinkUtil.testLink.get()!=null){
                for (Integer id : TestLinkUtil.testLink.get()) {
                    TestLinkUtil.setResult(id, ExecutionStatus.NOT_RUN);
                }
            }
        }*/
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

