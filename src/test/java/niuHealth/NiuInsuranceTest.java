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

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;

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
	    public void testProfile() throws ParseException, AWTException, InterruptedException {
	    	NiuHealthLoginPage loginPage = new NiuHealthLoginPage(driver);
	    	NiuHealthProfilePage profilePage = new NiuHealthProfilePage(driver);
	    	NiuHealthInsurancePage insurance = new NiuHealthInsurancePage(driver);
	    	
	        // Upload the file
	        String filePath1 = "C:\\Users\\91738\\a.png";
	        // Upload the file
	        String filePath2 = "C:\\Users\\91738\\b.png";
	        
	        //Login
	        loginPage.loginWithNewUser();
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //Go to profile and click on new insurance button
	        insurance.newInsuranceBtn();
	        
	        //Click on 1st upload button
	        insurance.click1stUploadButton();
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        insurance.uploadFile1(filePath1);
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        insurance.click2ndUploadButton();	        
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //Upload 2nd image/file
	        insurance.uploadFile2(filePath2);
	    }

}
