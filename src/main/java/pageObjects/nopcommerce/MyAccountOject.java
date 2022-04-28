package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.LoginPageUI;

public class MyAccountOject extends BasePage{
	WebDriver driver;

	public MyAccountOject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
}
