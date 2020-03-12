import base.TestBase;
import generic_pages.CommonCameraPage;
import generic_pages.CommonLoginPage;
import generic_pages.CommonMusicPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;


public class CameraTest {

    CommonLoginPage commonLoginPage;
    CommonCameraPage commonCameraPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test(priority = 2)
    public void picsave_full() throws InterruptedException, IOException {
        boolean isResult = false;


        String currentMethodName = "picsave_full";
        commonLoginPage=CommonLoginPage.getInstance();
        commonCameraPage=CommonCameraPage.getInstance();

       // commonLoginPage.login();
        isResult= commonCameraPage.savepic_fullsize();


        Utils.logStepInfo(isResult, "Click and Save Pic");
        Assert.isTrue(isResult, "Step-1: User failed to Click and Save Pic!");
        Thread.sleep(2000);

    }

    @Test(priority = 1)
    public void picsave_crop() throws InterruptedException, IOException {
        boolean isResult = false;


        String currentMethodName = "picsave_crop";
        commonLoginPage=CommonLoginPage.getInstance();
        commonCameraPage=CommonCameraPage.getInstance();

        commonLoginPage.login();
        isResult= commonCameraPage.savepic_cropped();


        Utils.logStepInfo(isResult, "Click and Save Pic");
        Assert.isTrue(isResult, "Step-1: User failed to Click and Save Pic!");
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
