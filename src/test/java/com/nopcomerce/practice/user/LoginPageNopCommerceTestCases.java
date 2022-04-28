package com.nopcomerce.practice.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comm.data.nopcommerce.RegisterData;
import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageOject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class LoginPageNopCommerceTestCases extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageOject loginPage;
	RegisterNopCommerceTestCases registerTestCases;
	RegisterPageObject registerPage;
	@Test
	public void Login_TC01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login With Empty Data");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Login Page");
		loginPage = homePage.clickToLoginLink();
		loginPage= PageGeneratorManager.getLoginPageOject(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Login Button");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
		
	}
	@Test
	public void Login_TC02_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login With Empty Data");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Login Page");
		loginPage = homePage.clickToLoginLink();
		loginPage= PageGeneratorManager.getLoginPageOject(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to Email Textbox with value: "+ RegisterData.firstName);
		loginPage.inputToEmailTextBox(RegisterData.firstName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to Password Textbox with value: "+ RegisterData.password);
		loginPage.inputToPasswordTextbox(RegisterData.password);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Login Button");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
		
	}
	@Test
	public void Login_TC03_Login_With_Non_Exist_Customer(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login With Non Exist Customer");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Login Page");
		loginPage = homePage.clickToLoginLink();
		loginPage= PageGeneratorManager.getLoginPageOject(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to Email Textbox with value: "+ RegisterData.email);
		loginPage.inputToEmailTextBox(RegisterData.email);
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to Password Textbox with value: "+ RegisterData.password);
		loginPage.inputToPasswordTextbox(RegisterData.password);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Login Button");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorValidation(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
	}
	@Test
	public void Login_TC04_Login_Without_Password(Method method) {
		
		registerPage = loginPage.clickToRegisterLink();
		Register_TC03_Success(method);
		  homePage = registerPage.clickToLogOutLink();
		  homePage.clickToLoginLink();
		ExtentTestManager.startTest(method.getName(), "Login Without Password");
		
		loginPage= PageGeneratorManager.getLoginPageOject(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input to Email Textbox with value: "+ RegisterData.email);
		loginPage.inputToEmailTextBox(RegisterData.email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Login Button");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorValidation(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	@Test
	public void Login_TC05_Login_With_Wrong_Password(Method method) {
		
		
		ExtentTestManager.startTest(method.getName(), "Login Without Password");
		
		loginPage= PageGeneratorManager.getLoginPageOject(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input to Email Textbox with value: "+ RegisterData.email);
		loginPage.inputToEmailTextBox(RegisterData.email);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to Password Textbox with value: "+ RegisterData.email);
		loginPage.inputToPasswordTextbox(RegisterData.email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click To Login Button");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorValidation(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
  @Test
  public void Login_TC06_Login_Success(Method method) {
	  
	 
	  ExtentTestManager.startTest(method.getName(), "Login Success");
	 // registerTestCases.Register_TC03_Success(method);
	  
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Login Page");
	  loginPage = homePage.clickToLoginLink();
	  loginPage= PageGeneratorManager.getLoginPageOject(driver);
	  ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to Email Textbox with value: "+ RegisterData.email);
	  loginPage.inputToEmailTextBox(RegisterData.email);
	  ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to Password Textbox with value: "+ RegisterData.password);
	  loginPage.inputToPasswordTextbox(RegisterData.password);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click To Login Button");
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(homePage.getPageUrl(driver),"https://demo.nopcommerce.com/");
	  
  }
  
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
