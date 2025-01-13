package utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class NewListener extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result)
	{
		System.out.println("Test Start " +result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
        Screenshot.screenshotMethod(driver, result.getMethod().getMethodName());  // Get method name dynamically
		System.out.println("Test is successfully run " +result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
        Screenshot.screenshotMethod(driver, result.getMethod().getMethodName());  // Get method name dynamically
		System.out.println("Test Failed " +result.getName());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test is skipped " +result.getName());
	}
	
}
