package comm.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageOject;
import pageObjects.nopcommerce.RegisterPageObject;

public class PageObject_II {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir"); 
	LoginPageOject loginPageObject;
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject;
	String firstName= "abc";
	String lastName= "123";
	String validEmail= "alpha" +generateFakeNumber() +"@mail.com";
	String invalidEmail= "alpha" +generateFakeNumber() ;
	String incorrectEmail= "alpha" +generateFakeNumber() +"@mail.com";
	String password= "123456";
	String confPassword= "123456";
	public int generateFakeNumber()
	  {
		  Random number = new Random();
		  return number.nextInt(10000);
	  }
  @Test
  public void Login_01_Empty_Data() {
	  homePageObject.clickToLoginLink();
	  loginPageObject= new LoginPageOject(driver);
	  loginPageObject.clickToLoginButton();
	  Assert.assertEquals(loginPageObject.getEmailErrorMessage(), "Please enter your email");
	  
  }
  @Test
  public void Login_02_Invalid_Email() {
	  homePageObject.clickToLoginLink();
	  loginPageObject.inputToEmailTextBox(invalidEmail);
	  loginPageObject.inputToPasswordTextbox(password);
	  loginPageObject.clickToLoginButton();
	  Assert.assertEquals(loginPageObject.getEmailErrorMessage(), "Wrong email");
	  
  }
  @Test
  public void Login_03_Incorrect_Email() {
	  homePageObject.clickToLoginLink();
	  loginPageObject.inputToEmailTextBox(incorrectEmail);
	  loginPageObject.inputToPasswordTextbox(password);
	  loginPageObject.clickToLoginButton();
	  Assert.assertEquals(loginPageObject.getErrorValidation(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	  
  }
  @Test
  public void Login_04_Valid_Email_Without_Password() {
	  homePageObject.clickToLoginLink();
	  loginPageObject.inputToEmailTextBox(validEmail);
	  //loginPageObject.inputToPasswordTextbox(password);
	  loginPageObject.clickToLoginButton();
	  Assert.assertEquals(loginPageObject.getErrorValidation(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
  }
  @Test
  public void Login_05_Valid_Email_With_Wrong_Password() {
	  homePageObject.clickToLoginLink();
	  loginPageObject.inputToEmailTextBox(validEmail);
	  loginPageObject.inputToPasswordTextbox("6666661");
	  loginPageObject.clickToLoginButton();
	  Assert.assertEquals(loginPageObject.getErrorValidation(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
  }
  @Test
  public void Login_06_Valid_Email() {
	  homePageObject.clickToLoginLink();
	  loginPageObject.inputToEmailTextBox(validEmail);
	  loginPageObject.inputToPasswordTextbox(password);
	  loginPageObject.clickToLoginButton();
	 // Assert.assertEquals(loginPageObject.getErrorValidation(), "Login was unsuccessful. Plase correct the errors and try again.");
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath +"\\browserDrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  homePageObject = new HomePageObject(driver);
	  
	  homePageObject.clickToRegisterLink();

	  registerPageObject = new RegisterPageObject(driver);
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(validEmail);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
		registerPageObject.clickToRegisterButton();
		registerPageObject.clickToLogOutLink();

  }

  @AfterClass
  public void afterClass() {
  }

}
