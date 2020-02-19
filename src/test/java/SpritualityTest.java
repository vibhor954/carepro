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

    @Test()
    public void spritualitymeditation() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "spritualitymeditation";
        commonSpritualityPage = CommonSpritualityPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        commonLoginPage.login();
        isResult= commonSpritualityPage.spritualitymeditation();


        Utils.logStepInfo(isResult, "Sprituality Meditation");
        Assert.isTrue(isResult, "Step-1: User failed to access sprituality-->meditation!");
        Thread.sleep(2000);

    }

    @Test()
    public void spritualityvideos() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "spritualityvideos";
        commonSpritualityPage = CommonSpritualityPage.getInstance();
        commonLoginPage=CommonLoginPage.getInstance();

        isResult= commonSpritualityPage.spritualityspritualvideos();


        Utils.logStepInfo(isResult, "Sprituality Videos");
        Assert.isTrue(isResult, "Step-1: User failed to access sprituality-->videos!");
        Thread.sleep(2000);

    }



    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
