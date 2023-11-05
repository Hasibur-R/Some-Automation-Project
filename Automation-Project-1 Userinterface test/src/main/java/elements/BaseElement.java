package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.DriverSingleton;

public class BaseElement{
	private By locator;

	public BaseElement(By locator) {
		this.locator = locator;
	}

	public void click() {
		getElement().click();
	}

	public String getText() {
		return getElement().getText();
	}

	protected WebElement getElement() {
		return DriverSingleton.getDriver().findElement(locator);

	}
	
	public boolean isDisplayed() {
		return getElement().isDisplayed();
	}
	
	 public void scrollElementVisible() {
	        WebDriver driver = DriverSingleton.getDriver();
	        WebElement element = getElement();
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

	        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
	    }
	
	public void moveToElement() {
		WebElement hoverable=DriverSingleton.getDriver().findElement(locator);
		new Actions(DriverSingleton.getDriver()).moveToElement(hoverable).perform();
	}
}
