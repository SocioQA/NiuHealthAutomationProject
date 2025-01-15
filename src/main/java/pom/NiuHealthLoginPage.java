package pom;

import java.time.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.BaseClass;
import utility.JsonDataReader;

public class NiuHealthLoginPage extends BaseClass{
	WebDriverWait wait;
	WebDriverWait waitForText;
	JavascriptExecutor js;
	Actions action;
	
	public NiuHealthLoginPage(WebDriver driver)
	{
        this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.waitForText = new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js = (JavascriptExecutor) driver;
		this.action = new Actions (driver);
		PageFactory.initElements(driver,this);
	}
	//Email 
    @FindBy(id = "username")
    WebElement Username;

    // Password 
    @FindBy(id = "password")
    WebElement Password;

    // Login button
    @FindBy(xpath = "//*[@id='root']/div/div/div/div/div/div/div/div[1]/form/div[4]/div/button")
    WebElement clickloginButton;
    
    //Email is required
    @FindBy(xpath = "//*[@id='root']/div/div/div/div/div/div/div/div[1]/form/div[1]/label[2]")
    WebElement emailRequiredText;
    
    //Password is required
    @FindBy(xpath = "//*[@id='root']/div/div/div/div/div/div/div/div[1]/form/div[2]/label[2]")
    WebElement passwordRequiredText;
    
    //Invalid Credentials
    @FindBy(xpath = "//*[@id='root']/div/div/div/div/div/div/div/div[1]/form/div[4]")
    WebElement invalidCredentials;
    
	//Verification Pop up
	@FindBy(xpath = "/html/body/div[2]/div/div[6]/button[text()='Start Verification']")
	WebElement startVerificationBtn;
	
	//Logout button on dash board
	@FindBy(xpath = "//*[@id='root']/div[2]/div[2]/div/ul/li/a")
	WebElement logoutBtn;


    public void login() {
    	JsonDataReader jsonDataReader = new JsonDataReader();
        JSONObject jsonObject = null; // Initialize jsonObject to null

        try {
            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            // Extract data from JSON
            String userName = (String) jsonObject.get("NIUemail");
            String PassWord = (String) jsonObject.get("NIUpassword");
            
            wait.until(ExpectedConditions.visibilityOf(Username)).sendKeys(userName);
            wait.until(ExpectedConditions.visibilityOf(Password)).sendKeys(PassWord);      
            clickloginButton.click();

        } else {
            System.out.println("Failed to load JSON data.");
        }
	 
	  }
    
    public void loginWithNewUser() {
    	JsonDataReader jsonDataReader = new JsonDataReader();
        JSONObject jsonObject = null; // Initialize jsonObject to null

        try {
            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            // Extract data from JSON
            String userName = (String) jsonObject.get("niuEmailAccount");
            String PassWord = (String) jsonObject.get("niuPassword");
            
            wait.until(ExpectedConditions.visibilityOf(Username)).sendKeys(userName);
            wait.until(ExpectedConditions.visibilityOf(Password)).sendKeys(PassWord);      
            clickloginButton.click();
            //Click on Verification pop up
            wait.until(ExpectedConditions.visibilityOf(startVerificationBtn)).click(); 

        } else {
            System.out.println("Failed to load JSON data.");
        }
	 
	  }
	  
    public void blankLogin()  {
        wait.until(ExpectedConditions.visibilityOf(clickloginButton)).click();    
        //Verify email text
        wait.until(ExpectedConditions.visibilityOf(emailRequiredText));  
        String emptyEmailMsg = emailRequiredText.getText();
        Assert.assertEquals(emptyEmailMsg, "This field is required");
        System.out.println("User is unable to login with empty email and password fields");
        //Verify password text
        wait.until(ExpectedConditions.visibilityOf(passwordRequiredText));   
        String emptyPasswordMsg = passwordRequiredText.getText();
        Assert.assertEquals(emptyPasswordMsg, "This field is required");
        System.out.println("User is unable to login with empty email and password fields");
}
    public void emailRequiredLogin()  {

    	JsonDataReader jsonDataReader = new JsonDataReader();
        JSONObject jsonObject = null; // Initialize jsonObject to null

        try {
            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            // Extract data from JSON
            String PassWord = (String) jsonObject.get("NIUpassword");    
            wait.until(ExpectedConditions.visibilityOf(Password)).sendKeys(PassWord);      
            wait.until(ExpectedConditions.visibilityOf(clickloginButton)).click();  
            wait.until(ExpectedConditions.visibilityOf(emailRequiredText));  
            String emptyEmailMsg = emailRequiredText.getText();
            Assert.assertEquals(emptyEmailMsg, "This field is required");
            System.out.println("User is unable to login with empty email field");

        } else {
            System.out.println("Failed to load JSON data.");
        }        
        }

    public void passwordRequiredLogin()  {

    	JsonDataReader jsonDataReader = new JsonDataReader();
        JSONObject jsonObject = null; // Initialize jsonObject to null

        try {
            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            // Extract data from JSON
        	String userName = (String) jsonObject.get("NIUemail");
        	wait.until(ExpectedConditions.visibilityOf(Username)).sendKeys(userName);
            wait.until(ExpectedConditions.visibilityOf(clickloginButton)).click();  
            wait.until(ExpectedConditions.visibilityOf(passwordRequiredText));  
            String emptyPasswordMsg = passwordRequiredText.getText();
            Assert.assertEquals(emptyPasswordMsg, "This field is required");
            System.out.println("User is unable to login with empty password field");

        } else {
            System.out.println("Failed to load JSON data.");
        }        
        }
    public void invalidEmaillogin(){
    	JsonDataReader jsonDataReader = new JsonDataReader();
        JSONObject jsonObject = null; // Initialize jsonObject to null

        try {
            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            // Extract data from JSON
            String userName = (String) jsonObject.get("invalidEmailId");
            String PassWord = (String) jsonObject.get("NIUpassword");
            
            wait.until(ExpectedConditions.visibilityOf(Username)).sendKeys(userName);
            wait.until(ExpectedConditions.visibilityOf(Password)).sendKeys(PassWord);      
            wait.until(ExpectedConditions.visibilityOf(clickloginButton)).click();  
            try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            wait.until(ExpectedConditions.visibilityOf(invalidCredentials));  
            String invalidCredentialsMsg = invalidCredentials.getText();
            Assert.assertEquals(invalidCredentialsMsg, "Invalid credentials");
            System.out.println("User is unable to login with Invalid Email Credentials");
        } else {
            System.out.println("Failed to load JSON data.");
        }
	 
	  }
    
    public void logoutMethod() {
    	wait.until(ExpectedConditions.visibilityOf(logoutBtn)).click();
    }

}
