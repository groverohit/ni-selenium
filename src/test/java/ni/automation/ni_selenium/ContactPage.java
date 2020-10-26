package ni.automation.ni_selenium;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.Contact;
import pageObjects.LandingPage;
import resources.Base;

public class ContactPage extends Base{
	
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
@BeforeTest
	
	public void inintializeDriver() throws IOException {
		driver = initializeDriver();
		
		log.info("Driver initialized");
		
		driver.get("https://nowimmigration.ca/");
		
		LandingPage l = new LandingPage(driver);
		
		l.getContactLink().click();
		
	}

@Test(priority=0)

	public void testContactButtons() {
	
		Contact c = new Contact(driver);
		
		AssertJUnit.assertTrue(c.getPhone().isDisplayed());
		
		AssertJUnit.assertTrue(c.getEmail().isDisplayed());
		
		log.info("Contact Buttons on Contact page verified");
	}

@Test(priority=1)

	public void testRequiredMessageFields() {
		
		Contact c = new Contact(driver);
			
		AssertJUnit.assertTrue(c.getFirstName().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(c.getLastName().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(c.getEmailField().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(c.getMessageField().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(c.getEmailOnlyCheckbox().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(c.getPhoneOnlyCheckbox().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(c.getEmailOrPhoneCheckbox().getAttribute("required") != null);
		
		log.info("The Send Message form rrequired field on Contact page verified");
		
	}


@AfterTest

	public void teardown() {
	driver.quit();
	}





}
