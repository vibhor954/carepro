import base.TestBase;
import generic_pages.CommonArticlesPage;
import generic_pages.CommonLoginPage;
import generic_pages.CommonTestReportPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;


public class ArticlesTest {

    CommonLoginPage commonLoginPage;
    CommonArticlesPage commonArticlesPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
    public void addarticle() throws InterruptedException, IOException {
        boolean isResult = false;
        String title="";
        String description="";
        String artist="";

        String currentMethodName = "addarticle";
        commonLoginPage=CommonLoginPage.getInstance();
        commonArticlesPage=CommonArticlesPage.getInstance();
        title = globalVars.getFirstParam(currentMethodName);
        description = globalVars.getSecondParam(currentMethodName);
        artist = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonArticlesPage.addarticle(title,description,artist);


        Utils.logStepInfo(isResult, "Add Article");
        Assert.isTrue(isResult, "Step-1: User failed to Add Article!");
        Thread.sleep(2000);

    }

    @Test()
    public void updatearticle() throws InterruptedException, IOException {
        boolean isResult = false;
        String title="";
        String description="";
        String artist="";
        String updated="";

        String currentMethodName = "updatearticle";
        commonLoginPage=CommonLoginPage.getInstance();
        commonArticlesPage=CommonArticlesPage.getInstance();
        title = globalVars.getFirstParam(currentMethodName);
        description = globalVars.getSecondParam(currentMethodName);
        artist = globalVars.getThirdParam(currentMethodName);
        updated = globalVars.getFourthParam(currentMethodName);

        //commonLoginPage.login();
        isResult= commonArticlesPage.updatearticle(title,description,artist,updated);


        Utils.logStepInfo(isResult, "Update Article");
        Assert.isTrue(isResult, "Step-1: User failed to Update Article!");
        Thread.sleep(2000);

    }

    @Test()
    public void selectarticleasfavorite_unfavorite() throws InterruptedException, IOException {
        boolean isResult = false;
        String title="";
        String description="";
        String artist="";

        String currentMethodName = "selectarticleasfavorite_unfavorite";
        commonLoginPage=CommonLoginPage.getInstance();
        commonArticlesPage=CommonArticlesPage.getInstance();
        title = globalVars.getFirstParam(currentMethodName);
        description = globalVars.getSecondParam(currentMethodName);
        artist = globalVars.getThirdParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonArticlesPage.selectarticleasfavorite(title,description,artist);


        Utils.logStepInfo(isResult, "Select Article as Favorite and Un favorite ");
        Assert.isTrue(isResult, "Step-1: User failed to Select Article as Favorite and Un favorite!");
        Thread.sleep(2000);

    }




    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
