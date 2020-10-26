package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Appointment {
	
	public WebDriver driver;
	
	
	public Appointment(WebDriver driver){
		this.driver=driver;
	}
	
	By firstName = By.xpath("//*[contains(@name, 'first')]");
	
	By lastName = By.xpath("//*[contains(@name, 'last')]");
	
	By email = By.xpath("//input[@type='email']");
	
	By phone = By.xpath("//input[@type='tel']");
	
	By location = By.xpath("//select[contains(@id, 'field_11')]");
	
	By date = By.xpath("//input[contains(@name, 'date')]");
	
	By time = By.xpath("//input[contains(@name, 'time')]");
	
	By serviceType = By.xpath("//select[contains(@id, 'field_10')]");
			
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPhone() {
		return driver.findElement(phone);
	}
	
	public WebElement getLocation() {
		return driver.findElement(location);
	}
	
	public WebElement getDate() {
		return driver.findElement(date);
	}
	
	public WebElement getTime() {
		return driver.findElement(time);
	}
	
	public WebElement getServiceType() {
		return driver.findElement(serviceType);
	}

}
