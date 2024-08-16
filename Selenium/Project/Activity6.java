package project;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Activity6 {
	WebDriver driver = new FirefoxDriver();

	@BeforeClass
	public void BeforeClass() {
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	}
	
	public void dirtest() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		String message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
	    System.out.println("Logged in successfully, displays: " + message);
		driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]/b")).click();	
		String message0 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a")).getText();
		System.out.println("in directory page:header text actual : " + message0);
	    String Actualtext = "Search Directory";
	    assertEquals(message0, Actualtext);
	}

	
	 @AfterClass
	public void Aftercalss() {
		driver.quit();	
	}
}
