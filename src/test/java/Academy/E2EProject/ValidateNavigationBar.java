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

public class ValidateNavigationBar extends base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initlize() throws IOException {
		driver = initializeDriver();
		Log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
	}
	

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		
		//For subscription notification only--JUGAD**//later change thread to fluent wait...
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[4]/div[2]/div/div/div/span/div/div[6]/div/div/button"));
		msg.click();
		 		 
		//inhertence or creating object of the class		
		landingPage l = new landingPage(driver);
		//compare the text from the browser with actual text-error
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		Log.info("Navigation bar is running");
		
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}
		
		 
		@Test(enabled=true)
		public void veryFirst() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(1==2) {
			WebElement msg = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[4]/div[2]/div/div/div/span/div/div[6]/div/div/button"));
			msg.click();}
			
		}
		
		
		
		
		
	

}
