package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeFox {
	static WebDriver driver;

	public static WebDriver chromeDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver",
					"./src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static WebDriver firefoxDriver() {
		if (driver == null) {
			System.setProperty("webdriver.gecko.driver",
					"./src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		return driver;
	}
}
