package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	AndroidDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		//create desire capabilities
		UiAutomator2Options options = new UiAutomator2Options().
			setPlatformName("android").
			setAutomationName("UiAutomator2").
			setAppPackage("com.android.chrome").
			setAppActivity("com.google.android.apps.chrome.Main").
			noReset();
		
		//Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Open selenium page
		driver.get("https://v1.training-support.net/selenium");
	}
	
	@Test
	public void webAppTest() throws InterruptedException {
		//Get width and height of screen
		Dimension dims = driver.manage().window().getSize(); //getSize() returns dimensions of screen i.e. width and height
		System.out.println(dims);
		Point start = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.8)); //50% of screen size = width [decimal] * 0.5[float] = float. but we need int. thats why (int)
		Point end = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.6));
		
		//wa
		
		
		
		//Wait for to-do list link and click it
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath("//android.widget.TextView[contains(@text, 'To-Do List']"))).click();
		
		//
		
	}
	
	
	
}
