package masteringselenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class DriverFactory {
	//class to get valid WebDriver instance instead of instantiating new chrome instance

	private static ThreadLocal<WebDriverThread> driverThread;
	
	@BeforeSuite
	public static void instantiateDricerObject() {
		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				return webDriverThread;
			}
		};
	}
	
	public static WebDriver getDriver() throws Exception{
		return driverThread.get().getDriver();
	}
	
	@AfterMethod
	public static void quitDriver() throws Exception{
		driverThread.get().quitDriver();
	}
}
