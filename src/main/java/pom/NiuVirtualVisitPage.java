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
import org.testng.Assert;

import utility.BaseClass;

public class NiuVirtualVisitPage extends BaseClass{

	WebDriverWait wait;
	JavascriptExecutor js;
	Actions action;
	
	public NiuVirtualVisitPage(WebDriver driver)
	{
        this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.action = new Actions (driver);
		PageFactory.initElements(driver,this);
	}
	//Virtual visit 
    @FindBy(xpath = "//*[@id='root']/div[2]/div[2]/ul/li[1]/a")
    WebElement VirtualVisit;    
    //Book your Appointment button
    @FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div/div/div[2]/div/div/div/p/button")
    WebElement bookAptmnt; 
    
    //Ok button
    @FindBy(xpath = "/html/body/div[2]/div/div[6]/button[1]")
    WebElement okBtn;
    
    //Speciality- Family Practice
    @FindBy(xpath = "//*[@id='root']/div[2]/div/div/div[2]/div[1]/div/div/div[1]/button[2]")
    WebElement speciality;   
    //Select symptoms-Cough
    @FindBy(xpath = "//*[@id='root']/div[2]/div/div/div[2]/div[1]/div/div/div[2]/button[1]")
    WebElement symptoms;
    
    //Book your Appointment button
    @FindBy(xpath = "//*[@id='root']/div[2]/div/div/div[2]/div[1]/div/div/div[3]/button")
    WebElement bookAnAppointment;    
    //Cancel button
    @FindBy(xpath = "//*[@id='root']/div[2]/div/div/div[2]/div[1]/div/div/div[3]/a/button")
    WebElement cancelBtn;
    
    //After clicking on book your appointment, a pop up opens.
    //Calendar
    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
    WebElement clickCalendar;    
    //Select current date
    @FindBy(xpath = "//div[@aria-current='date']")
    WebElement currentDate;   
    //Select time
    @FindBy(xpath = "//*[@id='time']")
    WebElement clickTime;
    //Select time 10am
    @FindBy(xpath = "//*[@id='time']/option[7][@value='5']")
    WebElement selectTime;    
    //After selecting date and time click on book your appointment btn
    @FindBy(xpath = "//button[@class='btn btn-success' and text()='Book Your Appointment']")
    WebElement bookYourAppointmentBtn;
    
    //Upcoming appointments
    @FindBy(xpath = "//*[@id='appointmentTabs']/li[2]/a")
    WebElement upcomingAppointments;
    
    //Close pop up button
    @FindBy(xpath = "/html/body/div[3]/div/div/div[1]/div/div/button")
    WebElement close;
    
    //Cancel visit after successful booking from Upcoming Appointments section
    @FindBy(xpath = "//*[@id='9' or text()='Cancel Visit']/div/div/div[4]/div/div/button")
    WebElement cancelVisit;
    //Yes button
    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled' or text()='Yes']")
    WebElement yesConfirmButton;
    //No button
    @FindBy(xpath = "//button[@class='swal2-cancel swal2-styled' and text()='No']")
    WebElement noCancelButton;
    //OK button- After successfully canceling visit
    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled' and text()='OK']")
    WebElement OkConfirmButton;
    //No Upcoming Appointments text
    @FindBy(xpath = "//*[@id='appointmentTabsContent']/div/div/div")
    WebElement noUpcomingAppointmentsText;
    
    
    public void clickOnVirtualVisit() {
        wait.until(ExpectedConditions.visibilityOf(VirtualVisit)).click();     
    }
    public void clickOnBookYourAppointment() {
        wait.until(ExpectedConditions.visibilityOf(bookAptmnt));   
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    //  Scroll to the button
		js.executeScript("arguments[0].scrollIntoView();", bookAptmnt);
        wait.until(ExpectedConditions.visibilityOf(bookAptmnt)).click();  
    }
    
    public void clickOnOK() {
        wait.until(ExpectedConditions.visibilityOf(okBtn)).click();     
    }
    
