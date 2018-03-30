package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver==null) {
			switch (ConfigReader.getProperty("browser")) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", 
						ConfigReader.getProperty("chrome.driver.path"));
				driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}
		}
		return driver;
	}
	
	public static void closeDriver() {
		if(driver!=null) {
			driver.quit();
			driver=null;
		}
	}
	
	
}
