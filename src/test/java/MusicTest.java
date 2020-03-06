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

    @Test()
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




    @AfterTest
    public void closeDriver(ITestContext context) {
        TestBase.tearDownSuite(context);
    }

}
