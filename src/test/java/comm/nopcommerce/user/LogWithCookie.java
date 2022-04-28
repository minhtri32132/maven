package comm.nopcommerce.user;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import comm.nopcommerce.user.commonScenario.CommonScenario;
import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageOject;
import pageObjects.nopcommerce.MyAccountOject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class LogWithCookie extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	LoginPageOject loginPageObject;
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject;
	BaseTest baseTest;
	String firstName = "abc";
	String lastName = "123";
	String validEmail = "alpha" + generateFakeNumber() + "@mail.com";
	String invalidEmail = "alpha" + generateFakeNumber();
	String incorrectEmail = "alpha" + generateFakeNumber() + "@mail.com";
	String password = "123456";
	String confPassword = "123456";
	

	public int generateFakeNumber() {
		Random number = new Random();
		return number.nextInt(10000);
	}

	@Test
	public void User_02_Search() {
		loginPageObject= homePageObject.clickToLoginLink();
		Set<Cookie> cookies = CommonScenario.getCookies();
		loginPageObject.setCookies(cookies, driver);
		homePageObject.refreshCurrentPage(driver);

	}

	@Parameters({ "envWorkPlace", "browser", "url", "ipAddress", "port" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envWorkPlace, @Optional("chrome") String browserName,
			@Optional("") String url, @Optional("") String ipAddress, @Optional("") String portNumber) {
		driver = getBrowserDriver(browserName, url, envWorkPlace, ipAddress, portNumber);
		homePageObject = PageGeneratorManager.getHomePageObject(driver);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver();
	}

}
