package seleniumworks;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@Test
public class DropdownSorting {
  /*
   * To know weather drop down list are in ascending order or descending order 
   */
    public static WebDriver driver; 
	
	public void testCase1() {
		
		WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
	driver.get("http://seleniumpractise.blogspot.com/");
	Select tools= new Select(driver.findElement(By.id("tools")));
	
	List actuallist= new ArrayList();
	
	List<WebElement> myTools=tools.getOptions();
	
		for(WebElement ele:myTools)
			{
				String data=ele.getText();
					actuallist.add(data);
		System.out.println(data);
			}
	
	List temp=new ArrayList();
	
	temp.addAll(actuallist);
	
	Collections.sort(temp);
	

	Assert.assertTrue(actuallist.equals(temp));
	

	}
	
	
	
	/*
	 * new test script
	 */
		@Test(priority=2)
		
		  /*
		   * To know weather drop down list are in ascending order or descending order 
		   */public void testCase2() throws InterruptedException {
				
					driver.get("http://seleniumpractise.blogspot.com/");
					Thread.sleep(2000);
					Select tools= new Select(driver.findElement(By.id("tools")));
			
			List actuallist= new ArrayList();
			
			List<WebElement> myTools=tools.getOptions();
			
				for(WebElement ele:myTools)
					{
						String data=ele.getText();
							actuallist.add(data);
				System.out.println(data);
					}
			
			List temp=new ArrayList();
			
			temp.addAll(actuallist);
			
			Collections.sort(temp);
			

			Assert.assertTrue(actuallist.equals(temp));
			driver.close();
driver.quit();
			}

		}


