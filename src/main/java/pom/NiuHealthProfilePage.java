package pom;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseClass;

public class NiuHealthProfilePage extends BaseClass{
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions action;
	
	public NiuHealthProfilePage(WebDriver driver)
	{
        this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.action = new Actions (driver);
		PageFactory.initElements(driver,this);
	}
	//Profile 
    @FindBy(xpath = "/html/body/div/div[2]/div[2]/ul/li[5]/a")
    WebElement Profile;
    
    //Contact Number
    @FindBy(xpath = "//*[@id='contactNum']")
    WebElement contactNumber;
    
    //Address line 1
    @FindBy(xpath = "//*[@id='elAddr1' and @name='Address1']")
    WebElement addressLine1;

    //Address line 2
    @FindBy(xpath = "//*[@id='elAddr2' and @name='Address2']")
    WebElement addressLine2;

    //City
    @FindBy(xpath = "//*[@id='elCity' and @name='City']")
    WebElement city;
    
    //Zipcode
    @FindBy(xpath = "//*[@id='elZip' and @name='ZIPCode']")
    WebElement zipcode;
    
        
    public void clickOnProfile() {
        wait.until(ExpectedConditions.visibilityOf(Profile)).click();     
    }
    
    public void enterContactNumber() {
       // wait.until(ExpectedConditions.visibilityOf(contactNumber));
        wait.until(ExpectedConditions.visibilityOf(contactNumber));
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //contactNumber.clear();
       wait.until(ExpectedConditions.visibilityOf(contactNumber)).sendKeys("2858254352");     

    }
}
