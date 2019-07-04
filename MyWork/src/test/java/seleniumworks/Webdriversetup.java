package seleniumworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.Excelconfig;

@Test
public class Webdriversetup {
	
	
	@Test(priority=1,description="This test case is used to sort the drop down values in asc")
	public void Dropdwon() throws InterruptedException
	{
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
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
		driver.close();

		}
	
		@Test(priority=2,description="This test case used to get the data from excel")
		public void exceldata() {
			Excelconfig excel=new Excelconfig("D:\\fresh\\Exceldata\\Testdata.xlsx");
			
			System.out.println(excel.getData(1, 0, 0));
			
		}

	}


