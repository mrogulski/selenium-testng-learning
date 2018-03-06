package masteringselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicTest {
	
	private void googleSearching(final String searchString) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		WebElement searchField = driver.findElement(By.name("q"));
		searchField.clear();
		searchField.sendKeys(searchString);
		System.out.println("Page title is: " + driver.getTitle());
		searchField.submit();
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driverObject) {
				return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
			}
		});
		
				System.out.println("Page title is: " + driver.getTitle());
				driver.quit();
	}
	
	@Test
	public void googleCheeseExample() throws InterruptedException {
		googleSearching("Cheese");
		Thread.sleep(5000);
	}
	
	@Test
	public void googleMilkExample() throws InterruptedException {
		googleSearching("Milk");
		Thread.sleep(5000);
	}

}
