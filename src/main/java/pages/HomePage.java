package pages;

import generic_pages.CommonHomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;


public class HomePage extends CommonHomePage
{
    private AppiumDriver driver;
    static CommonFunctions commonFunctions=null;
    private static HomePage homePage;




    public HomePage() {
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctions.getInstance();
    }
    public static HomePage getHomePageInstance(){
        if(homePage==null){
            homePage=new HomePage();
        }
        return homePage;
    }
    
    


    @Override
	public void homepageactivities() {
    	

		
	}
	
}


