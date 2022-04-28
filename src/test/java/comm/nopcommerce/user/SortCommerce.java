package comm.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObjects.nopcommerce.ComputersObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import reportConfig.ExtentTestManager;

public class SortCommerce extends BaseTest {
	WebDriver driver;
	ComputersObject computersObject;
	HomePageObject homePageObject;

	@Test
	public void Deskop_TC01_Sort_By_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort by Name");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Page");
		homePageObject = PageGeneratorManager.getHomePageObject(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Open Deskop Page");
		homePageObject.clickToSubMenuList(driver, "Computers ", "Desktops ");
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: select sort asc");
		computersObject = PageGeneratorManager.getComputers(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify");
		computersObject.selectDropdownSortBy(driver, "5");
		computersObject.areJQueryAndJSLoadedSuccess(driver);
		Assert.assertTrue(computersObject.sortByAsc(driver));

		computersObject.selectDropdownSortBy(driver, "5");
		computersObject.areJQueryAndJSLoadedSuccess(driver);
		// Assert.assertTrue(computersObject.sortByDesc(driver));

		computersObject.selectDropdownSortBy(driver, "6");
		computersObject.areJQueryAndJSLoadedSuccess(driver);
		Assert.assertTrue(computersObject.sortByDesc(driver));
		
	}

	@Test
	public void Deskop_TC02_Sort_By_Price(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort by Price");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Page");
		homePageObject = PageGeneratorManager.getHomePageObject(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Open Deskop Page");
		homePageObject.clickToSubMenuList(driver, "Computers ", "Desktops ");

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: select sort asc");
		computersObject = PageGeneratorManager.getComputers(driver);
		computersObject.selectDropdownSortBy(driver, "10");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify");
		computersObject.areJQueryAndJSLoadedSuccess(driver);
		Assert.assertTrue(computersObject.sortPriceByAsc(driver));

		computersObject.selectDropdownSortBy(driver, "11");
		computersObject.areJQueryAndJSLoadedSuccess(driver);
		Assert.assertTrue(computersObject.sortPriceByDesc(driver));
	}

	 @Parameters({ "envWorkPlace", "browser", "url", "ipAddress", "port" })
		@BeforeClass
		public void beforeClass(@Optional("local") String envWorkPlace, @Optional("chrome") String browserName,
				@Optional("") String url, @Optional("") String ipAddress, @Optional("") String portNumber) {
			driver = getBrowserDriver(browserName, url, envWorkPlace, ipAddress, portNumber);
			

		}

	@AfterClass(alwaysRun = true)
	
	public void afterClass() {
		closeBrowserAndDriver();
		 
	}

}
