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


public class DoctorAppointmentTest {

    CommonLoginPage commonLoginPage;
    CommonDoctorAppointmentPage commonDoctorAppointmentPage;
    CommonSignupPage commonSignupPage;
    CommonEmailPage commonEmailPage;
    CommonSpritualityPage commonSpritualityPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
    public void verifysearch() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";

        String currentMethodName = "verifysearch";
        commonLoginPage=CommonLoginPage.getInstance();
        commonDoctorAppointmentPage=CommonDoctorAppointmentPage.getInstance();
        doctorname = globalVars.getFirstParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonDoctorAppointmentPage.verifysearch(doctorname);


        Utils.logStepInfo(isResult, "Verify Search");
        Assert.isTrue(isResult, "Step-1: User failed to Perform Search!");
        Thread.sleep(2000);

    }

    @Test()
    public void makedoctorappointment() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";
        String month="";
        String days="";

        String currentMethodName = "makedoctorappointment";
        commonLoginPage=CommonLoginPage.getInstance();
        commonDoctorAppointmentPage=CommonDoctorAppointmentPage.getInstance();
        doctorname = globalVars.getFirstParam(currentMethodName);
        month = globalVars.getSecondParam(currentMethodName);
        days = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonDoctorAppointmentPage.makedoctorappointment(doctorname,month,days);


        Utils.logStepInfo(isResult, "Make Doctor Appointment");
        Assert.isTrue(isResult, "Step-1: User failed to make doctor appointment!");
        Thread.sleep(2000);

    }

    @Test()
    public void verifypastdateappointment() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";
        String day="";

        String currentMethodName = "verifypastdateappointment";
        commonLoginPage=CommonLoginPage.getInstance();
        commonDoctorAppointmentPage=CommonDoctorAppointmentPage.getInstance();
        doctorname = globalVars.getFirstParam(currentMethodName);
        day = globalVars.getSecondParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonDoctorAppointmentPage.verifypastdateappointment(doctorname,day);


        Utils.logStepInfo(isResult, "Verify Past Date Appointment");
        Assert.isTrue(isResult, "Step-1: User failed to verified past date appointment!");
        Thread.sleep(2000);

    }
    @Test()
    public void makedoctorappointment_doctornotavailable() throws InterruptedException, IOException {
        boolean isResult = false;
        String doctorname="";

        String currentMethodName = "makedoctorappointment_doctornotavailable";
        commonLoginPage=CommonLoginPage.getInstance();
        commonDoctorAppointmentPage=CommonDoctorAppointmentPage.getInstance();
        doctorname = globalVars.getFirstParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonDoctorAppointmentPage.makedoctorappointment_doctornotavailable(doctorname);


        Utils.logStepInfo(isResult, "Verify Doctor Appointment Not Possible When Doctor Not Available");
        Assert.isTrue(isResult, "Step-1: User failed to verify doctor appointment not possible when doctor not available!");
        Thread.sleep(2000);

    }



    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
