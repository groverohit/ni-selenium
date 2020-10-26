package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contact {
	
public WebDriver driver;
	
	
	public Contact(WebDriver driver){
		this.driver=driver;
	}
	
	By phone = By.cssSelector("a[href='tel:+1-778-788-0509']");
	
	By email = By.cssSelector("a[href='mailto:info@nowimmigration.ca']");
	
	By firstName = By.xpath("//input[contains(@class, 'first')]");
	
	By lastName = By.xpath("//input[contains(@class, 'last')]");
	
	By emailField = By.xpath("//input[@type='email']");
	
	By messageField = By.xpath("//textarea[contains(@id, 'field_2')]");
	
	By emailOnlyCheckbox = By.xpath("//input[contains(@id, 'field_4_1')]");
	
	By phoneOnlyCheckbox = By.xpath("//input[contains(@id, 'field_4_2')]");
	
	By emailOrPhoneCheckbox = By.xpath("//input[contains(@id, 'field_4_3')]");
			
	
	public WebElement getPhone() {
		return driver.findElement(phone);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement getEmailField() {
		return driver.findElement(emailField);
	}
	
	public WebElement getMessageField() {
		return driver.findElement(messageField);
	}
	
	public WebElement getEmailOnlyCheckbox() {
		return driver.findElement(emailOnlyCheckbox);
	}
	
	public WebElement getPhoneOnlyCheckbox() {
		return driver.findElement(phoneOnlyCheckbox);
	}
	
	public WebElement getEmailOrPhoneCheckbox() {
		return driver.findElement(emailOrPhoneCheckbox);
	}
	
}
