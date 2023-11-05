package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.DriverSingleton;
import forms.HomePage;
import forms.RePage;
import forms.RePage2;
import utils.ConfigReader;
import waits.Waits;
import driver.DriverPassaANDEmail;

public class L2Test {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver= DriverSingleton.getDriver();
	}
	
	@Test
	public void Test() {
		driver.get(ConfigReader.getStringValue("url"));
		HomePage homePage= new HomePage();
		RePage rePage = new RePage();
		RePage2 rePage2= new RePage2();
		
		
		//================================
		//Test Case  1
		//===============================
		//Page 1=========================
		boolean homePageIsOpen = homePage.isFormOpen(); //checking if the Home Page is open or not
		Assert.assertTrue(homePageIsOpen, "HomePage is not Opneded");
		if(homePageIsOpen==true) {
			System.out.println("Home Page is Open");
		}
		Waits.sleep(1000);
		homePage.clickOnHere();
		
		//Page 2 card1 =========================
		boolean rePageIsOpen= rePage.isFormOpen(); //checking if the card 1 is open or not
		Assert.assertTrue(rePageIsOpen, "The '1' card is not open.");
		if(homePageIsOpen==true) {
			System.out.println("The '1' card is open.");
		}
		rePage.clickOnPassword(); //Password
		rePage.sendPassword(DriverPassaANDEmail.generateRandomPassword());
		
		rePage.clickOnUName(); //Your Name
		rePage.sendUserName(DriverPassaANDEmail.getRandomName());
		
		rePage.clickOnDomain(); //Domain
		rePage.sendDomains(DriverPassaANDEmail.generateRandomEmail());
		
		rePage.selectRandomOptionFromDropdown(); //random domain extention 
		
		rePage.unTick(); // Policy untick 
		Waits.sleep(2000);
		rePage.nextPage();
		
		
		//Page 2 card2 =========================
		rePage2.uploadImage("avatar2.png"); // Image upload 
		Waits.sleep(3000);
		
		rePage2.fistTick(); //Unselect All
		Waits.sleep(2000);
		
		rePage2.selectRandomCheckboxes(); //selecting random 3 checkbox ap
		
		
		rePage2.nextPage();
		Waits.sleep(2000);
		
		//================================
		//Test Case 2
		//================================
		//Page 3=========================
		rePage2.homePage();
		Waits.sleep(2000);
		rePage2.okayHome();
		
		homePage.clickOnHere();
		homePage.clickOnHide();
		
		Waits.sleep(16000);
		homePage.clickOnCancel();
		Waits.sleep(2000);
		homePage.clickOnYes();
		
		//================================
		//Test Case 3
		//================================
		Waits.sleep(2000);
		homePage.clickOnHere();
		Waits.sleep(3000);
		homePage.acceptCookie();
		
		
		//================================
		//Test Case 4
		//================================
		Waits.sleep(3000);
		homePage.clickOnCancel();
		Waits.sleep(3000);
		homePage.clickOnYes();
		
	}
	
}
