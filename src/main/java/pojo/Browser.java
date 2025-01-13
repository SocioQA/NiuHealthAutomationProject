package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

static WebDriver driver;
public static  String mainWindowHandle;  // Store the main window handle globally
	
	//This method for NIU Health
    public static WebDriver launchBrowserNIUHealth() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();      
        driver= new ChromeDriver();
        // Navigate to the URL
        driver.navigate().to("https://appa.niuhealth.site/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }

    public static WebDriver launchEdgeBrowserNIUHealth() {
        // Setup ChromeDriver using WebDriverManager
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
        // Navigate to the URL
        driver.navigate().to("https://appa.niuhealth.site/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }
    
    public static WebDriver launchFirefoxBrowserNIUHealth() {
        // Setup ChromeDriver using WebDriverManager
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
        // Navigate to the URL
        driver.navigate().to("https://appa.niuhealth.site/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }
	//This method for NIU Health
    public static WebDriver launchBrowserNIUHealthAppV2() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();      
        driver= new ChromeDriver();
        // Navigate to the URL
        driver.navigate().to("https://appav2.niuhealth.com/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }
    public static WebDriver launchEdgeBrowserNIUHealthAppV2() {
        // Setup ChromeDriver using WebDriverManager
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
        // Navigate to the URL
        driver.navigate().to("https://appav2.niuhealth.com/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }
    public static WebDriver launchFireFoxBrowserNIUHealthAppV2() {
        // Setup ChromeDriver using WebDriverManager
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
        // Navigate to the URL
        driver.navigate().to("https://appav2.niuhealth.com/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }
}
