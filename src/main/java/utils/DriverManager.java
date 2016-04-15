package utils;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverManager {

	private static WebDriver driver;
	private static Logger logger = LogManager.getRootLogger();
	private static String browserType="browser";

	private static void initDriver() {
		BrowserType browser = BrowserType.valueOf(PropertyProvider.getProperty(browserType));
		switch (browser) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		default:
			driver = new FirefoxDriver();
		}
		configureDriver();
		logger.info("Browser is configured");
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			initDriver();
		}
		return driver;
	}
	
	public static void closeDriver(){
		driver.quit();
		driver = null;
		logger.info("Browser closed");
	}
	
	private static void configureDriver(){
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
