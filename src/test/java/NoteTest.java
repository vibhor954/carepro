import base.TestBase;
import generic_pages.CommonLoginPage;
import generic_pages.CommonNotePage;
import generic_pages.CommonVitalSignsPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;


public class NoteTest {

    CommonLoginPage commonLoginPage;
    CommonVitalSignsPage commonVitalSignsPage;
    CommonNotePage commonNotesPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
    public void addnote() throws InterruptedException, IOException {
        boolean isResult = false;
        String from="";
        String description="";

        String currentMethodName = "addnote";
        commonLoginPage=CommonLoginPage.getInstance();
        commonNotesPage=CommonNotePage.getInstance();
        from = globalVars.getFirstParam(currentMethodName);
        description = globalVars.getSecondParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonNotesPage.addnote(from,description);


        Utils.logStepInfo(isResult, "Verify Add Note");
        Assert.isTrue(isResult, "Step-1: User failed to Add Note!");
        Thread.sleep(2000);

    }

    @Test()
    public void updatenote() throws InterruptedException, IOException {
        boolean isResult = false;
        String from="";
        String description="";
        String updated="";

        String currentMethodName = "updatenote";
        commonLoginPage=CommonLoginPage.getInstance();
        commonNotesPage=CommonNotePage.getInstance();
        from = globalVars.getFirstParam(currentMethodName);
        description = globalVars.getSecondParam(currentMethodName);
        updated = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonNotesPage.updatenote(from,description,updated);


        Utils.logStepInfo(isResult, "Verify Update Note");
        Assert.isTrue(isResult, "Step-1: User failed to Update Note!");
        Thread.sleep(2000);

    }

    @Test()
    public void verifysearch_note() throws InterruptedException, IOException {
        boolean isResult = false;
        String from="";
        String description="";
        String updated="";

        String currentMethodName = "verifysearch_note";
        commonLoginPage=CommonLoginPage.getInstance();
        commonNotesPage=CommonNotePage.getInstance();
        from = globalVars.getFirstParam(currentMethodName);
        description = globalVars.getSecondParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonNotesPage.verifysearch(from,description);


        Utils.logStepInfo(isResult, "Verify Search");
        Assert.isTrue(isResult, "Step-1: User failed to Search!");
        Thread.sleep(2000);

    }



    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
