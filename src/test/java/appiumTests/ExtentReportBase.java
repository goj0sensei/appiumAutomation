package appiumTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.observer.entity.ReportEntity;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportBase {
	
	ExtentObserver<ReportEntity> extentReporter;
	ExtentReports extentReport;
	
	@BeforeSuite
	public void reportSetup() {
		
		extentReporter = new ExtentSparkReporter("extentReport.html");
		
		//create extent report and attach reporters
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentReporter);
	}
	
	
	@AfterSuite
	public void reportTearDown() {
		//flush will write everything to the log file
		extentReport.flush();
	}
}