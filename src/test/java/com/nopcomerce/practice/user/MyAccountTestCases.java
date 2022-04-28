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

import comm.data.nopcommerce.MyAccountTestData;
import comm.data.nopcommerce.RegisterData;
import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageOject;
import pageObjects.nopcommerce.MyAccountObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class MyAccountTestCases extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageOject loginPage;
	MyAccountObject myAccountPage;

	@Test
	public void My_Account_TC01_Update_Custom_Info(Method method) {
		ExtentTestManager.startTest(method.getName(), "Update Custom Info");
		Pre_CondiTion(method);
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click To My Account Page");
		myAccountPage = loginPage.clickToMyAccountLink(driver);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 02: Input To TextBox Last Name With Value: " + MyAccountTestData.firstName);
		myAccountPage.inputIntoTextBoxById(driver, "FirstName", MyAccountTestData.firstName);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 03: Input To TextBox Last Name With Value: " + MyAccountTestData.lastName);
		myAccountPage.inputIntoTextBoxById(driver, "LastName", MyAccountTestData.lastName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click To Gender By Value: " + MyAccountTestData.gender);
		myAccountPage.clickToRadioButtonById(driver, "gender-male");
		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Select DOB: " + MyAccountTestData.date + "/"
				+ MyAccountTestData.month + "/" + MyAccountTestData.year);
		myAccountPage.selectDropDownByNameandValue(driver, "DateOfBirthDay", MyAccountTestData.date);
		myAccountPage.selectDropDownByNameandValue(driver, "DateOfBirthMonth", MyAccountTestData.month);
		myAccountPage.selectDropDownByNameandValue(driver, "DateOfBirthYear", MyAccountTestData.year);

		ExtentTestManager.getTest().log(Status.INFO, "Verify Data Input Is Correct");
		Assert.assertEquals(myAccountPage.verifyTextboxValue(driver, "FirstName", "value"),
				MyAccountTestData.firstName);
		Assert.assertEquals(myAccountPage.verifyTextboxValue(driver, "LastName", "value"), MyAccountTestData.lastName);
		Assert.assertEquals(myAccountPage.verifyRadioValue(driver, "gender-male", "value"), "M");
		Assert.assertEquals(myAccountPage.verifyDropdownValue(driver, "DateOfBirthDay", "value"),
				MyAccountTestData.date);
		Assert.assertEquals(myAccountPage.verifyDropdownValue(driver, "DateOfBirthMonth", "value"),
				MyAccountTestData.month);
		Assert.assertEquals(myAccountPage.verifyDropdownValue(driver, "DateOfBirthYear", "value"),
				MyAccountTestData.year);

	}

	@Test
	public void My_Account_TC02_Add_Address_Info(Method method) {
		ExtentTestManager.startTest(method.getName(), "Update Custom Info");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click To Address");
		myAccountPage.clickToListBoxMyAccountPage(driver, "customer-addresses inactive");
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click To Button New Address");
		myAccountPage.clickToAddNewAddress(driver, "button-1 add-address-button");
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to FirstName With Value: "+MyAccountTestData.firstName );
		myAccountPage.inputIntoTextBoxById(driver, "Address_FirstName", MyAccountTestData.firstName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input to LastName With Value: "+MyAccountTestData.lastName );
		myAccountPage.inputIntoTextBoxById(driver, "Address_LastName", MyAccountTestData.lastName);
		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input to Email With Value: "+MyAccountTestData.email );
		myAccountPage.inputIntoTextBoxById(driver, "Address_Email", MyAccountTestData.email);
		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Select Country With Value : "+MyAccountTestData.country );
		myAccountPage.selectDropDownByNameandValue(driver, "Address.CountryId", MyAccountTestData.country);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Input to City With Value: "+MyAccountTestData.city );
		myAccountPage.inputIntoTextBoxById(driver, "Address_City", MyAccountTestData.city);
		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Input to Address With Value: "+MyAccountTestData.address );
		myAccountPage.inputIntoTextBoxById(driver, "Address_Address1", MyAccountTestData.address);
		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Input to ZipCode With Value: "+MyAccountTestData.zipCode );
		myAccountPage.inputIntoTextBoxById(driver, "Address_ZipPostalCode", MyAccountTestData.zipCode);
		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Input to PhoneNumber With Value: "+MyAccountTestData.phoneNumber );
		myAccountPage.inputIntoTextBoxById(driver, "Address_PhoneNumber", MyAccountTestData.phoneNumber);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Select State With Value : "+MyAccountTestData.state );
		myAccountPage.selectDropDownByNameandValue(driver, "Address.StateProvinceId", MyAccountTestData.state);
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Data Input Is Correct");
		Assert.assertEquals(myAccountPage.verifyTextboxValue(driver, "Address_FirstName", "value"),
				MyAccountTestData.firstName);
		Assert.assertEquals(myAccountPage.verifyTextboxValue(driver, "Address_LastName", "value"),
				MyAccountTestData.lastName);
		Assert.assertEquals(myAccountPage.verifyTextboxValue(driver, "Address_Email", "value"),
				MyAccountTestData.email);
		
		Assert.assertEquals(myAccountPage.verifyDropdownValue(driver, "Address.CountryId", "value"),
				MyAccountTestData.country);
		Assert.assertEquals(myAccountPage.verifyDropdownValue(driver, "Address.StateProvinceId", "value"),
				MyAccountTestData.state);
		
		Assert.assertEquals(myAccountPage.verifyTextboxValue(driver, "Address_Address1", "value"),
				MyAccountTestData.address);
		Assert.assertEquals(myAccountPage.verifyTextboxValue(driver, "Address_ZipPostalCode", "value"),
				MyAccountTestData.zipCode);
		Assert.assertEquals(myAccountPage.verifyTextboxValue(driver, "Address_PhoneNumber", "value"),
				MyAccountTestData.phoneNumber);
		
		myAccountPage.clickToAddNewAddress(driver, "button-1 save-address-button");
	}
	@Test
	public void My_Account_TC03_Change_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Update Custom Info");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click To Address");
		myAccountPage.clickToListBoxMyAccountPage(driver, "change-password inactive");
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Change Password");
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input Old Password With Value :"+ RegisterData.password);
		myAccountPage.inputIntoTextBoxById(driver, "OldPassword", RegisterData.password);
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input New Password With Value :"+ MyAccountTestData.password);
		myAccountPage.inputIntoTextBoxById(driver, "NewPassword", MyAccountTestData.password);
		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input Conf Password With Value :"+ MyAccountTestData.password);
		myAccountPage.inputIntoTextBoxById(driver, "ConfirmNewPassword", MyAccountTestData.password);
		myAccountPage.clickToAddNewAddress(driver, "button-1 change-password-button");
		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify Pass word Changed ");
		Assert.assertEquals(myAccountPage.verifyPasswordChanged(driver), "Password was changed");
		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Login With Email"+ RegisterData.email+ "New Password :"+ MyAccountTestData.password);
		myAccountPage.clickToCloseBarNotification(driver);
		myAccountPage.clickToLogOutLink(driver);
		loginPage= myAccountPage.clickToLoginLink(driver);
		loginPage.inputToEmailTextBox(RegisterData.email);
		loginPage.inputToPasswordTextbox(MyAccountTestData.password);
		loginPage.clickToLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify Able To Login ");
		Assert.assertEquals(homePage.getPageUrl(driver), "https://demo.nopcommerce.com/");
	}
	public void Pre_CondiTion(Method method) {

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Register Page");

		registerPage = homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Step 02: Input Into First Name Textbox with value " + RegisterData.firstName);
		registerPage.inputToFirstNameTextbox(RegisterData.firstName);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 03: Input Into Last Name Textbox with value " + RegisterData.lastName);
		registerPage.inputToLastNameTextbox(RegisterData.lastName);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 04: Input Into Email Textbox with value" + RegisterData.email);
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
		homePage = registerPage.clickToLogOutLink();
		loginPage = homePage.clickToLoginLink();

		loginPage = PageGeneratorManager.getLoginPageOject(driver);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 02: Input to Email Textbox with value: " + RegisterData.email);
		loginPage.inputToEmailTextBox(RegisterData.email);
		ExtentTestManager.getTest().log(Status.INFO,
				"Step 03: Input to Password Textbox with value: " + RegisterData.password);
		loginPage.inputToPasswordTextbox(RegisterData.password);

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click To Login Button");
		loginPage.clickToLoginButton();
		Assert.assertEquals(homePage.getPageUrl(driver), "https://demo.nopcommerce.com/");
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
		 closeBrowserAndDriver();
	}

}
