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


public class SocialTest {

    CommonLoginPage commonLoginPage;
    CommonSocialPage commonSocialPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
    public void verifyfacebook() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "verifyfacebook";
        commonLoginPage=CommonLoginPage.getInstance();
        commonSocialPage=CommonSocialPage.getInstance();
        commonLoginPage.login();
        isResult= commonSocialPage.verifyfacebook();


        Utils.logStepInfo(isResult, "verify facebook ");
        Assert.isTrue(isResult, "Step-1: User failed to access verify facebook!");
        Thread.sleep(2000);

    }

    @Test()
    public void verifytwitter() throws InterruptedException, IOException {
        boolean isResult = false;
        commonSocialPage=CommonSocialPage.getInstance();

        String currentMethodName = "verifytwitter";
        isResult= commonSocialPage.verifytwitter();


        Utils.logStepInfo(isResult, "verify twitter");
        Assert.isTrue(isResult, "Step-1: User failed to access verify twitter!");
        Thread.sleep(2000);

    }



    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
