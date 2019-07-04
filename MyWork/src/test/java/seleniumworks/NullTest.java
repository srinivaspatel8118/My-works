package seleniumworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.Excelconfig;

public class NullTest {
    public static WebDriver driver; 


    @Test(priority=1)
    public void setUp(){
    	WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();

}
   @Test(priority=2)
    public static void TestFacebook() {
        try {
        	 driver.get("https://opensource-demo.orangehrmlive.com/");
	        	Thread.sleep(2000);
	    		String CurrentURL=driver.getCurrentUrl();
	    		Thread.sleep(2000);
	    		Excelconfig excel=new Excelconfig("D:\\fresh\\Exceldata\\Testdata.xlsx");
	    		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(excel.getData(1, 0, 0));
	    		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(excel.getData(1, 0, 1));
	    		Thread.sleep(2000);
	    		driver.findElement(By.id("btnLogin")).click();
	    		boolean status=driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/a/b")).isDisplayed();
	    		Assert.assertTrue(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



   @Test(priority=3)
 public void tearDown(){
     driver.close();
     driver.quit();
 }

}