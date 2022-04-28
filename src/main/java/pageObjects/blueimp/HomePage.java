package pageObjects.blueimp;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.blueimp.BasePageUI;
import pageUIs.blueimp.HomePageUI;

public class HomePage extends BasePage{
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	public void clickToAddFile() {
		clickToElement(driver, BasePageUI.UPLOAD_FILE_TYPE);
		
	}

	public void clicktoStartButton() {
		
		int size =getElementSize(driver, HomePageUI.BUTTON_START,"Start");
		for (int i = 1; i <= size; i++) {
			waitForElementVisible(driver, HomePageUI.BUTTON_START_ID,String.valueOf(i));
			clickToElement(driver, HomePageUI.BUTTON_START_ID,String.valueOf(i));
		}
		
		
	}
}
