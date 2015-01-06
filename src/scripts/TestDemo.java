package scripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;






import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class TestDemo {

	//public WebDriver driver;
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void firefoxSetUp() throws MalformedURLException {

		DesiredCapabilities capability = DesiredCapabilities.firefox();

		driver = new FirefoxDriver(capability);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.manage().window().setSize(new Dimension(1920, 1080));
	}
	
	@Before
	public void homePageRefresh() throws IOException {
		//loginBaseUrl = globleVariables.URL; //"https://www.google.co.in/";
		driver.manage().deleteAllCookies();
		//driver.get(loginBaseUrl);
		driver.get("http://www.yahoo.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// driver.get(propertyKeysLoader("login.base.url"));
	}
	
	@AfterClass
	public static void closeBrowser() throws Exception {
		driver.close();
		driver.quit();
	}
		
	@Test
	public void testTwitter() {
		System.out.println("I m in twitter");
	}
	
	@Test
	public void testGoogle() {
		System.out.println("I m in google");
	}
	
	@Test
	public void testYahoo() {
		System.out.println("I m in Yahoo");
	}
   
}
