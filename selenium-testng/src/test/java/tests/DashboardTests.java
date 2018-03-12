package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import masteringselenium.DriverFactory;
import page_objects.DashboardPage;

public class DashboardTests extends DriverFactory{
	
	@Test
	public void dashboardHeaderTest() throws Exception{
		getDriver().get("http://coderthemes.com/highdmin/default/index.html");
		
		DashboardPage dashboardPage = new DashboardPage();
		
		assert(dashboardPage.headingLocator.getText().equals("ACCOUNT OVERVIEW"));
	}

}
