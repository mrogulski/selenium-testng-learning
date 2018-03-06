package masteringselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum DriverType implements DriverSetup {

    FIREFOX {

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            return new FirefoxDriver(capabilities);
        }

		public DesiredCapabilities getDesiredCapabilities() {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            //temporary solution
            capabilities.setBrowserName("firefox");
            capabilities.setCapability("firefox_binary", "C:\\Users\\mrogulski001\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
            return capabilities;
		}
    },
    CHROME {

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            return new ChromeDriver(capabilities);
        }

		public DesiredCapabilities getDesiredCapabilities() {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
            HashMap<String, String> chromePreferences = new HashMap<String, String>();
            chromePreferences.put("profile.password_manager_enabled", "false");
            capabilities.setCapability("chrome.prefs", chromePreferences);
            return capabilities;
		}
    },
    IE {

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            return new InternetExplorerDriver(capabilities);
        }

		public DesiredCapabilities getDesiredCapabilities() {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
            capabilities.setCapability("requireWindowFocus", true);
            return capabilities;
		}
    },
    SAFARI {

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            return new SafariDriver(capabilities);
        }

		public DesiredCapabilities getDesiredCapabilities() {
            DesiredCapabilities capabilities = DesiredCapabilities.safari();
            capabilities.setCapability("safari.cleanSession", true);
            return capabilities;
		}
    },
    OPERA {

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            return new OperaDriver(capabilities);
        }

		public DesiredCapabilities getDesiredCapabilities() {
            DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
            return capabilities;
		}
    },
    
    PHANTOMJS {
    	public DesiredCapabilities getDesiredCapabilities() {
    		DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
    		final List<String> cliArguments = new ArrayList<String>();
    		cliArguments.add("--web-security=false");
    		cliArguments.add("--ssl-protocol=any");
    		cliArguments.add("--ignore-ssl-errors=true");
    		capabilities.setCapability("phantomjs.cli.args",cliArguments);
    		capabilities.setCapability("takesScreenshot", true);
    		return capabilities;
    	}
    	public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
    		return new PhantomJSDriver(capabilities);
    	}
    };

}