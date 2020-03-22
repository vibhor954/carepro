import base.TestBase;
import generic_pages.CommonEmailPage;
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

import java.io.IOException;


public class EmailTest {

    CommonLoginPage commonLoginPage;
    CommonHomePage commonHomePage;
    CommonSignupPage commonSignupPage;
    CommonEmailPage commonEmailPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test
    public void t1_sendemail() throws InterruptedException, IOException {
        boolean isResult = false;
        String to = "";
        String subject = "";
        String description = "";
        String verification_text="";
        String currentMethodName = "t1_sendemail";
        commonEmailPage = CommonEmailPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        to = globalVars.getFirstParam(currentMethodName);
        subject = globalVars.getSecondParam(currentMethodName);
        description = globalVars.getThirdParam(currentMethodName);
        verification_text = globalVars.getFourthParam(currentMethodName);
        commonLoginPage.login();
        commonEmailPage.composeemail(to,subject,description);
        isResult=commonEmailPage.verifymailsent(verification_text);
        System.out.println(isResult);

        Utils.logStepInfo(isResult, "Send Email");
        Assert.isTrue(isResult, "Step-1: User failed to sent email!");

    }

    @Test
    public void t2_recieveemail() throws InterruptedException, IOException {
        boolean isResult = false;

        String verification_text="";
        String currentMethodName = "t2_recieveemail";
        commonEmailPage = CommonEmailPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        verification_text = globalVars.getFirstParam(currentMethodName);
        //commonLoginPage.login();
        isResult=commonEmailPage.verifymailreceived(verification_text);
        System.out.println(isResult);


        Utils.logStepInfo(isResult, "Recieve Email");
        Assert.isTrue(isResult, "Step-1: User failed to Recieve email!");
    }

    @Test
    public void t3_deleteemailsfrominbox() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "t3_deleteemailsfrominbox";
        commonEmailPage = CommonEmailPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        isResult=commonEmailPage.deleteinboxemails();
        System.out.println(isResult);


        Utils.logStepInfo(isResult, "Delete Emails from Inbox");
        Assert.isTrue(isResult, "Step-1: User failed to delete email from Inbox!");
    }

    @Test
    public void t4_deleteemailsfromsent() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "t4_deleteemailsfromsent";
        commonEmailPage = CommonEmailPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        isResult=commonEmailPage.deletesentemails();
        System.out.println(isResult);


        Utils.logStepInfo(isResult, "Delete Emails from Inbox");
        Assert.isTrue(isResult, "Step-1: User failed to delete email from Inbox!");
    }

    @Test
    public void t5_deleteemailsfromtrash() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "t5_deleteemailsfromtrash";
        commonEmailPage = CommonEmailPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        isResult=commonEmailPage.deletetrashemails();
        System.out.println(isResult);


        Utils.logStepInfo(isResult, "Delete Emails from Trash");
        Assert.isTrue(isResult, "Step-1: User failed to delete email from Trash!");
    }
    @Test
    public void t6_emailnegativecases() throws InterruptedException, IOException {
        boolean isResult = false;
        String to = "";
        String subject = "";
        String description = "";

        String currentMethodName = "t6_emailnegativecases";
        commonEmailPage = CommonEmailPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();
        to = globalVars.getFirstParam(currentMethodName);
        subject = globalVars.getSecondParam(currentMethodName);
        description = globalVars.getThirdParam(currentMethodName);


        isResult=commonEmailPage.emailnegativecases(to,subject,description);
        System.out.println(isResult);


        Utils.logStepInfo(isResult, "Email Negative Cases");
        Assert.isTrue(isResult, "Step-1: User failed to verify Email Negative Cases");
    }

    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
