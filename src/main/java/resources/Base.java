package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver; 
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/rohitgrover/Documents/Projects/SeleniumAutomation/ni-selenium/src/main/java/resources/data.properties");
		
		prop.load(fis);
		String browserName = (prop.getProperty("browser"));
		//String browserName = browser;
		//System.out.println(browserName);
		//String browserName = "chromeBrowser";
		
		if(browserName.equals("chrome"))
		
		{
			//System.out.println("here");
			System.setProperty("webdriver.chrome.driver", "/Users/rohitgrover/Documents/Tech/chromedriver");
			driver = new ChromeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}

}
