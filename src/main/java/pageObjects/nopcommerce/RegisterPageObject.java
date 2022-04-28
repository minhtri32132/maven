package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.RegisterPageUI;


public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageFirstNameTextBox() {
		// TODO Auto-generated method stub
		waitForAllElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageLastNameTextBox() {
		// TODO Auto-generated method stub
		waitForAllElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageEmailTextBox() {
		// TODO Auto-generated method stub
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessagePasswordTextBox() {
		// TODO Auto-generated method stub
		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageConfirmPasswordTextBox() {
		// TODO Auto-generated method stub
		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public String getMainErrorMessage() {
		waitForAllElementVisible(driver, RegisterPageUI.MAIN_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.MAIN_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		// TODO Auto-generated method stub
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String email) {
		// TODO Auto-generated method stub
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		// TODO Auto-generated method stub
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		// TODO Auto-generated method stub
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		// TODO Auto-generated method stub
		waitForAllElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogOutLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.LOG_OUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOG_OUT_BUTTON);
		return new HomePageObject(driver);
	}

	
	/**
	 * Verify data in page register 
	 * @param driver
	 * @param dataValue = data-valmsg-for
	 * @return
	 */
	public String getFieldValidationError(WebDriver driver, String dataValue) {
		waitForElementVisible(driver, RegisterPageUI.VALIDATION_ERROR_BY_DATA_VALUE,dataValue);
		
		return getElementText(driver, RegisterPageUI.VALIDATION_ERROR_BY_DATA_VALUE, dataValue);
	}

}
