import base.TestBase;
import generic_pages.CommonLoginPage;
import generic_pages.CommonReminderPage;
import generic_pages.CommonSocialPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;


public class ReminderTest {

    CommonLoginPage commonLoginPage;
    CommonReminderPage commonReminderPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
    public void addreminder() throws InterruptedException, IOException {
        boolean isResult = false;
        String title="";

        String currentMethodName = "addreminder";
        commonLoginPage=CommonLoginPage.getInstance();
        commonReminderPage=CommonReminderPage.getInstance();
        title = globalVars.getFirstParam(currentMethodName);
        commonLoginPage.login();
        isResult= commonReminderPage.addreminder(title);


        Utils.logStepInfo(isResult, "Add Reminder ");
        Assert.isTrue(isResult, "Step-1: User failed to Add Reminder!");
        Thread.sleep(2000);

    }

    @Test()
    public void deletereminder() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "deletereminder";
        commonLoginPage=CommonLoginPage.getInstance();
        commonReminderPage=CommonReminderPage.getInstance();
        isResult= commonReminderPage.deletereminder();


        Utils.logStepInfo(isResult, "Delete Reminder ");
        Assert.isTrue(isResult, "Step-1: User failed to Delete Reminder!");
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
