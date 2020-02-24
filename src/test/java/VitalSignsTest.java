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


        Utils.logStepInfo(isResult, "Verify Add Vital Signs");
        Assert.isTrue(isResult, "Step-1: User failed to Add Vital Signs!");
        Thread.sleep(2000);

    }

    @Test()
    public void addvitalsignsithotheroption() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";
        String testtype="";
        String units="";

        String currentMethodName = "addvitalsignsithotheroption";
        commonLoginPage=CommonLoginPage.getInstance();
        commonVitalSignsPage=CommonVitalSignsPage.getInstance();
        doctorname = globalVars.getFirstParam(currentMethodName);
        testtype = globalVars.getSecondParam(currentMethodName);
        units = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonVitalSignsPage.addvitalsignsithotheroption(doctorname,testtype,units);


        Utils.logStepInfo(isResult, "Verify Add Vital Signs with Other Option");
        Assert.isTrue(isResult, "Step-1: User failed to Add Vital Signs with Other Option!");
        Thread.sleep(2000);

    }

    @Test()
    public void updatevitalsigns() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";
        String testtype="";
        String units="";
        String updatedtest="";

        String currentMethodName = "updatevitalsigns";
        commonLoginPage=CommonLoginPage.getInstance();
        commonVitalSignsPage=CommonVitalSignsPage.getInstance();
        doctorname = globalVars.getFirstParam(currentMethodName);
        testtype = globalVars.getSecondParam(currentMethodName);
        units = globalVars.getThirdParam(currentMethodName);
        updatedtest=globalVars.getFourthParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonVitalSignsPage.updatevitalsigns(doctorname,testtype,units,updatedtest);


        Utils.logStepInfo(isResult, "Update Vital Signs");
        Assert.isTrue(isResult, "Step-1: User failed to Update Vital Signs!");
        Thread.sleep(2000);

    }

    @Test()
    public void verifysearchfunctionality() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";
        String testtype="";
        String units="";
        String updatedtest="";

        String currentMethodName = "verifysearchfunctionality";
        commonLoginPage=CommonLoginPage.getInstance();
        commonVitalSignsPage=CommonVitalSignsPage.getInstance();
        doctorname = globalVars.getFirstParam(currentMethodName);
        testtype = globalVars.getSecondParam(currentMethodName);
        units = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonVitalSignsPage.verifysearch(doctorname,testtype,units);


        Utils.logStepInfo(isResult, "Verify Search Functionaity");
        Assert.isTrue(isResult, "Step-1: User failed to Search Vital Signs!");
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
