package reporters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
	
	private static ExtentReports extent;
	public static String extentpath;
	 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            timeStamp="ExtentReport_"+timeStamp;
            ExtentHtmlReporter html = new ExtentHtmlReporter(getCanonicalPath()+File.separator+"ExtentReports"+File.separator+ timeStamp + ".html");
            extent = new ExtentReports();
            extent.attachReporter(html);
        }
        return extent;
    }

    public static String getCanonicalPath(){
        String path="";
        try{
            File baseDirectory = new File(".");
            path = baseDirectory.getCanonicalPath();
        }
        catch (IOException ex){ex.printStackTrace();}
        return path;
    }
}
