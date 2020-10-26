package ni.automation.ni_selenium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.Appointment;
import pageObjects.LandingPage;
import resources.Base;

public class AppointmentPage extends Base {
	
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	
	public void inintializeDriver() throws IOException {
		
		driver = initializeDriver();
		
		log.info("Driver Initialized");
		
		driver.get("https://nowimmigration.ca/");
		
		LandingPage l = new LandingPage(driver);
		
		l.getappointmentLink().click();
		
	}
	
	@Test(priority=0)
	
	public void testRequiredAppointmentFields() {
		Appointment ap = new Appointment(driver);
		
		AssertJUnit.assertTrue(ap.getFirstName().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(ap.getLastName().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(ap.getEmail().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(ap.getPhone().getAttribute("required") != null);
		
		
		//ap.getEmail().sendKeys("First@first.com");
		
//		Select s = new Select(ap.getLocation());
//		
//		s.selectByIndex(1);
//		s.selectByIndex(2);
		
		AssertJUnit.assertTrue(ap.getLocation().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(ap.getDate().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(ap.getTime().getAttribute("required") != null);
		
		AssertJUnit.assertTrue(ap.getServiceType().getAttribute("required") != null);
		
		log.info("Required fields in Appointment form on Appointment page verified");
		
	}
	
	
	@Test(priority=1)
	
	public void testLocationOptions() {
		
		String[] exp = {"Choose", "Virtual", "Delta"};
		
		Appointment ap = new Appointment(driver);
		
		Select loc = new Select(ap.getLocation());
		
		List<WebElement> options = loc.getOptions(); 
		
		//System.out.println(options.toString());
		 for(WebElement we:options)  
		 {  
		  boolean match = false;
		  
		  //System.out.println(we.getText());
		  for (int i=0; i<exp.length; i++){
		      if (we.getText().contains(exp[i])){
		        match = true;
		      }
		    }
		  AssertJUnit.assertTrue(match);
		 }  

		 log.info("Location dropdown options on Appointment form on Appointment page verified");
		
	}
	
	
	@Test(priority=2)
	
	public void testServiceOptions() {
		
		String[] exp = {"Choose", "General", "Permanent", "Temporary", "LMIA", "Express", "Provincial", "Super", "Study", "Family", "Canadian"};
		
		Appointment ap = new Appointment(driver);
		
		Select loc = new Select(ap.getServiceType());
		
		List<WebElement> options = loc.getOptions(); 
		
		//System.out.println(options.toString());
		 for(WebElement we:options)  
		 {  
		  boolean match = false;
		  
		  //System.out.println(we.getText());
		  for (int i=0; i<exp.length; i++){
		      if (we.getText().contains(exp[i])){
		        match = true;
		      }
		    }
		  AssertJUnit.assertTrue(match);
		 }  

		 log.info("Type of Service dropdown options on Appointment form on Appointment page verified");
		
	}
	
	
	@AfterTest
	
	public void teardown() {
		driver.quit();
	}

}
