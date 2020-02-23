import base.TestBase;
import generic_pages.*;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;


public class MedicineScheduleTest {

    CommonLoginPage commonLoginPage;
   CommonMedicineSchedulePage commonMedicineSchedulePage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
    public void verifyaddmedicine() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";
        String medicinename="";
        String days="";

        String currentMethodName = "verifyaddmedicine";
        commonLoginPage=CommonLoginPage.getInstance();
        commonMedicineSchedulePage=CommonMedicineSchedulePage.getInstance();
        medicinename = globalVars.getFirstParam(currentMethodName);
        doctorname = globalVars.getSecondParam(currentMethodName);
        days = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonMedicineSchedulePage.verifyaddmedicine(medicinename,doctorname,days);


        Utils.logStepInfo(isResult, "Verify Add Medicine");
        Assert.isTrue(isResult, "Step-1: User failed to Add Medicine!");
        Thread.sleep(2000);

    }

    @Test()
    public void verifyaddmedicinewithotheroption() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";
        String medicinename="";
        String days="";

        String currentMethodName = "verifyaddmedicinewithotheroption";
        commonLoginPage=CommonLoginPage.getInstance();
        commonMedicineSchedulePage=CommonMedicineSchedulePage.getInstance();
        medicinename = globalVars.getFirstParam(currentMethodName);
        doctorname = globalVars.getSecondParam(currentMethodName);
        days = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonMedicineSchedulePage.verifyaddmedicinewithotheroption(medicinename,doctorname,days);


        Utils.logStepInfo(isResult, "Verify Add Medicine with Other Option");
        Assert.isTrue(isResult, "Step-1: User failed to Add Medicine with Other Option!");
        Thread.sleep(2000);

    }

    @Test()
    public void verifysearch_update_medicine() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";
        String medicinename="";
        String days="";

        String currentMethodName = "verifysearch_update_medicine";
        commonLoginPage=CommonLoginPage.getInstance();
        commonMedicineSchedulePage=CommonMedicineSchedulePage.getInstance();
        medicinename = globalVars.getFirstParam(currentMethodName);
        doctorname = globalVars.getSecondParam(currentMethodName);
        days = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonMedicineSchedulePage.verifysearch_medicine(medicinename,doctorname,days);


        Utils.logStepInfo(isResult, "Verify Search and Update Medicine");
        Assert.isTrue(isResult, "Step-1: User failed to Search Medicine!");
        Thread.sleep(2000);

    }

    @Test()
    public void verifysetreminder() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";
        String medicinename="";
        String days="";

        String currentMethodName = "verifysetreminder";
        commonLoginPage=CommonLoginPage.getInstance();
        commonMedicineSchedulePage=CommonMedicineSchedulePage.getInstance();
        medicinename = globalVars.getFirstParam(currentMethodName);
        doctorname = globalVars.getSecondParam(currentMethodName);
        days = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonMedicineSchedulePage.verifysetreminder(medicinename,doctorname,days);



        Utils.logStepInfo(isResult, "Verify Set Reminder");
        Assert.isTrue(isResult, "Step-1: User failed to Set Reminder!");
        Thread.sleep(2000);

    }



    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
