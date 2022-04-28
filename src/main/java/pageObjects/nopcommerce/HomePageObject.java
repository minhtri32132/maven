package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,HomePageUI.REGISTER_IN_TEXTBOX );
		clickToElement(driver, HomePageUI.REGISTER_IN_TEXTBOX);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public LoginPageOject clickToLoginLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,HomePageUI.LOGIN_IN_TEXTBOX );
		clickToElement(driver, HomePageUI.LOGIN_IN_TEXTBOX);
		return PageGeneratorManager.getLoginPageOject(driver);
		
	}

	public MyAccountOject clickToMyAccountLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_IN_TEXTBOX );
		clickToElement(driver, HomePageUI.MY_ACCOUNT_IN_TEXTBOX);
		return PageGeneratorManager.getMyAccountOject(driver);
	}

}
