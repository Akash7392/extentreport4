package testNG_extents_report;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import configuration_pack_extents.Configuration_base;

public class Extents_report extends Configuration_base {

	@BeforeTest
	public void BasicReportDesign() {
		Configuration_base.reportdesign();
	}

	@BeforeMethod
	public void websitelaunch() throws InterruptedException {
		Configuration_base.LauncSite();
		Thread.sleep(2000);
	}

	@Test
	public void checklogo() {
		Et = Er.createTest("checklogo");

		System.out.println(" logo is not  displayed");
		boolean b = d.findElement(By.xpath("//img[@alt='nopCommerce']")).isDisplayed();
		if (b) {
			System.out.println("logo is displayed");
		}

		else {
			System.out.println("logo is not  displayed");
		}

	}

	@AfterMethod

	public void teardown(ITestResult r) {

		if (r.getStatus() == ITestResult.SUCCESS) {
			Et.log(Status.PASS, "Test case is passed" + r.getName());

		}

		else if (r.getStatus() == ITestResult.SKIP) {
			Et.log(Status.SKIP, "Test case is skiped" + r.getName());

		}

		else if (r.getStatus() == ITestResult.FAILURE) {

			Et.log(Status.FAIL, "Test case is failed" + r.getName());
			Et.log(Status.FAIL, "Test case is failed" + r.getThrowable());
		}

		d.quit();

	}

	@AfterTest

	public void toerasereport() {
		Er.flush();

	}

}