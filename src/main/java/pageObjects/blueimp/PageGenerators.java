package pageObjects.blueimp;

import org.openqa.selenium.WebDriver;

public class PageGenerators  {
	public static HomePage getHomePage(WebDriver driver) {
		return new HomePage(driver);
	}
	
	
}
