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
import pageObjects.forgotPasswords;
import pageObjects.landingPage;
import pageObjects.loginPage;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initlize() throws IOException {
		driver = initializeDriver();
		
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String text) throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		//inhertence or creating object of the class
		
		landingPage l = new landingPage(driver);
        loginPage lp =	l.getLogin();// l.getLogin=driver.findElement
		//loginPage lp = new loginPage(driver);
		Thread.sleep(2000);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		
		Log.info(text);
		lp.Login().click();
		
		forgotPasswords fp = lp.forgotPasswordReset();
		fp.getEmail().sendKeys("newmails");
		fp.setsendMeInstructions().click();
		
	}
		
		@DataProvider
		public Object[][] getData() {
	//row stand for how many different data type test should run
	//column stands for how many value foe each test
			
			Object[][] data =new Object[2][3];
			//0 th row
			data[0][0] = "maneeshsjce@gmail.com";
			data[0][1] = "12334";
			data[0][2] = "Restected usr";
			//1 st row
			data[1][0] = "restecteduser@gmail.com";
			data[1][1] = "999334";
			data[1][2] = "NonRestected usr";
			
			return data;
		
			
			
			
		}
		@AfterTest
		public void tearDown() {
			driver.close();
			
		}
			
		
		
		
		
	

}
