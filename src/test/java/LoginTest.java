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

    @Test
    public void t1_loginwithvalidcredentials() throws InterruptedException {
        boolean isResult = false;

        String email = "";
        String password = "";
        String currentMethodName = "t1_loginwithvalidcredentials";
        commonLoginPage = CommonLoginPage.getInstance();

        email = globalVars.getFirstParam(currentMethodName);
        password = globalVars.getSecondParam(currentMethodName);

        isResult = commonLoginPage.loginwithvalidcredentials(email, password);
        Utils.logStepInfo(isResult, "Login with valid credentials");
        Assert.isTrue(isResult, "Step-1: User failed to Login!");

    }

    @Test
    public void t2_loginwithinvalidcredentials() throws InterruptedException {
        boolean isResult = false;

        String invalid_email = "";
        String invalid_password = "";
        String message = "";
        String valid_email = "";
        String valid_password = "";
        String currentMethodName = "t2_loginwithinvalidcredentials";
        commonLoginPage = CommonLoginPage.getInstance();

        invalid_email = globalVars.getFirstParam(currentMethodName);
        invalid_password = globalVars.getSecondParam(currentMethodName);
        message = globalVars.getThirdParam(currentMethodName);
        valid_email = globalVars.getFourthParam(currentMethodName);
        valid_password = globalVars.getFifthParam(currentMethodName);

        isResult = commonLoginPage.loginwithinvalidcredentials(invalid_email, invalid_password, message, valid_email, valid_password);
        Utils.logStepInfo(isResult, "Login with Invalid credentials");
        Assert.isTrue(isResult, "Step-1: User failed to verify login with invalid credentials!");

    }

    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
