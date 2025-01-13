package pom;

import java.time.Duration;
import java.util.List;

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

public class NiuMyAppointmentsPage extends BaseClass{
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions action;
	
	public NiuMyAppointmentsPage(WebDriver driver)
	{
        this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.action = new Actions (driver);
		PageFactory.initElements(driver,this);
	}
	
	//My Appointments section
	@FindBy(xpath = "//*[@id='root']/div[2]/div[2]/ul/li[2]/a/span")
	WebElement MyAppointments;
	
    //Upcoming appointments
    @FindBy(xpath = "//*[@id='appointmentTabs']/li[2]/a[text()='Upcoming Appointments']")
    WebElement upcomingAppointments; 
    //Scheduled appointments list
    @FindBy(xpath = "//*[@id='9']/div/div/div[2]/div[1]/div/span[text()= 'Scheduled']")
    List<WebElement> scheduledLists;
    
    //Past appointments
    @FindBy(xpath = "//*[@id='appointmentTabs' ]/li[1]/a[text()='Past Appointments']")
    WebElement pastAppointments;
    //Cancelled appointments list
    @FindBy(xpath = "//*[@id='9']/div/div/div[2]/div[1]/div/span")
    List<WebElement> cancelledLists;
	
    public void clickOnMyAppointments() {
        wait.until(ExpectedConditions.visibilityOf(MyAppointments)).click();     
    }
    
    public void upcomingAppointmentsSection() {
        wait.until(ExpectedConditions.visibilityOf(upcomingAppointments));   
        wait.until(ExpectedConditions.visibilityOf(upcomingAppointments)).click();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (!scheduledLists.isEmpty()) { // Check if the list has any elements
            for (WebElement item : scheduledLists) { 
                String status = item.getText();
                System.out.println(status); // Print the text of each item
            }
            System.out.println("Your scheduled appointments are visible under Upcoming Appointments filter");
        } else {
            System.out.println("No Upcoming Appointments");
        }
    }

    public void pastAppointmentsSection() {
        wait.until(ExpectedConditions.visibilityOf(pastAppointments));   
        wait.until(ExpectedConditions.visibilityOf(pastAppointments)).click();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
        if (!cancelledLists.isEmpty()) { // Check if the list has any elements
            for (WebElement item : cancelledLists) {
                String status = item.getText();
                System.out.println(status);
            }
            System.out.println("Your cancelled appointment is visible under Past Appointments filter");
        } else {
            System.out.println("No Past Appointments");
        }
    }
}
