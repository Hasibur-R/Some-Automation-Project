package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class DriverSingleton {

	private static String browser = ConfigReader.getStringValue("browser");
	private static WebDriver driver;
	
	//=================
	//getting browser
	//=================
	public static WebDriver getDriver() {
		if (driver == null) {
			// Invoking the *Chrome* browser
			if ("chrome".equals(browser)) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize(); 
			} else if ("firefox".equals(browser)) { // Invoking the *Firefox* browser
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			} else if ("edge".equals(browser)) { // Invoking the *edge* browser
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
			} else {
				throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
		}

		return driver;

	}

	//=================
	//quitting browser
	//=================
	public static void quitDriver() {
		driver.quit();
		driver = null;
	}

}
