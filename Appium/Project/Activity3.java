package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {

	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// set capabilities
		UiAutomator2Options caps = new UiAutomator2Options()
				.setPlatformName("android")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.google.android.keep")
				.setAppActivity(".activities.BrowseActivity")
				.noReset();
		//Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Initializing driver
		driver = new AndroidDriver(serverURL, caps);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@Test
	public void AddTask_onGoogleTaks() {
		
		//Task Added
		driver.findElement(AppiumBy.accessibilityId("New text note")).click();
		driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"))
		.sendKeys("Use the Google Keep app to add a note with a reminder");
		driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"))
			.sendKeys("Activity3");
		driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/menu_text' and @text='Later today']"))
			.click();
		
		//Navigate to back
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		driver.findElement(AppiumBy.id("com.google.android.keep:id/browse_note_interior_content")).click();
		
		// verify reminder
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Time reminder Today, 16:00")));
		
		WebElement reminderText=driver.findElement(AppiumBy.accessibilityId("Time reminder Today, 16:00"));
		Assert.assertEquals(reminderText.getText(),"Today, 16:00");
		System.out.println("Reminder is "+reminderText.getText());
		
		
		WebElement TaksTile=driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title"));
		  Assert.assertEquals(TaksTile.getText(),"Activity3");
	}

	@AfterClass
	public void closeTest() {
		driver.quit();
	}

}
