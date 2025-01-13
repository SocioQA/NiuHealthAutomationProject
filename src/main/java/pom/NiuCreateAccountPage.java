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
import utility.BaseClass;
import utility.JsonDataReader;

public class NiuCreateAccountPage extends BaseClass{
	WebDriverWait wait;
	WebDriverWait waitForText;
	JavascriptExecutor js;
	Actions action;
	
	public NiuCreateAccountPage(WebDriver driver)
	{
        this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.waitForText = new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js = (JavascriptExecutor) driver;
		this.action = new Actions (driver);
		PageFactory.initElements(driver,this);
	}
	
	//Create Account Button
	@FindBy(xpath = "//*[@id='root']/div/div/div/div/div/div/div/div[2]/p/a")
	WebElement createAnAccount;
	
    // First Name field
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstName;

    // Last Name field
    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastName;
    
    // Email id field
    @FindBy(xpath = "//input[@id='useremail']")
    WebElement userEmail;    
 
    // Password field
    @FindBy(xpath = "//input[@id='userpassword']")
    WebElement userPassword; 

    // Confirm Password field
    @FindBy(xpath = "//input[@id='conf_password']")
    WebElement confirmPassword; 
    
   //Toggle
    @FindBy(xpath = "//*[@id='root']/div/div/div/div/div/div/div/div[1]/form/div[6]/div/div/label")
    WebElement toggleButton;
    
    //Register
    @FindBy(xpath = "//*[@id='root']/div/div/div/div/div/div/div/div[1]/form/div[7]/div/button")
    WebElement registerButton; 
    
	//Verification Pop up
	@FindBy (xpath = "/html/body/div[2]/div/div[6]/button[text()='Start Verification']")
	WebElement startVerificationBtn;
	
	//Email already taken toast
	@FindBy (xpath = "/html/body/div/div/div/div/div/div/div/div/div[3]/div/div/div[1]/div[text()='The email has already been taken.']")
	WebElement emailTakenMsg;
    
    public void createAccount() {
    	JsonDataReader jsonDataReader = new JsonDataReader();
        JSONObject jsonObject = null; // Initialize jsonObject to null

        try {
            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            // Extract data from JSON
            String FirstName = (String) jsonObject.get("first_Name");
            String LastName = (String) jsonObject.get("last_Name");
            String email = (String) jsonObject.get("newEmail");
            String password = (String) jsonObject.get("niuPassword");
            String ConfirmPassword = (String) jsonObject.get("niuConfirmPassword");


            //Click on Create An Account button
            wait.until(ExpectedConditions.visibilityOf(createAnAccount)).click();
            //Enter first name
            wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(FirstName);
            //Enter last name
            wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(LastName);      
            //Enter email
            wait.until(ExpectedConditions.visibilityOf(userEmail)).sendKeys(email);  
            //Enter password
            wait.until(ExpectedConditions.visibilityOf(userPassword)).sendKeys(password);  
            //Confirm password
            wait.until(ExpectedConditions.visibilityOf(confirmPassword)).sendKeys(ConfirmPassword); 
            //Click on Toggle button
            wait.until(ExpectedConditions.visibilityOf(toggleButton)).click();
            //Click on Register button
            wait.until(ExpectedConditions.visibilityOf(registerButton)).click();  
            //Click on Verification pop up
            wait.until(ExpectedConditions.visibilityOf(startVerificationBtn)).click();     
                       
        } else {
            System.out.println("Failed to load JSON data.");
        }
	 
	  }
    
    public void emailTakenAccount() {
    	
    }

}
