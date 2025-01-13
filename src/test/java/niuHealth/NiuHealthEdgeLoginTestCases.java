package niuHealth;

import org.json.simple.parser.ParseException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.NiuHealthLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class NiuHealthEdgeLoginTestCases extends BaseClass{
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReports()
	{
		// Get the current class name
		String className = this.getClass().getSimpleName(); 
		reports= Reports.createReport("C:\\Users\\91738\\eclipse-workspace\\NiuHealth\\src\\test\\resources\\TestReports\\" + className +".html");

	}
	 @BeforeMethod
	   public void launchEdge() {
		   driver = Browser.launchEdgeBrowserNIUHealth();
	   }
	    
	    @Test
	    public void testLoginOnEdgeBrowser() throws ParseException {
	    	NiuHealthLoginPage loginPage = new NiuHealthLoginPage(driver);
	        loginPage.login();
	    }

		@Test
		public void testBlankLogin() throws ParseException {
			NiuHealthLoginPage loginPage = new NiuHealthLoginPage(driver);
			loginPage.blankLogin();
		}

		@Test
		public void testEmailRequiredLogin() throws ParseException {
			NiuHealthLoginPage loginPage = new NiuHealthLoginPage(driver);
			loginPage.emailRequiredLogin();
		}
		@Test
		public void testPasswordRequiredLogin() throws ParseException {
			NiuHealthLoginPage loginPage = new NiuHealthLoginPage(driver);
			loginPage.passwordRequiredLogin();
		}

		@Test
		public void testInvalidEmailLogin() throws ParseException{
			NiuHealthLoginPage loginPage = new NiuHealthLoginPage(driver);
			loginPage.invalidEmaillogin();
		}

	@AfterMethod
	public void publishReports(ITestResult results)
	{
		//	        // Dynamically pass method name to createTest method
		String methodName = results.getMethod().getMethodName();
		test = reports.createTest(methodName);
		String screenshotPath = Screenshot.screenshotMethod(driver, results.getMethod().getMethodName());  // Capture screenshot after each test

		if(results.getStatus()== ITestResult.SUCCESS)
		{
			//test.log(Status.PASS, "<b><i>" +results.getName() +"<b><i>");
			test.log(Status.PASS, "Test Passed: " + methodName);
			test.addScreenCaptureFromPath(screenshotPath);  // Add screenshot for passed test to the report

		}
		else if(results.getStatus()== ITestResult.FAILURE)
		{
			//test.log(Status.FAIL, "<b><i>" +results.getName() +"<b><i>");
			test.log(Status.FAIL, "Test Failed: " + methodName);
			test.addScreenCaptureFromPath(screenshotPath);  // Add screenshot for passed test to the report

		}
		else
		{
			//test.log(Status.SKIP, "<b><i>" +results.getName() +"<b><i>");
			test.log(Status.SKIP, "Test Skipped: " + methodName);
			test.addScreenCaptureFromPath(screenshotPath);  // Add screenshot for passed test to the report

		}
	}

	@AfterTest
	public void createReportAfterTest()
	{
		reports.flush();
	}



}
