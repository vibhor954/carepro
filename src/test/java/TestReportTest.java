import base.TestBase;
import generic_pages.CommonLoginPage;
import generic_pages.CommonPhotoPage;
import generic_pages.CommonTestReportPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;


public class TestReportTest {

    CommonLoginPage commonLoginPage;
    CommonTestReportPage commonTestReportPage;
    GlobalVars globalVars;


   // @BeforeMethod
   @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test(priority = 1)
    public void uploadtestreport() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctor="";
        String reportname="";
        String test="";
        String file="";
        String description="";

        String currentMethodName = "uploadtestreport";
        commonLoginPage=CommonLoginPage.getInstance();
        commonTestReportPage=CommonTestReportPage.getInstance();
        reportname = globalVars.getFirstParam(currentMethodName);
        doctor = globalVars.getSecondParam(currentMethodName);
        test = globalVars.getThirdParam(currentMethodName);
        file = globalVars.getFourthParam(currentMethodName);
        description = globalVars.getFifthParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonTestReportPage.uploadtestreport(reportname,doctor,test,file,description);


        Utils.logStepInfo(isResult, "Verify Upload Test Report");
        Assert.isTrue(isResult, "Step-1: User failed to Upload Test Report!");
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void uploadtestreportwithotheroption() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctor="";
        String reportname="";
        String test="";
        String file="";
        String description="";

        String currentMethodName = "uploadtestreportwithotheroption";
        commonLoginPage=CommonLoginPage.getInstance();
        commonTestReportPage=CommonTestReportPage.getInstance();
        reportname = globalVars.getFirstParam(currentMethodName);
        doctor = globalVars.getSecondParam(currentMethodName);
        test = globalVars.getThirdParam(currentMethodName);
        file = globalVars.getFourthParam(currentMethodName);
        description = globalVars.getFifthParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonTestReportPage.uploadtestreportwithotheroption(reportname,doctor,test,file,description);


        Utils.logStepInfo(isResult, "Verify Upload Test Report");
        Assert.isTrue(isResult, "Step-1: User failed to Upload Test Report!");
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    public void updatetestreport() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctor="";
        String reportname="";
        String test="";
        String updated="";
        String description="";
        String sendtouser="";

        String currentMethodName = "updatetestreport";
        commonLoginPage=CommonLoginPage.getInstance();
        commonTestReportPage=CommonTestReportPage.getInstance();
        reportname = globalVars.getFirstParam(currentMethodName);
        doctor = globalVars.getSecondParam(currentMethodName);
        test = globalVars.getThirdParam(currentMethodName);
        updated = globalVars.getFourthParam(currentMethodName);
        description = globalVars.getFifthParam(currentMethodName);
        sendtouser = globalVars.getSixthParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonTestReportPage.updatetestreport(reportname,doctor,test,updated,description, sendtouser);


        Utils.logStepInfo(isResult, "Verify Update Test Report");
        Assert.isTrue(isResult, "Step-1: User failed to Update Test Report!");
        Thread.sleep(2000);

    }

    @Test(priority = 4)
    public void negativescenerios_testreport() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctor="";
        String reportname="";
        String test="";
        String file="";
        String description="";

        String currentMethodName = "negativescenerios_testreport";
        commonLoginPage=CommonLoginPage.getInstance();
        commonTestReportPage=CommonTestReportPage.getInstance();
        reportname = globalVars.getFirstParam(currentMethodName);
        doctor = globalVars.getSecondParam(currentMethodName);
        test = globalVars.getThirdParam(currentMethodName);
        file = globalVars.getFourthParam(currentMethodName);
        description = globalVars.getFifthParam(currentMethodName);

        //commonLoginPage.login();
        isResult= commonTestReportPage.negativescenerios(reportname,doctor,test,file,description);


        Utils.logStepInfo(isResult, "Verify Test Report Negative Scenerios ");
        Assert.isTrue(isResult, "Step-1: User failed to Verify Negative Test Report Scenerios!");
        Thread.sleep(2000);

    }





   // @AfterMethod
    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
