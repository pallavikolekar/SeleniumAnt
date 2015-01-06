package scripts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.jna.platform.FileUtils;

public class GoogleDemo {
	
	

	public static WebDriver driver;
	
	@BeforeMethod
	public void InitilizeDriver() {
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
	}
	
	@Test
	public void testGoogle() {
	 
	  System.out.println("I m in google");
      Assert.assertEquals("This is Title verification", "Google1", driver.getTitle());
	}
	
	@AfterMethod
	public void DestroyDriver(ITestResult result) throws Exception {
		System.out.println("Driver "+driver);
		if (!result.isSuccess()) 
			takeScreenShoot(driver, result.getMethod());
		driver.quit();
	}
	
	public void takeScreenShoot(WebDriver driver, ITestNGMethod testMethod) throws Exception {
		
	    String methodName = testMethod.getMethodName();
	    new File("FailedScripts/"+methodName+"/").mkdirs();
        FileOutputStream out = new FileOutputStream("FailedScripts/"+methodName+"/screenshot-"+methodName+".png");
        out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        out.close();	    
		   
	}
	
}
