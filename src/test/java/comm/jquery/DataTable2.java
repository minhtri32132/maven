package comm.jquery;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.jquery.HomePage;
import pageObjects.jquery.PageGenerator;

import commons.BaseTest;

public class DataTable2 extends BaseTest {
	WebDriver driver;
	HomePage homePage;
	
	@Test
	public void DataTable_01() {
		homePage.inputToTextBoxByColumnAndRow("Artist","1","Super Mario");
		homePage.inputToTextBoxByColumnAndRow("Album","1","Doto");
		homePage.inputToTextBoxByColumnAndRow("Year","1","1997");
	}
	
	public void DataTable_02() {
		
		
	}

	@Parameters({ "envWorkPlace", "browser", "url", "ipAddress", "port" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envWorkPlace, @Optional("chrome") String browserName,
			@Optional("") String url, @Optional("") String ipAddress, @Optional("") String portNumber) {
		driver = getBrowserDriver(browserName, url, envWorkPlace, ipAddress, portNumber);
		homePage = PageGenerator.getHomePage(driver);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver();
	}

}
