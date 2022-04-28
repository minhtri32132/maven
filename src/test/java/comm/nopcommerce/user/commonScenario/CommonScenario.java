package comm.nopcommerce.user.commonScenario;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageOject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class CommonScenario extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	LoginPageOject loginPageObject;
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject;
	BaseTest baseTest;
	private String firstName = "abc";
	private String lastName = "123";
	private String validEmail = "alpha" + generateFakeNumber() + "@mail.com";
	
	private String password = "123456";
	

	private static  Set<Cookie> cookies;

	public static Set<Cookie> getCookies() {
		return cookies;
	}

	public int generateFakeNumber() {
		Random number = new Random();
		return number.nextInt(10000);
	}

	
	@Parameters({ "envWorkPlace", "browser", "url", "ipAddress", "port" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envWorkPlace, @Optional("chrome") String browserName,
			@Optional("") String url, @Optional("") String ipAddress, @Optional("") String portNumber) {
		driver = getBrowserDriver(browserName, url, envWorkPlace, ipAddress, portNumber);

		homePageObject = PageGeneratorManager.getHomePageObject(driver);
		registerPageObject = homePageObject.clickToRegisterLink();

		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(validEmail);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
		registerPageObject.clickToRegisterButton();
		homePageObject = registerPageObject.clickToLogOutLink();
		loginPageObject = homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextBox(validEmail);
		loginPageObject.inputToPasswordTextbox(password);
		loginPageObject.clickToLoginButton();
		cookies =loginPageObject.getAllCookies(driver);
		homePageObject = registerPageObject.clickToLogOutLink();

		
		driver.quit();

	}


	@AfterClass
	public void afterClass() {
	}


	


}
