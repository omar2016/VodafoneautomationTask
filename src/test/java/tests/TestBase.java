package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;



public class TestBase extends AbstractTestNGCucumberTests {

	
	
	public static WebDriver driver ;
	
	@BeforeSuite
	public void startDriver() {
	 
	System.setProperty("webdriver.chrome.driver", 
		System.getProperty("user.dir")+"/driver/chromedriver.exe");
	 driver = new ChromeDriver();
	 Dimension dimension = new Dimension(1920, 1080);
	 driver.manage().window().setSize(dimension);
	 //driver.manage().window().maximize();
	 DesiredCapabilities caps = new DesiredCapabilities();
	 caps.setCapability("resolution", "1024x768");
	 driver.manage().deleteAllCookies();
	 driver.navigate().to("http://automationpractice.com/index.php");
	 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	 
	}
	 @AfterSuite
	 public void stopDriver() {
		 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		 driver.quit();
	 }
 
}
