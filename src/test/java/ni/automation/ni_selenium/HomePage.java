package ni.automation.ni_selenium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LandingPage;
import resources.Base;

public class HomePage extends Base {
	
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	
	public void inintializeDriver() throws IOException {
		driver = initializeDriver();
		
		log.info("Driver Initialised");
		
		driver.get("https://nowimmigration.ca/");
		
		log.info("Navigated to home page");
		//LandingPage l = new LandingPage(driver);
		
	}
	
	@Test(priority = 0)
	
	public void testSocialIcons() throws IOException, InterruptedException {
		
		
//		driver.get("https://nowimmigration.ca/");
//		
		LandingPage l = new LandingPage(driver);
		String hrefEmail = l.getEmail().getAttribute("href");
		
		AssertJUnit.assertTrue(hrefEmail.equals("mailto:info@nowimmigration.ca"));
		
		l.getFacebook().click();
		
		ArrayList<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(browserTabs.get(1));
		
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://www.facebook.com/nowimmi/"));
		
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		
		l.getInstagram().click();
		
		browserTabs = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(browserTabs.get(1));
		
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://www.instagram.com/nowimmi/"));
		
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		
		l.getTwitter().click();
		
		browserTabs = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(browserTabs.get(1));
		
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://twitter.com/NowImmi"));
		
		driver.close();
		
		driver.switchTo().window(browserTabs.get(0));
		
		log.info("Social Icons verified");
		
	}
	
	
	
//	@Test(priority = 1)
//	
//	public void testActionButtons () throws InterruptedException {
//		
//		LandingPage l = new LandingPage(driver);
//		
//		WebDriverWait wait = new WebDriverWait(driver,50);
//		
//		wait.until(ExpectedConditions.visibilityOf(l.getViewServicesButton()));
//		
//		l.getViewServicesButton().click();
//		
//		Assert.assertTrue(driver.getTitle().contains("Services"));
//		
//		driver.navigate().back();
//		
//		wait.until(ExpectedConditions.visibilityOf(l.getMakeAppointmentButton()));
//		
//		l.getMakeAppointmentButton().click();
//		
//		Assert.assertTrue(driver.getTitle().contains("Appointment"));
//		
//		driver.navigate().back();
//			
//	}
	
	
	@Test(priority = 1)
	
	public void testLinks() {
		
		LandingPage l = new LandingPage(driver);
		
		
		l.getAboutUsLink().click();
		AssertJUnit.assertTrue(driver.getTitle().contains("About Us"));
		driver.findElement(By.xpath("//*[contains(@id, 'sc_layouts_title')]/div[2]/div/a")).click();
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://nowimmigration.ca/"));
		
		l.getServicesLink().click();
		AssertJUnit.assertTrue(driver.getTitle().contains("Services"));
		driver.findElement(By.xpath("//*[contains(@id, 'sc_layouts_title')]/div[2]/div/a")).click();
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://nowimmigration.ca/"));
		
		l.getappointmentLink().click();
		AssertJUnit.assertTrue(driver.getTitle().contains("Appointment"));
		driver.findElement(By.xpath("//*[contains(@id, 'sc_layouts_title')]/div[2]/div/a")).click();
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://nowimmigration.ca/"));
		
		l.getContactLink().click();
		AssertJUnit.assertTrue(driver.getTitle().contains("Contact"));
		driver.findElement(By.xpath("//*[contains(@id, 'sc_layouts_title')]/div[2]/div/a")).click();
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://nowimmigration.ca/"));
		
		log.info("All navigation links on Home Page verified");
		
	}
	
	@Test(priority = 2)
	
	public void testStaticButtons() {
		
		LandingPage l = new LandingPage(driver);
		
		l.getMakeAppointmentButton2().click();
		
		AssertJUnit.assertTrue(driver.getTitle().contains("Appointment"));
		
		driver.navigate().back();
		
		String hrefPhone = l.getLetsTalkButton().getAttribute("href");
		
		AssertJUnit.assertTrue(hrefPhone.equals("tel:+1-778-788-0509"));
		
		log.info("Static Buttons on the Home Page page verified.");
		
	}
	
	@Test(priority = 3)
	
	public void testLogo() {
		
		LandingPage l = new LandingPage(driver);
		
		l.getLogo().click();
		
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://nowimmigration.ca/"));
		
		log.info("Logo link Verified");
		
	}
	
	
	@AfterTest
	
	public void teardown() {
		driver.quit();
	}
	
}
