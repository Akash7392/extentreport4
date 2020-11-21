package testNG_extents_report;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentest {

	public ExtentHtmlReporter extenthtmlreporter;
	public ExtentReports extenteeports;
	public ExtentTest extenttest;

	@BeforeClass
	public void beforeclasstest() {

		extenthtmlreporter = new ExtentHtmlReporter(
				"C:\\Users\\Akash\\git\\extentreport4\\Learn_Extents_report\\ExtentReport\\myfirstextentreport.html");
		extenteeports = new ExtentReports();
	//	ExtentTest = new ExtentTest();
		extenteeports.attachReporter(extenthtmlreporter);
		extenthtmlreporter.config().setDocumentTitle("nop ecommerce report");
		extenthtmlreporter.config().setReportName("Resister functionality");
		extenthtmlreporter.config().setTheme(Theme.DARK);
		

		extenteeports.setSystemInfo("OS", "Window");
		extenteeports.setSystemInfo("hostname", "10.10.128.51");
		extenteeports.setSystemInfo("Tester Nmse", "Akash");
		extenteeports.setSystemInfo("Browsernaem", "chrome");
		
		
		extenttest = extenteeports.createTest(getClass().getSimpleName());

	}

	@BeforeMethod

	public void beforemethodcheck()

	{
		extenttest.log(Status.INFO, "This is under before mtd");

	}

	@Test
	public void logintest() {
		extenttest.log(Status.INFO, "logintest test started");

	}

	@Test
	public void logouttest() {
		extenttest.log(Status.INFO, "logouttest test started");

	}

	@AfterMethod

	public void Aftermethodcheck(ITestResult r)

	{
		extenttest.log(Status.INFO, "This is under before mtd");
		if (r.getStatus() == ITestResult.SUCCESS) {
			extenttest.log(Status.PASS, "Test case is passed" + r.getName());

		}

		else if (r.getStatus() == ITestResult.SKIP) {
			extenttest.log(Status.SKIP, "Test case is skiped" + r.getName());

		}

		else if (r.getStatus() == ITestResult.FAILURE) {

			extenttest.log(Status.FAIL, "Test case is failed" + r.getName());
			extenttest.log(Status.FAIL, "Test case is failed" + r.getThrowable());
		}

	}

	@AfterClass

	public void toerasereport() {
		extenteeports.flush();

	}

}
