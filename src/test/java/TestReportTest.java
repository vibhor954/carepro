import base.TestBase;
import generic_pages.CommonLoginPage;
import generic_pages.CommonPhotoPage;
import generic_pages.CommonTestReportPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;


public class TestReportTest {

    CommonLoginPage commonLoginPage;
    CommonTestReportPage commonTestReportPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
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

    @Test()
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

    @Test()
    public void updatetestreport() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctor="";
        String reportname="";
        String test="";
        String updated="";
        String description="";

        String currentMethodName = "updatetestreport";
        commonLoginPage=CommonLoginPage.getInstance();
        commonTestReportPage=CommonTestReportPage.getInstance();
        reportname = globalVars.getFirstParam(currentMethodName);
        doctor = globalVars.getSecondParam(currentMethodName);
        test = globalVars.getThirdParam(currentMethodName);
        updated = globalVars.getFourthParam(currentMethodName);
        description = globalVars.getFifthParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonTestReportPage.updatetestreport(reportname,doctor,test,updated,description);


        Utils.logStepInfo(isResult, "Verify Update Test Report");
        Assert.isTrue(isResult, "Step-1: User failed to Update Test Report!");
        Thread.sleep(2000);

    }




    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
