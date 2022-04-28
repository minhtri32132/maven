package comm.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.server.handler.GetElementSize;
//import org.openqa.selenium.remote.server.handler.GetElementText;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class User_01_Register_Login extends BasePage {
	WebDriver driver;
	//BasePage basePage;
	String emailAddress;
	String projectPath = System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//basePage = getBasePageObject();
		
		emailAddress = "afc" +generateFakeNumber() + "@mail.vn";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	  }
	
  
  public void TC01_Register_Empty_Data() {
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  waitForElementClickable(driver, "//*[@id=\"register-button\"]");
	  clickToElement(driver, "//*[@id=\"register-button\"]");
	  
	  Assert.assertEquals(getElementText(driver, "//*[@id=\"FirstName-error\"]"), "First name is required.");
	  Assert.assertEquals(getElementText(driver, "//*[@id=\"LastName-error\"]"), "Last name is required.");
	  Assert.assertEquals(getElementText(driver, "//*[@id=\"Email-error\"]"), "Email is required.");
	  Assert.assertEquals(getElementText(driver, "//*[@id=\"Password-error\"]"), "Password is required.");
	  Assert.assertEquals(getElementText(driver, "//*[@id=\"ConfirmPassword-error\"]"), "Password is required.");
  }
  
 
  public void TC02_Register_Invalid_Email() {
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  sendkeyToElement(driver, "//*[@id=\"FirstName\"]", "Automation");
	  sendkeyToElement(driver, "//*[@id=\"LastName\"]", "FC");
	  sendkeyToElement(driver, "//*[@id=\"Email\"]", "123@456");
	  sendkeyToElement(driver, "//*[@id=\"Password\"]", "123456");
	  sendkeyToElement(driver, "//*[@id=\"ConfirmPassword\"]", "123456");
	  waitForElementClickable(driver, "//*[@id=\"register-button\"]");
	  clickToElement(driver, "//*[@id=\"register-button\"]");
	  Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"), "Wrong email");
	  
  }
  
  public void TC03_Register_Success() {
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  sendkeyToElement(driver, "//*[@id=\"FirstName\"]", "Automation");
	  sendkeyToElement(driver, "//*[@id=\"LastName\"]", "FC");
	  sendkeyToElement(driver, "//*[@id=\"Email\"]", emailAddress);
	  sendkeyToElement(driver, "//*[@id=\"Password\"]", "123456");
	  sendkeyToElement(driver, "//*[@id=\"ConfirmPassword\"]", "123456");
	  waitForElementClickable(driver, "//*[@id=\"register-button\"]");
	  clickToElement(driver, "//*[@id=\"register-button\"]");
	  
	  Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
	  clickToElement(driver, "//a[@class='button-1 register-continue-button']");
	  
  }
  
  public void TC04_Register_Exist_Email() {
	  waitForElementClickable(driver, "//a[text()='Log out']");
	  clickToElement(driver, "//a[text()='Log out']");
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  sendkeyToElement(driver, "//*[@id=\"FirstName\"]", "Automation");
	  sendkeyToElement(driver, "//*[@id=\"LastName\"]", "FC");
	  sendkeyToElement(driver, "//*[@id=\"Email\"]", emailAddress);
	  sendkeyToElement(driver, "//*[@id=\"Password\"]", "123456");
	  sendkeyToElement(driver, "//*[@id=\"ConfirmPassword\"]", "123456");
	  waitForElementClickable(driver, "//*[@id=\"register-button\"]");
	  clickToElement(driver, "//*[@id=\"register-button\"]");
	  
	Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");
	//  clickToElement(driver, "//a[@class='button-1 register-continue-button']");
	
  }

  public void TC05_Register_Password_Less_Than_6_Characters() {
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  sendkeyToElement(driver, "//*[@id=\"FirstName\"]", "Automation");
	  sendkeyToElement(driver, "//*[@id=\"LastName\"]", "FC");
	  sendkeyToElement(driver, "//*[@id=\"Email\"]", emailAddress);
	  sendkeyToElement(driver, "//*[@id=\"Password\"]", "123");
	  sendkeyToElement(driver, "//*[@id=\"ConfirmPassword\"]", "123");
	  waitForElementClickable(driver, "//*[@id=\"register-button\"]");
	  clickToElement(driver, "//*[@id=\"register-button\"]");
	  Assert.assertEquals(getElementText(driver, "//*[@id=\"Password-error\"]"), "Password must meet the following rules:\nmust have at least 6 characters");
	  
  }
  @Test
  public void TC06_Register_Invalid_Password() {
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  sendkeyToElement(driver, "//*[@id=\"FirstName\"]", "Automation");
	  sendkeyToElement(driver, "//*[@id=\"LastName\"]", "FC");
	  sendkeyToElement(driver, "//*[@id=\"Email\"]", emailAddress );
	  sendkeyToElement(driver, "//*[@id=\"Password\"]", "123456");
	  sendkeyToElement(driver, "//*[@id=\"ConfirmPassword\"]", "12312");
	  waitForElementClickable(driver, "//*[@id=\"register-button\"]");
	  clickToElement(driver, "//*[@id=\"register-button\"]");
	  Assert.assertEquals(getElementText(driver, "//*[@id=\"ConfirmPassword-error\"]"), "The password and confirmation password do not match.");
	  
  }
  public int generateFakeNumber()
  {
	  Random number = new Random();
	  return number.nextInt(10000);
  }

  @AfterClass
  public void afterClass() {
  }

}
