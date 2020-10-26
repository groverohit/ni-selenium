package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	
	public LandingPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	//By email = By.xpath("//*[@id=\'sc_socials_771573127\']/div/a[1]");
	//By email = By.className("icon-mail-empty");
	By email = By.xpath("//*[contains(@id, 'sc_socials')]/div/a[1]");
	
	//By facebook = By.xpath("//*[@id=\'sc_socials_771573127\']/div/a[2]");
	By facebook = By.className("icon-facebook");
	
	//By instagram = By.xpath("//*[@id=\"sc_socials_771573127\"]/div/a[3]");
	By instagram = By.className("icon-instagramm");
	
	//By twitter = By.xpath("//*[@id=\"sc_socials_771573127\"]/div/a[4]");
	By twitter = By.className("icon-twitter");
	
	
	By viewServicesButton = By.xpath("//*[text()='view services ']");
	
	By makeAppointmentButton = By.xpath("//*[text()='make an appointment ']");
	
	By makeAppointmentButton2 = By.xpath("//*[text()='make an appointment']");
	
	By letsTalkButton = By.xpath("//*[contains(@id, 'sc_button')]");
	
	By logo_img = By.className("logo_image");
	
	By about_us_link = By.xpath("//*[text()='About Us']");
	
	By services_link = By.xpath("//*[text()='Services']");
	
	By appointment_link = By.xpath("//*[text()='Appointment']");
	
	By contact_link = By.xpath("//*[text()='Contact']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getFacebook() {
		return driver.findElement(facebook);
	}
	
	public WebElement getInstagram() {
		return driver.findElement(instagram);
	}
	
	public WebElement getTwitter() {
		return driver.findElement(twitter);
	}
	
	public WebElement getViewServicesButton() {
		return driver.findElement(viewServicesButton);
	}
	
	public WebElement getMakeAppointmentButton() {
		return driver.findElement(makeAppointmentButton);
	}
	
	public WebElement getMakeAppointmentButton2() {
		return driver.findElement(makeAppointmentButton2);
	}
	
	public WebElement getLetsTalkButton() {
		return driver.findElement(letsTalkButton);
	}
	
	public WebElement getLogo() {
		return driver.findElement(logo_img);
	}
	
	public WebElement getAboutUsLink() {
		return driver.findElement(about_us_link);
	}
	
	public WebElement getServicesLink() {
		return driver.findElement(services_link);
	}
	
	public WebElement getappointmentLink() {
		return driver.findElement(appointment_link);
	}
	
	public WebElement getContactLink() {
		return driver.findElement(contact_link);
	}

}