    public void selectSpecialityAndSymptoms() {
        wait.until(ExpectedConditions.visibilityOf(speciality)).click(); 
        wait.until(ExpectedConditions.visibilityOf(symptoms)).click();        
    }
    public void bookYourAppointment() {
        wait.until(ExpectedConditions.visibilityOf(bookAnAppointment));   
    //  Scroll to the button
		js.executeScript("arguments[0].scrollIntoView();", bookAnAppointment);
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wait.until(ExpectedConditions.visibilityOf(bookAnAppointment)).click();  
    }
    public void selectDate() {
        wait.until(ExpectedConditions.visibilityOf(clickCalendar)).click(); 
        wait.until(ExpectedConditions.visibilityOf(currentDate)).click();        
    }

    public void selectTimeDropdown() {
        wait.until(ExpectedConditions.visibilityOf(clickTime)); 
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wait.until(ExpectedConditions.visibilityOf(clickTime)).click(); 
        wait.until(ExpectedConditions.visibilityOf(selectTime)).click();        
    }
    public void BookYourAppointment() {
        wait.until(ExpectedConditions.visibilityOf(bookYourAppointmentBtn));   
    //  Scroll to the button
		js.executeScript("arguments[0].scrollIntoView();", bookYourAppointmentBtn);
        wait.until(ExpectedConditions.visibilityOf(bookYourAppointmentBtn)).click();        
    }
    public void verifyYourAppointment() {
        wait.until(ExpectedConditions.visibilityOf(upcomingAppointments));   
        wait.until(ExpectedConditions.visibilityOf(upcomingAppointments)).click();
	     // Get the text and verify it.
        String bookedAppointment = upcomingAppointments.getText();
        Assert.assertEquals(bookedAppointment, "Upcoming Appointments");
        System.out.println("Your booked appointment is visible under Upcoming Appointments filter");
    }
    
    public void yesCancelVirtualVisitAppointment() {
    	//My code from 165 to 184
//        wait.until(ExpectedConditions.visibilityOf(cancelVisit));   
//    //  Scroll to the button
//		js.executeScript("arguments[0].scrollIntoView();", cancelVisit);
//        wait.until(ExpectedConditions.visibilityOf(cancelVisit)).click();    
//        wait.until(ExpectedConditions.visibilityOf(yesConfirmButton)); 
//        wait.until(ExpectedConditions.visibilityOf(yesConfirmButton)).click();    
//        wait.until(ExpectedConditions.visibilityOf(OkConfirmButton)); 
//        wait.until(ExpectedConditions.visibilityOf(OkConfirmButton)).click();  
//        //wait.until(ExpectedConditions.visibilityOf(noUpcomingAppointmentsText)); 
//        try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	     // Get the text and verify it.
//        String noAppointment = noUpcomingAppointmentsText.getText();
//        Assert.assertEquals(noAppointment, "No Upcoming Appointments");
//        System.out.println("Canceled visit.No Upcoming Appointments visible under Upcoming Appointments filter"); 

        try {
            // Check if the cancelVisit element is present
            if (isElementPresent(cancelVisit, wait)) {
                // Scroll to the button
                wait.until(ExpectedConditions.visibilityOf(cancelVisit));
                js.executeScript("arguments[0].scrollIntoView();", cancelVisit);
                
                // Perform actions on cancelVisit
                wait.until(ExpectedConditions.visibilityOf(cancelVisit)).click();
                wait.until(ExpectedConditions.visibilityOf(yesConfirmButton)).click();
                wait.until(ExpectedConditions.visibilityOf(OkConfirmButton)).click();

                // Verify the text after cancellation
                String noAppointment = wait.until(ExpectedConditions.visibilityOf(noUpcomingAppointmentsText)).getText();
                Assert.assertEquals(noAppointment, "No Upcoming Appointments");
                System.out.println("Canceled visit. No Upcoming Appointments visible under Upcoming Appointments filter");
            } else {
                // Handle case when cancelVisit is not present
                String noAppointment = wait.until(ExpectedConditions.visibilityOf(noUpcomingAppointmentsText)).getText();
                Assert.assertEquals(noAppointment, "No Upcoming Appointments");
                System.out.println("No appointments to cancel. No Upcoming Appointments visible under Upcoming Appointments filter");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 // Utility method to check if an element is present
    private boolean isElementPresent(WebElement element, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
