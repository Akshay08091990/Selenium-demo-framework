package com.ak.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ak.utils.PropertyReader;
import com.ak.utils.WebDriverFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	public static WebDriver driver;
	public WebDriverWait wait;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeSuite
	public void setup() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = extent.startTest("ExtentDemo");
		Properties config = PropertyReader.readPropertiesFile("/testconfig.properties");
		String browser = config.getProperty("browser");
		/*
		 * browser value can be passed via paramters through testng.xml or you
		 * can the value from command line via maven
		 */
		if (browser.equals("chrome")) {
			driver = WebDriverFactory.getDriver("chrome");
		} else {
			driver = WebDriverFactory.getDriver("firefox");

		}

		String dir = System.getProperty("user.dir");
		driver.get("file:" + dir + "/src/main/resources/test-site/index.html");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws IOException {

		driver.close();
		driver.quit();

	}

}
