package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutUs {
	
	public WebDriver driver;
	
	
	public AboutUs(WebDriver driver){
		this.driver=driver;
	}
	
	By homeLink = By.xpath("//*[contains(@id, 'sc_layouts_title')]/div[2]/div/a");
	
	By teamMember1 = By.xpath("//*[contains(@id, 'post')]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/div/div/div[1]/h4/a");
	
	//*[@id="post-88"]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/div/div/div[1]/h4/a
	
	By teamMember2 = By.xpath("//*[contains(@id, 'post')]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/h4/a");
	
	public WebElement getHomeLink() {
		return driver.findElement(homeLink);
	}

	public WebElement getTeamMember1() {
		return driver.findElement(teamMember1);
	}
	
	public WebElement getTeamMember2() {
		return driver.findElement(teamMember2);
	}
	
}
