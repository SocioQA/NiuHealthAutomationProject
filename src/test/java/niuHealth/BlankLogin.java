package niuHealth;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NiuHealthLoginPage;
import utility.BaseClass;

public class BlankLogin extends BaseClass{

	 @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserNIUHealth();
	   }
	    
	    @Test
	    public void testLogin() throws ParseException {
	    	NiuHealthLoginPage loginPage = new NiuHealthLoginPage(driver);
	        loginPage.blankLogin();
	    }

}
