package comm.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.RegisterPageObject;

public class PageObject {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject;
	String firstName= "abc";
	String lastName= "123";
	String email= "alpha" +generateFakeNumber() +"@mail.com";
	String password= "123456";
	String confPassword= "123456";
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePageObject = new HomePageObject(driver);
		registerPageObject = new RegisterPageObject(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC01_Register_Empty_Data() {
		homePageObject.clickToRegisterLink();
		registerPageObject.clickToRegisterButton();

		Assert.assertEquals(registerPageObject.getErrorMessageFirstNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPageObject.getErrorMessagePasswordTextBox(), "Password is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageConfirmPasswordTextBox(), "Password is required.");

	}

	@Test
	public void TC02_Register_Invalid() {
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(firstName);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
		registerPageObject.clickToRegisterButton();

		Assert.assertEquals(registerPageObject.getErrorMessageEmailTextBox(), "Wrong email");

	}

	@Test
	public void TC03_Register_Valid() {
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
		registerPageObject.clickToRegisterButton();

		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		registerPageObject.clickToLogOutLink();

	}

	@Test
	public void TC04_Register_Existing_Email() {
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
		registerPageObject.clickToRegisterButton();

		Assert.assertEquals(registerPageObject.getMainErrorMessage(), "The specified email already exists");

	}

	@Test
	public void TC05_Register_Password_Less_Than_6_Characters() {
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox("123");
		registerPageObject.inputToConfirmPasswordTextbox(password);
		registerPageObject.clickToRegisterButton();

		Assert.assertEquals(registerPageObject.getErrorMessagePasswordTextBox(),"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC06_Register_Invalid_Password() {
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox("654321");
		registerPageObject.clickToRegisterButton();

		Assert.assertEquals(registerPageObject.getErrorMessageConfirmPasswordTextBox(),
				"The password and confirmation password do not match.");

	}

	  public int generateFakeNumber()
	  {
		  Random number = new Random();
		  return number.nextInt(10000);
	  }
	@BeforeTest
	public void beforeTest() {
	}

}
