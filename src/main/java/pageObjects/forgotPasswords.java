package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPasswords {
	
	public WebDriver driver;
	
	By email =  By.cssSelector("[id='user_email']");
	By sendMeInstructions = By.cssSelector("[type='submit']");
	
	
	public forgotPasswords(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	
	public WebElement setsendMeInstructions() {
		
		return driver.findElement(sendMeInstructions);
	}

}
