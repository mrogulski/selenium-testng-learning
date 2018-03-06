package masteringselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicTest extends DriverFactory{
	
	private void googleSearching(final String searchString) throws Exception {
		
		WebDriver driver = DriverFactory.getDriver();
		
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

	}
	
	@Test
	public void googleCheeseExample() throws Exception{
		googleSearching("Cheese");
	}
	
	@Test
	public void googleMilkExample() throws Exception{
		googleSearching("Milk");
	}
	
	@Test
	public void googleCowExample() throws Exception{
		googleSearching("Cow");
	}

}
