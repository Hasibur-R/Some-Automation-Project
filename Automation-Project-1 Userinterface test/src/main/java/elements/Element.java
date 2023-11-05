package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverSingleton;
public class Element extends BaseElement{
	private final By locator;

	public Element(By locator) {
		super(locator);
		this.locator = locator;
	}

	public By getLocator() {
		return locator;
	}

	public WebElement getElement() {
		return DriverSingleton.getDriver().findElement(locator);
	}
}
