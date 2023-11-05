package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverSingleton;
import utils.ConfigReader;

public class Waits {
	private static WebDriverWait wait;

	private static int waitSec = ConfigReader.getIntValue("explicitWaitTimeInSeconds");
	

	public static WebDriverWait getWait() {
		if (wait == null) {
			wait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(waitSec));
		}
		return wait;
	}
	

	public static WebElement waitForElementToBePresented(By locator) {
		return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void clickableElement(By locator) {
		getWait().until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	
	public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
