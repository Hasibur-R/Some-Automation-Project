package forms;

import elements.Element;
import waits.Waits;

public class BaseForm {
	private final Element uniqueElement;

	public BaseForm(Element uniqueElement) {
		this.uniqueElement = uniqueElement;
	}

	public boolean isFormOpen() {
		Waits.waitForElementToBePresented(uniqueElement.getLocator());
		return uniqueElement.isDisplayed();
	}
}
