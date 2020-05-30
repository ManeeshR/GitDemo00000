package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.landingPage;
import pageObjects.loginPage;

public class ValidateTitle extends base {
	public WebDriver driver;
	//Add log4j 
	public static Logger Log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initlize() throws IOException {
		driver = initializeDriver();
		Log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to home page");
	}
	
	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		//For subscription notification only--JUGAD**//later change thread to fluent wait...
		
		 
		//inheritance or creating object of the class
		
		landingPage l = new landingPage(driver);
		//compare the text from the browser with actual text-error
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		
		Log.info("Successfully validated text message");		
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}
		
		 
		@Test(enabled=false)
		public void veryFirst() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement msg = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[4]/div[2]/div/div/div/span/div/div[6]/div/div/button"));
			msg.click();
			
		}
		
		
		
		
		
	

}
