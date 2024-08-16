package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	//Declare driver
	AppiumDriver driver;
	
	@BeforeClass
	public void setUP() throws MalformedURLException, URISyntaxException {
	//Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options().
				setPlatformName("android").
				setAutomationName("UiAutomator2").
				setAppPackage("com.google.android.calculator").
				setAppActivity("com.android.calculator2.Calculator").
				noReset();
		
		//Set Appium server url
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Initializing driver
		driver = new AndroidDriver(serverURL, caps);
		
	}
	
	@Test
	public void multiplicationTest() {
		//Find digit 9 and press it
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
		
		//Find multiply and press it
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		
		
		
		//Find digit 2 and press it
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
		
		//Find digit 0 and press it
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
				
		//Find equal and press it
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		//Get the result and assert
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
	    System.out.println("Sum of numbers: " + result);
	    Assert.assertEquals(result, "180");
		
	}
}
