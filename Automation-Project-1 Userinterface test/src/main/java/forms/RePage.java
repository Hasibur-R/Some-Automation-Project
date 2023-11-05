package forms;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import driver.DriverSingleton;
import elements.Element;
import waits.Waits;

public class RePage extends BaseForm{
	private final Element password = new Element(By.xpath("//input[@placeholder='Choose Password' and @class='input input--blue input--gray']"));
	private final Element yourEmail= new Element(By.xpath("//input[@placeholder='Your email' and @class='input input--blue input--gray']"));
	private final Element domains= new Element(By.xpath("//input[@placeholder='Domain' and @class='input input--blue input--gray']"));
	private final Element selectDom = new Element(By.xpath("//div[@class='dropdown dropdown--gray']"));
	private final Element tick= new Element(By.xpath("//span[@class='icon icon-check checkbox__check']"));
	private final Element next=new Element(By.xpath("//a[@class='button--secondary']"));
	
	public RePage() {
		super(new Element(By.xpath("//div[@class='login-form__container']")));
	}
	
	//===================================
	//click Random userName
	//===================================
	public void clickOnUName() {
		Waits.waitForElementToBePresented(yourEmail.getLocator());
		password.click();	
	}
	
	//===================================
	//Writing Random userName
	//===================================
	public void sendUserName(String input) {
		WebElement uNameElement = yourEmail.getElement();
		uNameElement.clear();
		uNameElement.sendKeys(input);
	}
	
	
	//===================================
	//click Random Password
	//===================================
	public void clickOnPassword() {
		Waits.waitForElementToBePresented(password.getLocator());
		yourEmail.click();
		
	}
	
	//===================================
	//Sending Random Password
	//===================================
	public void sendPassword(String input) {
		WebElement passwordElement = password.getElement();
	    passwordElement.clear();
		passwordElement.sendKeys(input);
	}
	
	
	//===================================
	//Click on Domains 
	//===================================
	public void clickOnDomain() {
		Waits.waitForElementToBePresented(domains.getLocator());
		domains.click();
	}
	//===================================
	//Sending Domains name
	//===================================
	public void sendDomains(String input) {
		WebElement domainElement = domains.getElement();
		domainElement.clear();
		domainElement.sendKeys(input);
	}
	
	//===================================
	//click on Domain extension
	//===================================
	public void clickOnOther() {
		Waits.waitForElementToBePresented(selectDom.getLocator());
		selectDom.click();
	}
	
	//===================================
	//Select random Domain
	//===================================
	 public void selectRandomOptionFromDropdown() {
	    clickOnOther();
	       
	    Waits.waitForElementToBePresented(By.cssSelector(".dropdown__list"));// waiting for dropdown list to appear
	    List<WebElement> dropdownOptions = DriverSingleton.getDriver().findElements(By.cssSelector(".dropdown__list-item"));// find all the dropdown list items
	    int randomIndex = new Random().nextInt(dropdownOptions.size());// generate a random index to select a random option
	     dropdownOptions.get(randomIndex).click();// Click on the random option
	  }
	 
	//===================================
	//select the tick
	//===================================
	 public void unTick() {
		 Waits.waitForElementToBePresented(tick.getLocator());
		tick.click();
	 }
	 
	//===================================
	//Next Page
	//===================================
	 public void nextPage() {
		 Waits.waitForElementToBePresented(next.getLocator());
		 next.click();
	 }

	
}
