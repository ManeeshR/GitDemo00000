package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	protected WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		//System.getProperty("user.dir")= same as system path.
		FileInputStream fis = new FileInputStream("C:\\Users\\Madhu\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		
		prop.load(fis);
		//mvn command to set browsers
		// -Dbrowser=chrome
		//String browserName = System.getProperty("browser");
		
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (7)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("IE")){
			System.getProperty("webdriver.ie.driver", "D:\\Selenium\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\report\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		
		return destinationFile;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
