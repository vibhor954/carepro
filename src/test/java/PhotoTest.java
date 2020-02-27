import base.TestBase;
import generic_pages.CommonLoginPage;
import generic_pages.CommonNotePage;
import generic_pages.CommonPhotoPage;
import generic_pages.CommonVitalSignsPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;


public class PhotoTest {

    CommonLoginPage commonLoginPage;
    CommonPhotoPage commonPhotoPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test()
    public void addphotofromgallery_cropimage() throws InterruptedException, IOException {
        boolean isResult = false;
        String folder="";

        String currentMethodName = "addphotofromgallery_cropimage";
        commonLoginPage=CommonLoginPage.getInstance();
        commonPhotoPage=CommonPhotoPage.getInstance();
        folder = globalVars.getFirstParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonPhotoPage.addphotofromgallery_crop(folder);


        Utils.logStepInfo(isResult, "Verify Add Photo From Gallery");
        Assert.isTrue(isResult, "Step-1: User failed to Add Photo from Gallery!");
        Thread.sleep(2000);

    }

    @Test()
    public void addphotofromgallery_fullimage() throws InterruptedException, IOException {
        boolean isResult = false;
        String folder="";

        String currentMethodName = "addphotofromgallery_fullimage";
        commonLoginPage=CommonLoginPage.getInstance();
        commonPhotoPage=CommonPhotoPage.getInstance();
        folder = globalVars.getFirstParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonPhotoPage.addphotofromgallery_full(folder);


        Utils.logStepInfo(isResult, "Verify Add Photo From Gallery");
        Assert.isTrue(isResult, "Step-1: User failed to Add Photo from Gallery!");
        Thread.sleep(2000);

    }

    @Test()
    public void addphotofromcamera_crop() throws InterruptedException, IOException {
        boolean isResult = false;
        String folder="";

        String currentMethodName = "addphotofromcamera_crop";
        commonLoginPage=CommonLoginPage.getInstance();
        commonPhotoPage=CommonPhotoPage.getInstance();
        folder = globalVars.getFirstParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonPhotoPage.addphotofromcamera_crop();


        Utils.logStepInfo(isResult, "Verify Add Photo From Camera With Cropped Image");
        Assert.isTrue(isResult, "Step-1: User failed to Add Photo from Camera With Cropped Image!");
        Thread.sleep(2000);

    }

    @Test()
    public void addphotofromcamera_full() throws InterruptedException, IOException {
        boolean isResult = false;
        String folder="";

        String currentMethodName = "addphotofromcamera_full";
        commonLoginPage=CommonLoginPage.getInstance();
        commonPhotoPage=CommonPhotoPage.getInstance();
        folder = globalVars.getFirstParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonPhotoPage.addphotofromcamera_full();


        Utils.logStepInfo(isResult, "Verify Add Photo From Camera With Full Image");
        Assert.isTrue(isResult, "Step-1: User failed to Add Photo from Camera With Full Image!");
        Thread.sleep(2000);

    }

    @Test()
    public void verifyslidephoto() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "verifyslidephoto";
        commonLoginPage=CommonLoginPage.getInstance();
        commonPhotoPage=CommonPhotoPage.getInstance();
        commonLoginPage.login();
        isResult= commonPhotoPage.slidephoto();


        Utils.logStepInfo(isResult, "Verify Slide Photo");
        Assert.isTrue(isResult, "Step-1: User failed to Verify Slide Photo!");
        Thread.sleep(2000);

    }

    @Test()
    public void choosefavoritephoto() throws InterruptedException, IOException {
        boolean isResult = false;
        String folder="";

        String currentMethodName = "choosefavoritephoto";
        folder = globalVars.getFirstParam(currentMethodName);
        commonLoginPage=CommonLoginPage.getInstance();
        commonPhotoPage=CommonPhotoPage.getInstance();
        commonLoginPage.login();
        Thread.sleep(1000);
        isResult= commonPhotoPage.choosefavoritephoto(folder);


        Utils.logStepInfo(isResult, "Choose favorite Photo");
        Assert.isTrue(isResult, "Step-1: User failed to choose Photo!");
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
