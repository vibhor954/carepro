import base.TestBase;
import generic_pages.CommonArticlesPage;
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


public class MusicTest {

    CommonLoginPage commonLoginPage;
    CommonMusicPage commonMusicPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test(priority = 1)
    public void addmusic() throws InterruptedException, IOException {
        boolean isResult = false;
        String title="";
        String description="";
        String artist="";
        String type="";

        String currentMethodName = "addmusic";
        commonLoginPage=CommonLoginPage.getInstance();
        commonMusicPage=CommonMusicPage.getInstance();
        title = globalVars.getFirstParam(currentMethodName);
        description = globalVars.getSecondParam(currentMethodName);
        type = globalVars.getThirdParam(currentMethodName);
        artist = globalVars.getFourthParam(currentMethodName);

        commonLoginPage.login();
        isResult= commonMusicPage.addmusic(title,description,type,artist);


        Utils.logStepInfo(isResult, "Add Music");
        Assert.isTrue(isResult, "Step-1: User failed to Add Music!");
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void updatemusic() throws InterruptedException, IOException {
        boolean isResult = false;
        String title="";
        String description="";
        String artist="";
        String type="";
        String update="";

        String currentMethodName = "updatemusic";
        commonLoginPage=CommonLoginPage.getInstance();
        commonMusicPage=CommonMusicPage.getInstance();
        title = globalVars.getFirstParam(currentMethodName);
        description = globalVars.getSecondParam(currentMethodName);
        type = globalVars.getThirdParam(currentMethodName);
        artist = globalVars.getFourthParam(currentMethodName);
        update = globalVars.getFifthParam(currentMethodName);

        //commonLoginPage.login();
        isResult= commonMusicPage.updatemusic(title,description,type,artist,update);


        Utils.logStepInfo(isResult, "Update Music");
        Assert.isTrue(isResult, "Step-1: User failed to Update Music!");
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    public void play_pause() throws InterruptedException, IOException {
        boolean isResult = false;

        String currentMethodName = "play_pause";
        commonLoginPage=CommonLoginPage.getInstance();
        commonMusicPage=CommonMusicPage.getInstance();

        //commonLoginPage.login();
        isResult= commonMusicPage.play_pause();


        Utils.logStepInfo(isResult, "Play n Pause Music");
        Assert.isTrue(isResult, "Step-1: User failed to Play n Pause Music!");
        Thread.sleep(2000);

    }

    @Test(priority = 4)
    public void selectmusicasfavorite_unfavorite() throws InterruptedException, IOException {
        boolean isResult = false;
        String title="";
        String description="";
        String artist="";
        String type="";

        String currentMethodName = "selectmusicasfavorite_unfavorite";
        commonLoginPage=CommonLoginPage.getInstance();
        commonMusicPage=CommonMusicPage.getInstance();
        title = globalVars.getFirstParam(currentMethodName);
        description = globalVars.getSecondParam(currentMethodName);
        type = globalVars.getThirdParam(currentMethodName);
        artist = globalVars.getFourthParam(currentMethodName);

        //commonLoginPage.login();
        isResult= commonMusicPage.selectmusicasfavorite_unfavorite(title,description,type,artist);


        Utils.logStepInfo(isResult, "Select Music as Favorite and Un favorite");
        Assert.isTrue(isResult, "Step-1: User failed to Select Music as Favorite and Un favorite!");
    }

    @Test(priority = 5)
    public void getinfo_download() throws InterruptedException, IOException {
        boolean isResult = false;
        String title="";
        String description="";
        String artist="";
        String type="";

        String currentMethodName = "getinfo_download";
        commonLoginPage=CommonLoginPage.getInstance();
        commonMusicPage=CommonMusicPage.getInstance();
        title = globalVars.getFirstParam(currentMethodName);
        description = globalVars.getSecondParam(currentMethodName);
        type = globalVars.getThirdParam(currentMethodName);
        artist = globalVars.getFourthParam(currentMethodName);

        //commonLoginPage.login();
        isResult= commonMusicPage.getinfo_download(title,description,type,artist);


        Utils.logStepInfo(isResult, "Get Info");
        Assert.isTrue(isResult, "Step-1: User failed to Verify Get Info!");

    }




    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
