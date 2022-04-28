package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {

		this.browserName = browserName;
	}
	public WebDriver createDriver()
	{
		BROWSERS browsers = BROWSERS.valueOf(browserName.toUpperCase());
		System.out.println(browserName);
		if (browsers==BROWSERS.FIREFOX) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browsers==BROWSERS.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsers==BROWSERS.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		/*
		 * else if (browserName.equals("coccoc")) {
		 * WebDriverManager.chromedriver().browserVersion("").setup(); ChromeOptions
		 * options = new ChromeOptions();
		 * options.setBinary("\"C:\\Program Files\\Mozilla Firefox\\firefox.exe\"");
		 * driver = new ChromeDriver(options);
		 * 
		 * }
		 */
		else {
			throw new RuntimeException("Browser name invalid");
		}
		return driver;
	}
}
