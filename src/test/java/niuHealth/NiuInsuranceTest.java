package niuHealth;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.NiuHealthInsurancePage;
import pom.NiuHealthLoginPage;
import pom.NiuHealthProfilePage;
import utility.BaseClass;
import utility.Reports;

public class NiuInsuranceTest extends BaseClass{
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
	   public void launchChrome() {
		   driver = Browser.launchBrowserNIUHealth();
	   }
	    
	    @Test
	    public void testProfile() throws ParseException {
	    	NiuHealthLoginPage loginPage = new NiuHealthLoginPage(driver);
	    	NiuHealthProfilePage profilePage = new NiuHealthProfilePage(driver);
	    	NiuHealthInsurancePage insurance = new NiuHealthInsurancePage(driver);

	        loginPage.loginWithNewUser();
	        //profilePage.clickOnProfile();
	    }

}
