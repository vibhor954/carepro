import base.TestBase;
import generic_pages.CommonForgotPasswordPage;
import generic_pages.CommonHomePage;
import generic_pages.CommonLoginPage;
import generic_pages.CommonSignupPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;


public class ForgotPasswordTest {

    CommonLoginPage commonLoginPage;
    CommonHomePage commonHomePage;
    CommonSignupPage commonSignupPage;
    CommonForgotPasswordPage commonForgotPasswordPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
    public void forgotpasswordwithinvaliddata() throws InterruptedException {
        boolean isResult = false;
        System.out.println("Here");

        String message = "";
        String regsitered_email = "";
        String password = "";
        String invalid_email="";
        String currentMethodName = "forgotpasswordwithinvaliddata";
        commonForgotPasswordPage = CommonForgotPasswordPage.getInstance();

        message = globalVars.getFirstParam(currentMethodName);
        regsitered_email = globalVars.getSecondParam(currentMethodName);
        password = globalVars.getThirdParam(currentMethodName);
        invalid_email = globalVars.getFourthParam(currentMethodName);

        isResult = commonForgotPasswordPage.forgotpasswordwithinvaliddata(message, regsitered_email,password,invalid_email);
        Utils.logStepInfo(isResult, "Login with valid credentials");
        Assert.isTrue(isResult, "Step-1: User failed to Login!");

    }

    @Test()
    public void forgotpasswordwithvaliddata() throws InterruptedException {
        boolean isResult = false;
        System.out.println("Here");


        String registered_email = "";
        String password = "";
        String currentMethodName = "forgotpasswordwithvaliddata";
        commonForgotPasswordPage = CommonForgotPasswordPage.getInstance();

        registered_email = globalVars.getFirstParam(currentMethodName);
        password = globalVars.getSecondParam(currentMethodName);


        isResult = commonForgotPasswordPage.forgotpasswordwithvaliddata(registered_email,password);
        Utils.logStepInfo(isResult, "Login with valid credentials");
        Assert.isTrue(isResult, "Step-1: User failed to Login!");

    }


    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
