package configuration_pack_extents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Configuration_base {
	public static WebDriver d;
	public static ExtentHtmlReporter Ehr;
	public static ExtentReports Er;
	public static ExtentTest Et;

	public static void LauncSite() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\selenium project\\Selenium webdriver\\chromedriver_win32 (2)\\chromedriver.exe");

		d = new ChromeDriver();
		d.get("https://www.nopcommerce.com/en");
		d.manage().window().maximize();
		d.manage().deleteAllCookies();

	}

	public static void reportdesign() {

		Ehr = new ExtentHtmlReporter(
				"D:\\Eclipse\\eclipse-workspace\\Learn_Extents_report\\test-output\\myfirstextentreport.html");
		Ehr.config().setDocumentTitle("nop ecommerce report");
		Ehr.config().setReportName("Resister functionality");
		Ehr.config().setTheme(Theme.DARK);
		Er.attachReporter(Ehr);

		Er.setSystemInfo("OS", "Window");
		Er.setSystemInfo("hostname", "10.10.128.51");
		Er.setSystemInfo("Tester Nmse", "Akash");
		Er.setSystemInfo("Browsernaem", "chrome");

	}

}
