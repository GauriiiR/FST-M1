package examples;

import java.net.URL;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

//activity1
public class FirstTest {
	//Declare driver
	AppiumDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		//create desire capabilities
		UiAutomator2Options caps = new UiAutomator2Options().
			setPlatformName("android").
			setAutomationName("UiAutomator2").
			setAppPackage("com.google.android.calculator").
			setAppActivity("com.android.calculator2.Calculator").
			noReset();  //to prevent appium from resetting the application. to avoid signup, etc.
		//setAppPackage and setAppActivity will be take from Appium Inspector. Make sure there's no 'launcher' in the values.
		//Appium inspector: Commands > App Management > getCurrentPackage, getCurrentActivity		
		
		//set appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//initializing driver
		driver = new AndroidDriver(serverURL, caps);
	}
	
	@Test
	public void additionTest() {
		//Find digit 6 and tap it
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_6")).click();  //id comes from resource ID
		//Find plus button and tap it
		driver.findElement(AppiumBy.accessibilityId("plus")).click();     //accessibility ID comes from content-desc. Here id can also be used.
		//Find digit 9 and tap it
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
		//Find equals and tap it
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();
		//Get the result and asset
		String result = driver.findElement(AppiumBy.id("result_final")).getText(); //perform 6+9= on phone and get the resource ID of result field from appium. To make it readable, only copied last part 
		Assert.assertEquals(result, "15");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
