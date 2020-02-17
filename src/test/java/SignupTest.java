import generic_pages.CommonSignupPage;
import generic_pages.CommonHomePage;
import generic_pages.CommonLoginPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import base.TestBase;
import utils.*;

public class SignupTest {
    CommonLoginPage commonLoginPage;
    CommonHomePage commonHomePage;
    CommonSignupPage commonSignupPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
       globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    /**
     * @throws InterruptedException 
     * @summary:
     * Pre-requisite: The application should be launched and navigated to home page
     * Step-1: Go to login page, enter the user name and password and click login button
     * 		   Verify that the user has successfully logged in.
     */
    @Test
    public void signup_1() throws InterruptedException {

       
    }
    
    @Test
    public void signup_2() throws InterruptedException {

    }
    

    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }

}
