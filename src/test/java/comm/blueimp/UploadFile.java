package comm.blueimp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.blueimp.HomePage;
import pageObjects.blueimp.PageGenerators;
import pageObjects.nopcommerce.PageGeneratorManager;

public class UploadFile extends BaseTest {
	@Test
	public void Upload_TC_01() {
    homePage.uploadMultipleFiles(driver, fileCapture1,fileCapture2,fileCapture3);
    homePage.clicktoStartButton();
	}

	@Parameters({ "envWorkPlace", "browser", "url", "ipAddress", "port" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envWorkPlace, @Optional("chrome") String browserName,
			@Optional("") String url, @Optional("") String ipAddress, @Optional("") String portNumber) {
		driver = getBrowserDriver(browserName, url, envWorkPlace, ipAddress, portNumber);
		homePage = PageGenerators.getHomePage(driver);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver();
	}
HomePage homePage;
WebDriver driver;
String projectPath = System.getProperty("usr.dir");
String fileCapture1 ="Capture_1.PNG";
String fileCapture2 ="Capture_2.PNG";
String fileCapture3 ="Capture_3.PNG";
}
