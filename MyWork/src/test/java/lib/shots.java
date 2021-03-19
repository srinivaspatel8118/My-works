package lib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class shots {

	public static void captureScreenshots(WebDriver driver, String shotname)
	{
		try {
			System.out.println("Test statging");
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File("./Screenshots/"+shotname+".png"));
			System.out.println("screen shot taken");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excep tion is"+e);
		} 
	}
	
}
