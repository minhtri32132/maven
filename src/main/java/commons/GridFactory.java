package commons;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GridFactory {
	private WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String port;

	public GridFactory(String browserName,String ipAddress,String port) {

		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.port = port;
		
	}

	public WebDriver createDriver() {
		DesiredCapabilities capability = null;
		BROWSERS browsers = BROWSERS.valueOf(browserName.toUpperCase());
		System.out.println(browserName);
		if (browsers == BROWSERS.FIREFOX) {

			WebDriverManager.firefoxdriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capability);
			

		} else if (browsers == BROWSERS.CHROME) {
			WebDriverManager.chromedriver().setup();
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.ANY);
			ChromeOptions options = new ChromeOptions();
			options.merge(capability);
			System.out.println("capability"+ capability);
		} else if (browsers == BROWSERS.EDGE) {
			WebDriverManager.edgedriver().setup();
			capability = DesiredCapabilities.edge();
			capability.setBrowserName("edge");
			capability.setPlatform(Platform.ANY);
			EdgeOptions options = new EdgeOptions();
			options.merge(capability);
		} 
		
		else {
			throw new RuntimeException("Browser name invalid");
		}

		try {
			
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s", ipAddress, port)),
					capability);
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;
	}
}
