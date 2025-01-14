package pom;

import java.awt.AWTException;
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
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;

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
    @FindBy(xpath = "//*[@type='file' and @id='inFl_0' and @accept='image/*']")
    WebElement fileInput;

    // Locate the 1st Upload button
    @FindBy(xpath = "(//button[contains(text(), 'Upload')])[1]")
    WebElement uploadButton1;
    
    // Locate the 2nd Upload button
    @FindBy(xpath = "(//button[contains(text(), 'Upload')])[2]")
    WebElement uploadButton2;
    
    //Submit Document button
    @FindBy(xpath = "//*[@id='formUpload']/div/div/div/div/div[2]/button[text()='Submit Documents']")
    WebElement submitDocButton;
    
    //Back button
    @FindBy(xpath = "//*[@id='formUpload']/div/div/div/div/div[2]/a/button[text()='Back']")
    WebElement backBtn;

    // Method to click on New Insurance Button
    public void newInsuranceBtn() {
		js.executeScript("arguments[0].scrollIntoView();", newInsuranceButton);
        wait.until(ExpectedConditions.visibilityOf(newInsuranceButton)).click();   
    }
    
    // Method to upload the file using the Robot class
    public void uploadFile1(String filePath) throws AWTException, InterruptedException {
        // Use Robot Class to handle the file manager dialog
        Robot robot = new Robot();

        // Copy the file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Simulate CTRL + V to paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Simulate pressing ENTER to confirm
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("File 1 uploaded successfully!");
    }
    
    // Method to upload the file using the Robot class
    public void uploadFile2(String filePath) throws AWTException, InterruptedException {
        // Use Robot Class to handle the file manager dialog
        Robot robot = new Robot();

        // Copy the file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Simulate CTRL + V to paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Simulate pressing ENTER to confirm
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("File 2 uploaded successfully!");
    }

    // Method to click the 1st upload button
    public void click1stUploadButton() {
        wait.until(ExpectedConditions.visibilityOf(uploadButton1)).click();   
    }
    
    // Method to click the 2nd upload button
    public void click2ndUploadButton() {
        wait.until(ExpectedConditions.visibilityOf(uploadButton2)).click();   
    }
    
    // Method to click submit document button
    public void clickSubmitDocumentButton() {
        wait.until(ExpectedConditions.visibilityOf(submitDocButton)).click();   
    }
    
    // Method to click the back button
    public void clickBackButton() {
        wait.until(ExpectedConditions.visibilityOf(backBtn)).click();   
    }
    
    
}
