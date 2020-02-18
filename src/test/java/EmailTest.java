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

    @Test(priority = 1)
    public void sendemail() throws InterruptedException, IOException {
        boolean isResult = false;
        String to = "";
        String subject = "";
        String description = "";
        String verification_text="";
        String currentMethodName = "sendemail";
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
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void recieveemail() throws InterruptedException, IOException {
        boolean isResult = false;

        String verification_text="";
        String currentMethodName = "recieveemail";
        commonEmailPage = CommonEmailPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        verification_text = globalVars.getFirstParam(currentMethodName);
        //commonLoginPage.login();
        isResult=commonEmailPage.verifymailreceived(verification_text);
        System.out.println(isResult);


        Utils.logStepInfo(isResult, "Recieve Email");
        Assert.isTrue(isResult, "Step-1: User failed to Recieve email!");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void deleteemailsfrominbox() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "deleteemailsfrominbox";
        commonEmailPage = CommonEmailPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        isResult=commonEmailPage.deleteinboxemails();
        System.out.println(isResult);


        Utils.logStepInfo(isResult, "Delete Emails from Inbox");
        Assert.isTrue(isResult, "Step-1: User failed to delete email from Inbox!");
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void deleteemailsfromsent() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "deleteemailsfrominbox";
        commonEmailPage = CommonEmailPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        isResult=commonEmailPage.deleteinboxemails();
        System.out.println(isResult);


        Utils.logStepInfo(isResult, "Delete Emails from Inbox");
        Assert.isTrue(isResult, "Step-1: User failed to delete email from Inbox!");
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteemailsfromtrash() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "deleteemailsfromtrash";
        commonEmailPage = CommonEmailPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        isResult=commonEmailPage.deletetrashemails();
        System.out.println(isResult);


        Utils.logStepInfo(isResult, "Delete Emails from Trash");
        Assert.isTrue(isResult, "Step-1: User failed to delete email from Trash!");
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
