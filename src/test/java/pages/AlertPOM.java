package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utilities.Driver;

public class AlertPOM {
	
	private static WebDriver driver;
	
	public AlertPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (linkText="JavaScript Alerts")
	public WebElement jsAlerts;
	
	@FindBy (css="li button:nth-child(1)")
	public WebElement jsAlert;
	
	@FindBy (xpath="(//button)[2]")
	public WebElement jsConfirm;
	
	@FindBy (xpath="(//button)[3]")
	public WebElement jsPrompt;
	
	public WebElement result;
}
