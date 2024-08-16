package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void TestMethod() {
	
	driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	}
	
	@Test
	public void Test() {
	
	driver.findElement(By.id("txtUsername")).sendKeys("orange");
	driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	driver.findElement(By.id("btnLogin")).click();
	String message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
    System.out.println("Logged in successfully, displays: " + message);
    driver.close();
    }
	 
}
