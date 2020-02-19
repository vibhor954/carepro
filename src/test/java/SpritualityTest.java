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


public class SpritualityTest {

    CommonLoginPage commonLoginPage;
    CommonHomePage commonHomePage;
    CommonSignupPage commonSignupPage;
    CommonEmailPage commonEmailPage;
    CommonSpritualityPage commonSpritualityPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test(priority = 1)
    public void spritualitymeditation() throws InterruptedException, IOException {
        boolean isResult = false;
        String to = "";
        String subject = "";
        String description = "";
        String verification_text="";
        String currentMethodName = "spritualitymeditation";
        commonSpritualityPage = CommonSpritualityPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        commonLoginPage.login();
        isResult= commonSpritualityPage.spritualitymeditation();


        Utils.logStepInfo(isResult, "Sprituality Meditation");
        Assert.isTrue(isResult, "Step-1: User failed to access sprituality-->meditation!");
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
