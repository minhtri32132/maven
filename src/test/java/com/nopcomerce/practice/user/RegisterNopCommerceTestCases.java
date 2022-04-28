package com.nopcomerce.practice.user;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comm.data.nopcommerce.RegisterData;
import comm.nopcommerce.user.PageGenerator;
import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import reportConfig.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class RegisterNopCommerceTestCases extends BaseTest {
	private WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;

	@Test
	public void Register_TC01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register With Empty Data");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Register Page");
		registerPage = homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Register Button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify First Name Is Required");
		Assert.assertEquals(registerPage.getFieldValidationError(driver, "FirstName"), "First name is required.");
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify Last Name Is Required");
		Assert.assertEquals(registerPage.getFieldValidationError(driver, "LastName"), "Last name is required.");
		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify Email Is Required");
		Assert.assertEquals(registerPage.getFieldValidationError(driver, "Email"), "Email is required.");
		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Password Is Required");
		Assert.assertEquals(registerPage.getFieldValidationError(driver, "Password"), "Password is required.");
		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Confirm Password Is Required");
		Assert.assertEquals(registerPage.getFieldValidationError(driver, "ConfirmPassword"), "Password is required.");
	}

	@Test
	public void Register_TC02_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register With Invalid");
		registerPage.refreshCurrentPage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Register Page");
		
		registerPage = homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 02: Input Into First Name Textbox with value " + RegisterData.firstName);
		registerPage.inputToFirstNameTextbox(RegisterData.firstName);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 03: Input Into Last Name Textbox with value " + RegisterData.lastName);
		registerPage.inputToLastNameTextbox(RegisterData.lastName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input Into Email Textbox with value " + RegisterData.firstName +RegisterData.lastName);
		registerPage.inputToEmailTextbox(RegisterData.firstName +RegisterData.lastName);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 05: Input Into Password Textbox with value " + RegisterData.password);
		registerPage.inputToPasswordTextbox(RegisterData.password);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 06: Input Into Confirm Password Textbox with value " + RegisterData.password);
		registerPage.inputToConfirmPasswordTextbox(RegisterData.password);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Register Button");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getFieldValidationError(driver, "Email"), "Wrong email");
		
	}
	@Test
	public void Register_TC03_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register With Valid Data and Able to Register");
		registerPage.refreshCurrentPage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Register Page");
		
		registerPage = homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 02: Input Into First Name Textbox with value " + RegisterData.firstName);
		registerPage.inputToFirstNameTextbox(RegisterData.firstName);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 03: Input Into Last Name Textbox with value " + RegisterData.lastName);
		registerPage.inputToLastNameTextbox(RegisterData.lastName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input Into Email Textbox with value" +RegisterData.email);
		registerPage.inputToEmailTextbox(RegisterData.email);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 05: Input Into Password Textbox with value " + RegisterData.password);
		registerPage.inputToPasswordTextbox(RegisterData.password);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 06: Input Into Confirm Password Textbox with value " + RegisterData.password);
		registerPage.inputToConfirmPasswordTextbox(RegisterData.password);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Register Button");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
	}
	@Test
	public void Register_TC04_Regist_With_Exist_Mail(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register With Existing Email");
		registerPage.clickToLogOutLink();
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Register Page");
		
		registerPage = homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 02: Input Into First Name Textbox with value " + RegisterData.firstName);
		registerPage.inputToFirstNameTextbox(RegisterData.firstName);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 03: Input Into Last Name Textbox with value " + RegisterData.lastName);
		registerPage.inputToLastNameTextbox(RegisterData.lastName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input Into Email Textbox with value" +RegisterData.email);
		registerPage.inputToEmailTextbox(RegisterData.email);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 05: Input Into Password Textbox with value " + RegisterData.password);
		registerPage.inputToPasswordTextbox(RegisterData.password);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 06: Input Into Confirm Password Textbox with value " + RegisterData.password);
		registerPage.inputToConfirmPasswordTextbox(RegisterData.password);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Register Button");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getMainErrorMessage(), "The specified email already exists");
		
	}
	@Test
	public void Register_TC05_Regist_Password_Less_Than_6_Characters(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register With Less Than 6 Characters");
		registerPage.refreshCurrentPage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Register Page");
		
		registerPage = homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 02: Input Into First Name Textbox with value " + RegisterData.firstName);
		registerPage.inputToFirstNameTextbox(RegisterData.firstName);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 03: Input Into Last Name Textbox with value " + RegisterData.lastName);
		registerPage.inputToLastNameTextbox(RegisterData.lastName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input Into Email Textbox with value" +RegisterData.firstName);
		registerPage.inputToEmailTextbox(RegisterData.email);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 05: Input Into Password Textbox with value " + RegisterData.lastName);
		registerPage.inputToPasswordTextbox(RegisterData.lastName);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 06: Input Into Confirm Password Textbox with value " + RegisterData.lastName);
		registerPage.inputToConfirmPasswordTextbox(RegisterData.lastName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Register Button");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getFieldValidationError(driver, "Password"), "Password must meet the following rules:\nmust have at least 6 characters");
		
	}
	@Test
	public void Register_TC06_Password_Is_Not_Matching(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register With Password Is Not Matching");
		registerPage.refreshCurrentPage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Register Page");

		registerPage = homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Step 02: Input Into First Name Textbox with value " + RegisterData.firstName);
		registerPage.inputToFirstNameTextbox(RegisterData.firstName);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 03: Input Into Last Name Textbox with value " + RegisterData.lastName);
		registerPage.inputToLastNameTextbox(RegisterData.lastName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input Into Email Textbox with value " +RegisterData.firstName);
		registerPage.inputToEmailTextbox(RegisterData.email);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 05: Input Into Password Textbox with value " + RegisterData.password);
		registerPage.inputToPasswordTextbox(RegisterData.password);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 06: Input Into Confirm Password Textbox with value " + RegisterData.lastName);
		registerPage.inputToConfirmPasswordTextbox(RegisterData.lastName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Register Button");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getFieldValidationError(driver, "ConfirmPassword"), "The password and confirmation password do not match.");

	}

	@Parameters({ "envWorkPlace", "browser", "url", "ipAddress", "port" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envWorkPlace, @Optional("chrome") String browserName,
			@Optional("") String url, @Optional("") String ipAddress, @Optional("") String portNumber) {
		driver = getBrowserDriver(browserName, url, envWorkPlace, ipAddress, portNumber);
		homePage = PageGeneratorManager.getHomePageObject(driver);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver();
	}

}
