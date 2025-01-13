package pom;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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

public class NiuSubscriptionAndPaymentPage extends BaseClass{
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions action;
	
	public NiuSubscriptionAndPaymentPage(WebDriver driver)
	{
        this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.action = new Actions (driver);
		PageFactory.initElements(driver,this);
	}
	
	//Subscription & Payment
	@FindBy(xpath = "//*[@id='root']/div[2]/div[2]/ul/li[4]/a/span[text()='Subscription & Payment']")
	WebElement subsAndPayment;
	
	//Subscription and Payment Text
	@FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div/div/div[1]/div/div/h4[text()='Subscription and Payment']")
	WebElement subsAndPayText;
	
	
	//If subscription exist then cancel subscription button is present
	@FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div/div/div[2]/div/div/div/div/div/span/button[text()='Cancel Subscription']")
	WebElement cancelSubscriptionBtn;
	//OK button
	@FindBy(xpath = "/html/body/div[2]/div/div[6]/button[text()='OK']")
	WebElement OKButton;
	//Cancel button
	@FindBy(xpath = "/html/body/div[2]/div/div[6]/button[text()='Cancel']")
	WebElement CancelBtn;
	//If canceled, then get End Date
	@FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div/div/div[2]/div/div/div/div/table/tbody/tr[2]/td[text()= 'End Date']")
	WebElement endDateText;
	@FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div/div/div[2]/div/div/div/div/table/tbody/tr[2]/td[text()='12:00 am Feb 08, 2025']")
	WebElement dateText;
	
	//Subscription Plans- 1/6/12 Months Text
	@FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/div/div[1]/label")
	WebElement oneMonthPlan;
	@FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/div/div[2]/label")
	WebElement sixMonthPlan;	
	@FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/div/div[3]/label")
	WebElement twelveMonthPlan;	
	//If no subscription exist then "No Payment History results." text is displayed
	@FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div/div/div[3]/div/div/h5[text()='No Payment History results.']")
	WebElement noPaymentHistory;
	
	//If subscription exist then respected subscribed plan details is displayed in a table
	@FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div/div/div[3]/div/div/div/div/table/tbody/tr/td[1][text()='1 Month' or text()='6 Month' or text()='12 Month']")
	WebElement subscribedPlanDetails;
	
	//Select one month plan
	@FindBy(xpath = "//*[@id='rdoSubsPlan_1']")
	WebElement oneMonthSubscription;	
	//Enter card details
	@FindBy(xpath = "//*[@id='root']/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input")
	WebElement enterCardDetails;	
	//Subscribe now button
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/div/form/button[text()= 'subscribe now']")
	WebElement subscribeNowBtn;
	
	
	
	
    public void clickOnSubscriptionAndPayment() {
        wait.until(ExpectedConditions.visibilityOf(subsAndPayment)).click();     
    }
    
    public void viewOneMonthPlan() {
        wait.until(ExpectedConditions.visibilityOf(oneMonthPlan));
        String oneMonth = oneMonthPlan.getText();
        Assert.assertEquals(oneMonth, "1 Month - $49.99");
        System.out.println("One month plan - " +oneMonth);
    }
    public void viewSixMonthPlan() {
        wait.until(ExpectedConditions.visibilityOf(oneMonthPlan));
		js.executeScript("arguments[0].scrollIntoView();", sixMonthPlan);
        String sixMonth = sixMonthPlan.getText();
        Assert.assertEquals(sixMonth, "6 Months - $299.94");
        System.out.println("Six month plan - " +sixMonth);
    }
    public void viewTwelveMonthPlan() {
        wait.until(ExpectedConditions.visibilityOf(oneMonthPlan));
		js.executeScript("arguments[0].scrollIntoView();", twelveMonthPlan);
        String twelveMonth = twelveMonthPlan.getText();
        Assert.assertEquals(twelveMonth, "12 Months - $599.98");
        System.out.println("Twelve month plan - " +twelveMonth);
    }
    
    public void viewSubscribedPlanDetails() {
        wait.until(ExpectedConditions.visibilityOf(cancelSubscriptionBtn));
		js.executeScript("arguments[0].scrollIntoView();", subscribedPlanDetails);
        String subscriptionName = subscribedPlanDetails.getText();
        Assert.assertEquals(subscriptionName, "1 Month" ,"6 Month");
        System.out.println("Subscription name is - " +subscriptionName);
    }
    
    public void noSubscription() {
        wait.until(ExpectedConditions.visibilityOf(oneMonthPlan));
		js.executeScript("arguments[0].scrollIntoView();", noPaymentHistory);
        String Nosubscription = noPaymentHistory.getText();
        Assert.assertEquals(Nosubscription, "No Payment History results.");
        System.out.println("No Subscription exist - " +Nosubscription);  

    }
    
    public void yesCancelIfSubscriptionExist() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cancelSubscriptionBtn)).click();
            wait.until(ExpectedConditions.visibilityOf(OKButton)).click();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

//		  js.executeScript("arguments[0].scrollIntoView();", subscribedPlanDetails);
//      String subscriptionName = subscribedPlanDetails.getText();
//      Assert.assertEquals(subscriptionName, "1 Month" ,"6 Month");
//      System.out.println("Subscription name is - " +subscriptionName);
      
//      String Nosubscription = noPaymentHistory.getText();
//      Assert.assertEquals(Nosubscription, "No Payment History results.");
//      System.out.println("No Subscription exist - " +Nosubscription);
    }
    public void dontCancelIfSubscriptionExist() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cancelSubscriptionBtn)).click();
            wait.until(ExpectedConditions.visibilityOf(CancelBtn)).click();  
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    public void buySubscription() {
       	JsonDataReader jsonDataReader = new JsonDataReader();
        JSONObject jsonObject = null; // Initialize jsonObject to null

        try {
            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            // Extract data from JSON
            String cardDetails = (String) jsonObject.get("Card_Details");
         
            wait.until(ExpectedConditions.visibilityOf(oneMonthSubscription)).click();
    		js.executeScript("arguments[0].scrollIntoView();", subscribeNowBtn);    		
            //wait.until(ExpectedConditions.visibilityOf(subscribeNowBtn));
            //Enter card details
            //wait.until(ExpectedConditions.visibilityOf(enterCardDetails)).click();
    		try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //wait.until(ExpectedConditions.visibilityOf(enterCardDetails)).sendKeys(cardDetails);
    		action.sendKeys(Keys.TAB).build().perform();
    		action.sendKeys(cardDetails).build().perform();
            wait.until(ExpectedConditions.visibilityOf(subscribeNowBtn)).click();

        } else {
            System.out.println("Failed to load JSON data.");
        }

		
//        String Nosubscription = noPaymentHistory.getText();
//        Assert.assertEquals(Nosubscription, "No Payment History results.");
//        System.out.println("No Subscription exist - " +Nosubscription);  

    }
}
