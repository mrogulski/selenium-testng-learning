package masteringselenium;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import listeners.ScreenshotListener;
import org.testng.annotations.Listeners;


@Listeners(ScreenshotListener.class)
public class DriverFactory {
	//class to get valid WebDriver instance instead of instantiating new chrome instance

	private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());
	private static ThreadLocal<WebDriverThread> driverThread;
	
	@BeforeSuite
	public static void instantiateDricerObject() {
		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				//add thread to array
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
			}
		};
	}
	
	public static WebDriver getDriver() throws Exception{
		return driverThread.get().getDriver();
	}
	
	@AfterMethod
	public static void quitDriver() throws Exception{
		//previously this closes browser
//		driverThread.get().quitDriver();
		
		getDriver().manage().deleteAllCookies();//doesnt work with chromedriver 2.27 need to upgrade
	}
	
	@AfterSuite
	public static void closeDriverObjects() {
		//close all the driver in thread pool
		for (WebDriverThread webDriverThread: webDriverThreadPool) {
			webDriverThread.quitDriver();
		}
	}
}
