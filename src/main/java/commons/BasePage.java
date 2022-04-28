package commons;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageOject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageUIs.blueimp.BasePageUI;
import pageUIs.nopcommerce.BasePagenopUI;
import pageUIs.nopcommerce.HomePageUI;
import pageUIs.nopcommerce.RegisterPageUI;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.accept();
	}

	protected void cancelAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.dismiss();
	}

	protected String getAlertText(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		return alert.getText();
	}

	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		Alert alert = waitForAlertPresence(driver);
		alert.sendKeys(textValue);
	}

	protected void switchToWindowByTitle(WebDriver driver, String tableTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(tableTitle))
				break;
		}
	}

	protected void switchToWindowById(WebDriver driver, String tableId) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(tableId))
				driver.switchTo().window(id);

			break;
		}
	}

	protected void closeAllTabWithoutParent(WebDriver driver, String ParentId) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(ParentId))
				driver.switchTo().window(id);
			driver.close();

		}
		driver.switchTo().window(ParentId);
	}

	protected By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	protected WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getBylocator(locatorType));
	}
	protected String getDynamicXpath(String locatorType,String... dynamicLocator) {
		locatorType= String.format(locatorType, (Object[]) dynamicLocator);
		return locatorType;
	}

	protected List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getBylocator(locatorType));
		
	}
	protected List<WebElement> getListWebElement(WebDriver driver, String locatorType,String...dynamicLocator ) {
		return driver.findElements(getBylocator(locatorType));

	}

	protected void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	protected void clickToElement(WebDriver driver, String locatorType,String... dynamicValue) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).click();
	}

	protected void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	protected void sendkeyToElement(WebDriver driver, String locatorType, String textValue,String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
		element.clear();
		element.sendKeys(textValue);
	}

	protected void selectItemInDefaultDropdownByValue(WebDriver driver, String locatorType, String textValue) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByValue(textValue);
	}
	protected void selectItemInDefaultDropdownByValue(WebDriver driver, String locatorType, String textValue,String... dynamicValue) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
		select.selectByValue(textValue);
	}

	protected String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String textValue) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	protected boolean isDropdownMultible(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}

	protected void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath,
			String expectedTextItem) {

		getWebElement(driver, parentXpath).click();
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
		List<WebElement> allItems = driver.findElements(getByXpath(childXpath));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				if (item.isDisplayed()) {
					item.click();
				} else {
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
					item.click();
				}
				break;
			}

		}
	}
	
	protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}

	protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName,String...dynamicValue) {
		return getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValue)).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	public String getElementText(WebDriver driver, String xpathLocator,String...dynamicLocator ) {
		return getWebElement(driver, getDynamicXpath(xpathLocator, dynamicLocator)).getText();
	}

	protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getElementCssValue(driver, xpathLocator, propertyName);
	}

	protected String convertRgbaToHexa(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	protected int getElementSize(WebDriver driver, String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}
	protected int getElementSize(WebDriver driver, String xpathLocator,String... dynamicLocator) {
		return getListWebElement(driver, getDynamicXpath(xpathLocator, dynamicLocator)).size();
	}

	protected void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator,String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValue));
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}
	protected void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator,String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValue));
		if (element.isSelected()) {
			element.click();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	protected boolean isElementDisplayed(WebDriver driver, String xpathLocator,String... dynamicValue) {
		return getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValue)).isDisplayed();
	}
	protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	protected void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	protected void switchToDefaultContent(WebDriver driver, String xpathLocator) {
		driver.switchTo().defaultContent();
	}
	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}
	public void hoverMouseToElement(WebDriver driver, String xpathLocator,String...dynamicValue) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValue))).perform();
	}
	protected void pressKeyToElement(WebDriver driver, String xpathLocator,Keys key,String... dynamicValue) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValue)),key).perform();
	}
	public void setCookies(Set<Cookie> cookies,WebDriver driver)
	{
		for (Cookie cookie :cookies) 
			driver.manage().addCookie(cookie);
			
	}
	public Set<Cookie> getAllCookies(WebDriver driver)
	{
		return driver.manage().getCookies();
	}
	
	

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	

	protected void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		//sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	protected void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	

	protected void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	protected void waitForElementVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(getBylocator(xpathLocator)));
	}
	protected void waitForElementVisible(WebDriver driver,String xpathLocator,String... dynamicLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(getBylocator(getDynamicXpath(xpathLocator, dynamicLocator))));
	}
	protected void waitForAllElementVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getBylocator(xpathLocator)));
	}
	protected void waitForElementInvisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(getBylocator(xpathLocator)));
	}
	public boolean isElementUndisplayed(WebDriver driver, String xpathLocator) {
		
		overrideGlobalTimeout(driver,shortTimeout);
		List<WebElement> elements = getListWebElement(driver, xpathLocator);
		overrideGlobalTimeout(driver,longTimeout);
		if(elements.size()==0)
		{
			return true;
		}
		else if(elements.size()>0 && elements.get(0).isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	public void overrideGlobalTimeout(WebDriver driver,long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	protected void waitForAllElementinvisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}
	protected void waitForElementClickable(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.elementToBeClickable(getBylocator(xpathLocator)));
	}
	protected void waitForElementClickable(WebDriver driver,String xpathLocator,String... dynamicLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		explicitwait.until(ExpectedConditions.elementToBeClickable(getBylocator(getDynamicXpath(xpathLocator, dynamicLocator))));
	}
	private By getBylocator(String locatorType) {
		By by=null;
		System.out.println(locatorType);
		if(locatorType.startsWith("id=")||locatorType.startsWith("Id=")||locatorType.startsWith("ID="))
		{
			by = By.id(locatorType.substring(3));
		}
		else if (locatorType.startsWith("xpath=")||locatorType.startsWith("Xpath=")||locatorType.startsWith("XPATH="))
		{
			by = By.xpath(locatorType.substring(6));
		}
		else
		{
			throw new RuntimeException("Locator type is not support");
		}
		
		return by;
		
	}
	public void uploadMultipleFiles (WebDriver driver, String... fileNames)
	{
		String filePath = System.getProperty("user.dir") + File.separator +"uploadFiles" +File.separator;
		String fullFileName = "";
		for (String file: fileNames) {
			fullFileName= fullFileName +filePath + file + "\n" ;
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
	}
	public void clickToTopMenu(WebDriver driver,String dynamicValue) {
		
		waitForElementClickable(driver,BasePagenopUI.TOP_MENU_LIST, dynamicValue);
		clickToElement(driver, BasePagenopUI.TOP_MENU_LIST, dynamicValue);
	}
	public void clickToSubMenuList(WebDriver driver,String menuList,String subMenu ) {
		hoverMouseToElement(driver,BasePagenopUI.TOP_MENU_LIST, menuList);
		waitForElementClickable(driver,BasePagenopUI.TOP_MENU_LIST, subMenu);
		clickToElement(driver, BasePagenopUI.SUB_MENU_LIST,menuList, subMenu);
	}
	public void selectDropdownSortBy(WebDriver driver,String dropdownValue )
	{
		waitForElementVisible(driver, BasePagenopUI.DROPDOWN_DESKOP_LIST);
		selectItemInDefaultDropdownByValue(driver,BasePagenopUI.DROPDOWN_DESKOP_LIST , dropdownValue);
	}
	public boolean sortByAsc(WebDriver driver) {
		List<WebElement> deskopsName= getListWebElement(driver, BasePagenopUI.DESKOP_DESCRIPTION);
		List<String> deskopsList =new  ArrayList<String>();
		for (WebElement deskop : deskopsName) {
			deskopsList.add(deskop.getText()) ;
			System.out.println(deskopsList);
		}
		List<String> listClone =new  ArrayList<String>(deskopsList);
		Collections.sort(listClone);
		System.out.println(listClone);
		return listClone.equals(deskopsList);
	}
	public boolean sortPriceByAsc(WebDriver driver) {
		List<WebElement> deskopsName= getListWebElement(driver, BasePagenopUI.DESKOP_PRICES);
		List<Float> deskopsList =new  ArrayList<Float>();
		for (WebElement deskop : deskopsName) {
			
			deskopsList.add(Float.parseFloat(deskop.getText().trim().replaceAll("[$,\\s]", ""))) ;
			System.out.println(deskopsList);
		}
		List<Float> listClone =new  ArrayList<Float>(deskopsList);
		Collections.sort(listClone);
		System.out.println(listClone);
		return listClone.equals(deskopsList);
	}
	public boolean sortByDesc(WebDriver driver) {
		List<WebElement> deskopsName= getListWebElement(driver, BasePagenopUI.DESKOP_DESCRIPTION);
		List<String> deskopsList =new  ArrayList<String>();
		for (WebElement deskop : deskopsName) {
			deskopsList.add(deskop.getText()) ;
			System.out.println(deskopsList);
		}
		List<String> listClone =new  ArrayList<String>(deskopsList);
		Collections.reverse(listClone);
		System.out.println(listClone);
		return listClone.equals(deskopsList);
	}
	public boolean sortPriceByDesc(WebDriver driver) {
		List<WebElement> deskopsName= getListWebElement(driver, BasePagenopUI.DESKOP_PRICES);
		List<Float> deskopsList =new  ArrayList<Float>();
		for (WebElement deskop : deskopsName) {
			
			deskopsList.add(Float.parseFloat(deskop.getText().replaceAll("[$,\\s]", ""))) ;
			
			System.out.println(deskopsList);
		}
		for (Float deskop : deskopsList) {
			System.out.println(deskop);
		}
		List<Float> listClone =new  ArrayList<Float>(deskopsList);
		for (Float deskop : listClone) {
			System.out.println(deskop);
		}
		System.out.println("before sort"+deskopsList);
		System.out.println("before sort"+listClone);
		
		Collections.sort(listClone,Collections.reverseOrder());
		//Collections.reverse(listClone);
		System.out.println("after sort"+deskopsList);
		System.out.println("after sort"+listClone);
		
		return listClone.equals(deskopsList);
	}
	public static String generateRandomName() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(4);
		for (int i = 0; i < 4; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
		
	}
	
	public HomePageObject clickToLogOutLink(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.LOG_OUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOG_OUT_BUTTON);
		return new HomePageObject(driver);
	}
	
	public LoginPageOject clickToLoginLink(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,HomePageUI.LOGIN_IN_TEXTBOX );
		clickToElement(driver, HomePageUI.LOGIN_IN_TEXTBOX);
		return PageGeneratorManager.getLoginPageOject(driver);
		
	}
	protected long longTimeout = 30;
	protected long shortTimeout = 5;
}
