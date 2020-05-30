package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	
	By email =  By.cssSelector("[id='user_email']");
	By pass = By.cssSelector("[type='password']");
	By login = By.cssSelector("input[type='submit']");
	By forgotPassword = By.cssSelector("[href*='password/new']");
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(pass);
	}
	
	public WebElement Login() {
		return driver.findElement(login);
	}
	
	public forgotPasswords forgotPasswordReset() {
		
		driver.findElement(forgotPassword).click();
		forgotPasswords fp = new forgotPasswords(driver);
		return fp;
	}

}
