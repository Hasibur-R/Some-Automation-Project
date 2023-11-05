package forms;
import org.openqa.selenium.By;

import elements.Element;
import waits.Waits;

public class HomePage extends BaseForm{
	private final Element here = new Element(By.xpath("//a[@href='/game.html' and @class='start__link']"));
	private final Element hideHere= new Element(By.xpath("//button[@class='button button--solid button--blue help-form__send-to-bottom-button']"));
	private final Element cancelButton= new Element(By.xpath("//button[@name='button' and @class='button button--solid button--blue button--fluid']"));
	private final Element okayButton= new Element(By.xpath("//a[@href='/index.html' and @class='button button--solid button--red']"));
	private final Element cookieYES=new Element(By.xpath("//button[@name='button' and @class='button button--solid button--transparent']"));
	
	
	public HomePage() {
		super(new Element(By.xpath("(//p[@class='start__paragraph'])[1]"))); //took start paragraph 1 as a homePage indicator
	}
	
	//=======================
	//Here button
	public void clickOnHere() {
		Waits.waitForElementToBePresented(here.getLocator());
		here.click();
	}
	
	//=======================
	//Send to bottom button
	public void clickOnHide() {
		Waits.waitForElementToBePresented(hideHere.getLocator());
		hideHere.click();
	}
	
	//=======================
	//Cancel button
	public void clickOnCancel() {
		Waits.waitForElementToBePresented(cancelButton.getLocator());
		cancelButton.click();
	}
	
	//=======================
	//Yes button
	public void clickOnYes() {
		Waits.waitForElementToBePresented(okayButton.getLocator());
		okayButton.click();
	}
	
	//=======================
	//No, really no button
	public void acceptCookie() {
		Waits.waitForElementToBePresented(cookieYES.getLocator());
		cookieYES.click();
	}
	
}
