package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.HomePageUI;
import pageUIs.nopcommerce.LoginPageUI;
import pageUIs.nopcommerce.MyAccountUI;
import pageUIs.nopcommerce.RegisterPageUI;

public class LoginPageOject extends BasePage {
	WebDriver driver;

	public LoginPageOject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new HomePageObject(driver);

	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_IN_TEXTBOX);
		clickToElement(driver, HomePageUI.REGISTER_IN_TEXTBOX);
		return new RegisterPageObject(driver);

	}

	public String getEmailErrorMessage() {
		// TODO Auto-generated method stub
		return getElementText(driver, LoginPageUI.EMAIL_TEXTBOX_ERROR);
	}

	public void inputToEmailTextBox(String invalidEmail) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);

	}

	public void inputToPasswordTextbox(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public String getErrorValidation() {
		// TODO Auto-generated method stub
		return getElementText(driver, LoginPageUI.ERROR_VALIDATION);
	}

	public MyAccountObject clickToMyAccountLink(WebDriver driver) {
		waitForAllElementVisible(driver, MyAccountUI.MY_ACCOUNT_LINK);
		clickToElement(driver, MyAccountUI.MY_ACCOUNT_LINK);
		return new MyAccountObject(driver);
	}
}
