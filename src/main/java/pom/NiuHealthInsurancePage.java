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

public class NiuHealthInsurancePage extends BaseClass{
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions action;
	
	public NiuHealthInsurancePage(WebDriver driver)
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
    
    //New Insurance button
    @FindBy(xpath = "//*[@id='ctnProffInsDoc']/div[2]/div[2]/a/button[text()='New Insurance' or @class='float-right btn btn-success btn-round waves-effect waves-light mt-2 m-2']")
    WebElement newInsuranceButton;
    
    // Locate the hidden file input field
    @FindBy(xpath = "//*[@type='file' and @id='inFl_0']")
    WebElement fileInput;

    // Locate the Upload button
    @FindBy(xpath = "(//button[contains(text(), 'Upload')])[1]")
    WebElement uploadButton1;

    // Method to click on New Insurance Button
    public void newInsuranceBtn() {
		js.executeScript("arguments[0].scrollIntoView();", newInsuranceButton);
        wait.until(ExpectedConditions.visibilityOf(newInsuranceButton)).click();   
    }
    
    // Method to upload a file
    public void uploadFile(String filePath) {
        fileInput.sendKeys(filePath); // Send the file path to the hidden input
    }

    // Method to click the upload button
    public void clickUploadButton() {
        uploadButton1.click();
    }
}
