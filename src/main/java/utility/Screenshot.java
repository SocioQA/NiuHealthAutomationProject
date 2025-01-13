package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static String screenshotMethod(WebDriver driver, String fileName)
	{
		LocalDateTime dateTime= LocalDateTime.now();
		DateTimeFormatter time= DateTimeFormatter.ofPattern("DD-MM-YY HH_MM_SS");
		String dt= dateTime.format(time);
		
		File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationFile= new File("C:\\Users\\91738\\eclipse-workspace\\Spotsaver\\src\\test\\resources\\TestScreenshots\\" +fileName +"-" +dt +".png");
		try {
			FileHandler.copy(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
            System.out.println("Failed to capture screenshot: " + e.getMessage());
		}
		return destinationFile.getAbsolutePath();			
	}
}
