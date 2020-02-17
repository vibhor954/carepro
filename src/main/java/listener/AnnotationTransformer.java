package listener;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import utils.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class AnnotationTransformer extends Data implements IAnnotationTransformer {
	static DataReader oDataReader = null;
	private static boolean isDataInitialized;
	static GlobalVars globalVars;

	private static void initializeExecutionData(){
		try {
			if(!isDataInitialized){
				globalVars=GlobalVars.getInstance();
				oDataReader= DataReader.getInstance();
				oDataReader.setupDataSheet();
				isDataInitialized=true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		initializeExecutionData();
		if(DataReader.getTestCaseMapping().containsKey(testMethod.getName())){
			if(DataReader.getTestCaseMapping().get(testMethod.getName()).getRunStatus().equalsIgnoreCase(Constants.SKIP)){
				annotation.setEnabled(false);
			}
			else {
				globalVars.setTestCaseListRunModeTrue(testMethod.getName());
			}
		}
		annotation.setRetryAnalyzer(Retry.class);

	}
	
}