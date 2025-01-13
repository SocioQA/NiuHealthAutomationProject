package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports createReport(String fileName)
	{
		ExtentReports reports= new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
		reports.attachReporter(sparkReporter);
		return reports;
	}

}
