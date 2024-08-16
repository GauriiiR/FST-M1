package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		//Set desired capabilities
		UiAutomator2Options caps = new UiAutomator2Options()
				.setPlatformName("android")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.google.android.keep")
				.setAppActivity(".activities.BrowseActivity")
				.noReset();

		// initialization
		URL serverURL = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverURL, caps);

	}

	@Test
	public void AddTask_onGoogleTaks() {
		
		driver.findElement(AppiumBy.accessibilityId("New text note")).click();
		driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"))
		.sendKeys("Use the Google Keep app to add a note");
		driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"))
			.sendKeys("Appiun Project Activity2");
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		
		WebElement TaksTile= driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title"));
		  Assert.assertEquals(TaksTile.getText(),"Task1");
	}

	@AfterClass
	public void closeTest() {
		driver.quit();
	}

}
