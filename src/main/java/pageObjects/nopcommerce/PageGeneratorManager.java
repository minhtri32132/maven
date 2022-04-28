package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static LoginPageOject getLoginPageOject(WebDriver driver) {
		return new LoginPageOject(driver);
	}
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static MyAccountOject getMyAccountOject(WebDriver driver) {
		// TODO Auto-generated method stub
		return new MyAccountOject(driver);
	}
	public static ComputersObject getComputers(WebDriver driver) {
		return new ComputersObject(driver);
	}
	public MyAccountObject getMyAccountPage(WebDriver driver) {
		return new MyAccountObject(driver);
		
	}
}
