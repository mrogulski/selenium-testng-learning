package page_objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import masteringselenium.DriverFactory;

public class DashboardPage {
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/div[2]/div[2]/div/div[1]/div/div/h4")
	public WebElement headingLocator;
	
	public DashboardPage() throws Exception {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

}
