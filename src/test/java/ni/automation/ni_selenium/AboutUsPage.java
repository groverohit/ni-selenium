package ni.automation.ni_selenium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.AboutUs;
import pageObjects.LandingPage;
import resources.Base;

public class AboutUsPage extends Base{
	
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	
	public void inintializeDriver() throws IOException {
		driver = initializeDriver();
		
		log.info("Driver Initialized");
		
		driver.get("https://nowimmigration.ca/");
		
		LandingPage l = new LandingPage(driver);
		
		l.getAboutUsLink().click();
		
	}

	
	@Test(priority=0)
	
	public void testPageTitle() {
		
		AssertJUnit.assertTrue(driver.getTitle().contains("About Us"));
		
		log.info("Title of About Us Page verified");
		
	}
	
	
	@Test(priority=1)
	
	public void testHomeLink() {
		
		AboutUs au = new AboutUs(driver);
		
		au.getHomeLink().click();
		
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://nowimmigration.ca/"));
		
		driver.navigate().back();
		
		log.info("Home link on About Us page verified");
		
	}
	
	@Test(priority=2)
	
	public void testMemberPages() {
		
		AboutUs au = new AboutUs(driver);
		
		au.getTeamMember1().click();
		
		AssertJUnit.assertTrue(driver.getTitle().contains("Vijay Grover"));
		
		driver.findElement(By.xpath("//*[contains(@id, 'sc_layouts_title')]/div[2]/div/a[2]")).click();
		
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://nowimmigration.ca/team/"));
		
		driver.navigate().back();
		
		driver.navigate().back();
		
		au.getTeamMember2().click();
		
		AssertJUnit.assertTrue(driver.getTitle().contains("Nitika Joshi"));
		
		driver.findElement(By.xpath("//*[contains(@id, 'sc_layouts_title')]/div[2]/div/a[2]")).click();
		
		AssertJUnit.assertTrue(driver.getCurrentUrl().equals("https://nowimmigration.ca/team/"));
		
		driver.navigate().back();
		
		driver.navigate().back();	
		
		log.info("Team Members' pages and Team page from About Us page verified");
		
	}
	
	@AfterTest
	
	public void teardown() {
		driver.quit();
	}
}
