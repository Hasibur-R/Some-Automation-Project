package forms;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import driver.DriverSingleton;
import elements.Element;
import waits.Waits;

public class RePage2 extends BaseForm{
	private final Element unSelect = new Element(By.xpath("//label[@class='checkbox__label' and @for='interest_unselectall']"));
	private final Element upload = new Element(By.xpath("//a[@class='avatar-and-interests__upload-button' and text()='upload']"));
	private final Element next=new Element(By.xpath("//button[@name='button' and @class='button button--stroked button--white button--fluid']"));
	private final Element home=new Element(By.xpath("//button[@name='button' and @class='button button--solid button--green']"));
	private final Element okay= new Element(By.xpath("//a[@href='/index.html' and @class=\"button button--solid button--red\"]"));
	
	//===============================
	//hard coded version
	//===============================
	private final Element ponies= new Element(By.xpath("//label[@for='interest_ponies']"));
	private final Element polo = new Element(By.xpath("//label[@for='interest_polo']"));
	private final Element dough= new Element(By.xpath("//label[@for='interest_dough']"));	
	private final Element snails= new Element(By.xpath("//label[@for='interest_snails']"));		
	private final Element balls= new Element(By.xpath("//label[@for='interest_balls']"));
	private final Element postits= new Element(By.xpath("//label[@for='interest_postits']"));
	private final Element faucets= new Element(By.xpath("//label[@for='interest_faucets']"));
	private final Element enveloppes= new Element(By.xpath("//label[@for='interest_enveloppes']"));
	private final Element cables= new Element(By.xpath("//label[@for='interest_cables']"));
	private final Element questions= new Element(By.xpath("//label[@for='interest_questions']"));
	private final Element squares= new Element(By.xpath("//label[@for='interest_squares']"));
	private final Element purple= new Element(By.xpath("//label[@for='interest_purple']"));
	private final Element cotton= new Element(By.xpath("//label[@for='interest_cotton']"));
	private final Element drywall= new Element(By.xpath("//label[@for='interest_drywall']"));
	private final Element closets= new Element(By.xpath("//label[@for='interest_closets']"));
	private final Element tires= new Element(By.xpath("//label[@for='interest_tires']"));
	private final Element windows= new Element(By.xpath("//label[@for='interest_windows']"));
	private final Element mullets= new Element(By.xpath("//label[@for='interest_mullets']"));
	private final Element cinnamon= new Element(By.xpath("//label[@for='interest_cinnamon']"));
	//===============================
	//===============================
	
	public RePage2() {
		super(new Element(By.xpath("h2[@class='avatar-and-interests__title' and contains(text(), 'Choose 3 interests')]")));
	}

	
	//===============================
	//click on unselect all
	//===============================
	public void fistTick() {
		Waits.waitForElementToBePresented(unSelect.getLocator());
		unSelect.click();
	}
	
	
	//===============================
	//upload image
	//===============================
	public void uploadImage(String imageName) {
	    Waits.waitForElementToBePresented(upload.getLocator());
	    WebElement uploadButton = DriverSingleton.getDriver().findElement(upload.getLocator());
	    uploadButton.click();

	    try {
	        Robot robot = new Robot();//robot instance to simulate key press
	        String filePath = "C:\\Users\\Z3TSU\\Downloads\\" + imageName; //file path and image name

	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();// cppy the file path to the clipboard
	        StringSelection stringSelection = new StringSelection(filePath);
	        clipboard.setContents(stringSelection, null);

	        robot.keyPress(KeyEvent.VK_CONTROL);// simulating ctrl+v to paste the file path into the file dialog
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);

	        robot.keyPress(KeyEvent.VK_ENTER); // enter to confirm the file selection
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    } catch (AWTException e) {
	        e.printStackTrace();
	    }
	}
	
	//===============================
	//select random elements
	//===============================
	public void selectRandomCheckboxes() {
	    List<Element> checkboxes = new ArrayList<>();
	    checkboxes.add(ponies); checkboxes.add(polo); checkboxes.add(dough); 
	    checkboxes.add(snails);checkboxes.add(balls); checkboxes.add(postits); 
	    checkboxes.add(faucets);checkboxes.add(enveloppes); checkboxes.add(cables);
	    checkboxes.add(questions);checkboxes.add(squares);checkboxes.add(purple);
	    checkboxes.add(cotton);checkboxes.add(drywall);checkboxes.add(closets);
	    checkboxes.add(tires);checkboxes.add(windows);checkboxes.add(mullets);
	    checkboxes.add(cinnamon);

	    Random random = new Random();
	    Set<Integer> selectedIndices = new HashSet<>();

	    while (selectedIndices.size() < 3) {
	        int randomIndex = random.nextInt(checkboxes.size());
	        if (!selectedIndices.contains(randomIndex)) {
	            checkboxes.get(randomIndex).click();
	            selectedIndices.add(randomIndex);
	        }
	    }
	}
	
	//===================================
	//Next Page
	//===================================
	 public void nextPage() {
		Waits.waitForElementToBePresented(next.getLocator());
		next.click();
	}
		 
	//====================
	///Home Page
	public void homePage() {
		Waits.waitForElementToBePresented(home.getLocator());
		home.click();
	}
	
	//======================
	//click on Okay
	public void okayHome() {
		Waits.waitForElementToBePresented(okay.getLocator());
		okay.click();
		
	}
}