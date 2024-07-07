package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {
	WebDriver driver;
	
	//setup function
	@BeforeClass
	public void setUp() {
		//download and install Geckodriver
		WebDriverManager.firefoxdriver().setup();
		//Initialize firefox driver
		driver = new FirefoxDriver();
		//open page
		driver.get("https://v1.training-support.net");
	}
	
	//test function
	@Test(priority = 1)
	public void homePageTest() {
		//assert page title
		Assert.assertEquals(driver.getTitle(), "Training Support");
		
		//find and click about page link
		driver.findElement(By.id("about-link")).click();
	}
	
	//test function
	@Test(priority = 2)
	public void aboutPageTest() {
		//Assert page title
		Assert.assertEquals(driver.getTitle(), "About Training Support");	
	}
	
	//teardown function - close browser
	@AfterClass
	public void tearDown() {
		//Close browser
		driver.quit();
	}

}
