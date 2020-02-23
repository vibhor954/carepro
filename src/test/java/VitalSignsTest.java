import base.TestBase;
import generic_pages.CommonLoginPage;
import generic_pages.CommonMedicineSchedulePage;
import generic_pages.CommonVitalSignsPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;


public class VitalSignsTest {

    CommonLoginPage commonLoginPage;
   CommonVitalSignsPage commonVitalSignsPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
    public void addvitalsigns() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";
        String testtype="";
        String units="";

        String currentMethodName = "addvitalsigns";
        commonLoginPage=CommonLoginPage.getInstance();
        commonVitalSignsPage=CommonVitalSignsPage.getInstance();
        doctorname = globalVars.getFirstParam(currentMethodName);
        testtype = globalVars.getSecondParam(currentMethodName);
        units = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonVitalSignsPage.addvitalsigns(doctorname,testtype,units);


        Utils.logStepInfo(isResult, "Verify Add Medicine");
        Assert.isTrue(isResult, "Step-1: User failed to Add Medicine!");
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
