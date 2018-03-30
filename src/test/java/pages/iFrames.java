package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class iFrames {
	private WebDriver driver=Driver.getDriver();
	
	public iFrames(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText="Frames")
	public WebElement frames;
	
	@FindBy (linkText="iFrame")
	public WebElement iFrame;
	
	@FindBy (linkText="Nested Frames") //removing "s" at the end 
	public WebElement nestedFrame;
	
	@FindBy (css="div[class='example']")
	public WebElement text;
	
	@FindBy (id="tinymce") //removing "" at the end 
	public WebElement iframeText;
	
	@FindBy (linkText="Elemental Selenium")
	public WebElement elementalSelenium;
	
	public static void switchTab(String url) {
		for(String windowhandle:Driver.getDriver().getWindowHandles()) {
			Driver.getDriver().switchTo().window(windowhandle);
			if(Driver.getDriver().getCurrentUrl().contains(url)) {
				System.out.println("switched");
				return;
			}
		}
	}
	
	public void checkTheCheckboxes(List<WebElement> elements) {
		for(WebElement element:elements) {
			if(!element.isSelected()) {
				element.click();
			}
		}
	}
	
	
	
	
	
	
	
}
