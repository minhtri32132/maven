package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.MyAccountUI;

public class MyAccountObject extends BasePage {
	WebDriver driver;

	public MyAccountObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public void inputIntoTextBoxById(WebDriver driver, String dynamicValue,String inputValue) {
		waitForElementVisible(driver, MyAccountUI.TEXTBOX_BY_ID, dynamicValue);
		sendkeyToElement(driver, MyAccountUI.TEXTBOX_BY_ID, inputValue, dynamicValue);		
	}

	public void clickToRadioButtonById(WebDriver driver,String gender) {
		waitForElementVisible(driver, MyAccountUI.RADIO_BUTTON_BY_ID, gender);
		clickToElement(driver, MyAccountUI.RADIO_BUTTON_BY_ID, gender);
		
	}

	public void selectDropDownByNameandValue(WebDriver driver, String dynamicValue,String inputValue) {
		waitForElementVisible(driver, MyAccountUI.DROPDOWN_BY_NAME, dynamicValue);
		selectItemInDefaultDropdownByValue(driver, MyAccountUI.DROPDOWN_BY_NAME, inputValue, dynamicValue);
	}

	public String verifyTextboxValue(WebDriver driver, String dynamicValue,String inputValue) {
		waitForElementVisible(driver, MyAccountUI.TEXTBOX_BY_ID, dynamicValue);
		return getElementAttribute(driver, MyAccountUI.TEXTBOX_BY_ID, inputValue, dynamicValue);
	}
	public String verifyRadioValue(WebDriver driver, String dynamicValue,String inputValue) {
		waitForElementVisible(driver, MyAccountUI.RADIO_BUTTON_BY_ID, dynamicValue);
		return getElementAttribute(driver, MyAccountUI.RADIO_BUTTON_BY_ID, inputValue, dynamicValue);
	}

	public String verifyDropdownValue(WebDriver driver, String dynamicValue,String inputValue) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountUI.DROPDOWN_BY_NAME, dynamicValue);
		return getElementAttribute(driver, MyAccountUI.DROPDOWN_BY_NAME, inputValue, dynamicValue);
	}
	public void clickToListBoxMyAccountPage(WebDriver driver,String dynamicValue) {
		waitForElementClickable(driver, MyAccountUI.MY_ACCOUNT_LIST_BOX, dynamicValue);
		clickToElement(driver, MyAccountUI.MY_ACCOUNT_LIST_BOX, dynamicValue);
	}

	public void clickToAddNewAddress(WebDriver driver,String dynamicValue) {
		waitForElementClickable(driver, MyAccountUI.ADDRESS_BUTTON_DYNAMIC, dynamicValue);
		clickToElement(driver, MyAccountUI.ADDRESS_BUTTON_DYNAMIC, dynamicValue);
	}

	public String verifyPasswordChanged(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountUI.BAR_NOTIFICATION_SUCCESS);
		return getElementText(driver, MyAccountUI.BAR_NOTIFICATION_SUCCESS);
	}

	public void clickToCloseBarNotification(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountUI.CLOSE_BAR_NOTIFICATION_SUCCESS);
		clickToElement(driver, MyAccountUI.CLOSE_BAR_NOTIFICATION_SUCCESS);
		
	}
	

}
