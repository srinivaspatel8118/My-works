package seleniumworks;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.shots;


	@Test
	public class Xpathdemo {
	  /*
	   * To know weather facebook getting login and logut 
	   */
	    public static WebDriver driver; 
		
		public void testCase1() throws Exception {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver(options);
	    
		
	        driver.get("https://www.facebook.com/");
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
			driver.manage().window().maximize();
			
			shots.captureScreenshots(driver,"Loginpage");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("9494090982");
			
	
			driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Srinivaspatel8118.");
			 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
			// WebDriverWait wait=new WebDriverWait(driver,40);
			// wait.pollingEvery(5, TimeUnit.SECONDS);
			// WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='pageLoginAnchor']")));
			//Thread.sleep(10000);
			shots.captureScreenshots(driver,"HomePage");
			 // driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			  
			 // WebDriverWait wait=new WebDriverWait(driver,40);
			 // WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='pageLoginAnchor']")));
			  
			driver.findElement(By.xpath("//a[@id='pageLoginAnchor']")).click();
			//Thread.sleep(10000);
			shots.captureScreenshots(driver,"Accountsetting");
			driver.findElement(By.xpath("(//*[text()='Settings'])[4]")).click();
			//Thread.sleep(10000);
			shots.captureScreenshots(driver,"Settingspage");
			driver.findElement(By.xpath("//a[@id='pageLoginAnchor']")).click();
			//Thread.sleep(5000);
			//driver.findElement(By.xpath("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem'][@role='presentation']")).click();
			////li[@class='_54ni __MenuItem']/span//following::li[14] using following worked
			driver.findElement(By.xpath("//li[@class='_54ni __MenuItem']/span//following::li[14]")).click();
			
			shots.captureScreenshots(driver,"afterlogout");
			driver.close();
					driver.quit();
		}
		
		@AfterMethod
		public void failurescreenshot(ITestResult result)
		{
			if(ITestResult.SUCCESS==result.getStatus())
			{
				shots.captureScreenshots(driver, result.getName());
				
			}
			
		}
	}