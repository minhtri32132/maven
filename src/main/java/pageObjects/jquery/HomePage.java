package pageObjects.jquery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePage extends BasePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
	}

	public void clickToPaging(String pageIndex) {
		waitForElementClickable(driver, HomePageUI.PAGING_DYNAMIC, pageIndex);
		clickToElement(driver,HomePageUI.PAGING_DYNAMIC, pageIndex );
		
		
	}

	public void inputDynamicByHeaderText(String headerText, String textValue) {
		waitForElementVisible(driver, HomePageUI.HEADER_DYNAMIC, headerText);	
		sendkeyToElement(driver, HomePageUI.HEADER_DYNAMIC, textValue, headerText);
		pressKeyToElement(driver, HomePageUI.HEADER_DYNAMIC, Keys.ENTER,headerText);
		
		
	}

	public boolean isPageNumberActived(String textValue) {
		waitForElementVisible(driver, HomePageUI.PAGING_DYNAMIC_DISPLAY, textValue);
		 return isElementDisplayed(driver,  HomePageUI.PAGING_DYNAMIC_DISPLAY, textValue);
		
	}

	public void inputToTextBoxByColumnAndRow(String columnName, String rowNumber, String valueText) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME,columnName) ;
		System.out.println(columnIndex);
		waitForElementVisible(driver, HomePageUI.COLUMN_INDEX_BY_NAME,columnName);
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_AND_ROW_INDEX, valueText, rowNumber,String.valueOf(columnIndex));
		
	}
	
}
