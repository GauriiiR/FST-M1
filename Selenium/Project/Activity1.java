package project;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {
	
	 @Test
	    public void TestMethod1() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		System.out.println("Home page title: " + driver.getTitle());
		String actualTitle = driver.getTitle(); 
		String expectedTitle = "OrangeHRM";
		assertEquals(expectedTitle,actualTitle);
		System.out.printf("Home page title matchs with expected: " +expectedTitle );
		driver.close();
	 }
}
