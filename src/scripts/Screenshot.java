package scripts;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class Screenshot extends TestListenerAdapter {
	
	public static WebDriver driver;
	@Override
	public void onTestFailure(ITestResult result) {
	File file = new File("");

	Reporter.setCurrentTestResult(result);
	System.out.println(file.getAbsolutePath());
	Reporter.log(file.getAbsolutePath());

	Reporter.log("screenshot saved at "+file.getAbsolutePath()+"\\reports\\"+result.getName()+".jpg");
	Reporter.log("<a href='../"+result.getName()+".jpg' <img src='../"+result.getName()+".jpg' hight='100' width='100'/> </a>");
	
	try {
		System.out.println("I m in Try"+driver);
        new File("FailedScripts/Sample/").mkdirs();
        FileOutputStream out = new FileOutputStream("FailedScripts/Sample/screenshot-sample.png");
        out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        out.close();	    
        Reporter.setCurrentTestResult(null);
    } catch (Exception e) {
    	System.out.println("Exception in taking screenshot" +e.getMessage());
	}
  }

	@Override
	public void onTestSkipped(ITestResult result) {
	// will be called after test will be skipped
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	// will be called after test will pass 
	}
}
