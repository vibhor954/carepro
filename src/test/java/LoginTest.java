import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import generic_pages.CommonSignupPage;
import generic_pages.CommonHomePage;
import generic_pages.CommonLoginPage;
import utils.GlobalVars;
import utils.Utils;


public class LoginTest {

    CommonLoginPage commonLoginPage;
    CommonHomePage commonHomePage;
    CommonSignupPage commonSignupPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
    public void loginwithvalidcredentials() throws InterruptedException {
        boolean isResult = false;
        System.out.println("Here");

        String email = "";
        String password = "";
        String currentMethodName = "loginwithvalidcredentials";
        commonLoginPage = CommonLoginPage.getInstance();

        email = globalVars.getFirstParam(currentMethodName);
        password = globalVars.getSecondParam(currentMethodName);

        isResult = commonLoginPage.loginwithvalidcredentials(email, password);
        Utils.logStepInfo(isResult, "Login with valid credentials");
        Assert.isTrue(isResult, "Step-1: User failed to Login!");

    }

    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
