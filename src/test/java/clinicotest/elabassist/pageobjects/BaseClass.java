package clinicotest.elabassist.pageobjects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import clinicotest.elabassist.utility.BrowserFactory;
import clinicotest.elabassist.utility.ConfigDataProvider;
import clinicotest.elabassist.utility.ExcelDataProvider;
import clinicotest.elabassist.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		excel= new ExcelDataProvider();
		config= new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/clinico "+Helper.getCurrentTime()+".html"));
	report= new ExtentReports();
	report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup() {
		driver=BrowserFactory.startBrowser(driver, config.getBrowser(), config.GetAppUrl());

	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	
		}
		report.flush();
	}
}
