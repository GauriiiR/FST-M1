package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver = new FirefoxDriver();
	@BeforeClass
	public void BeforeClass() {
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	}
	
	@Test
	public void test() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		String message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
	    System.out.println("Logged in successfully, displays: " + message);
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();	
		String message0 = driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1")).getText();
	    System.out.println("on Emplyee info add page: " + message0);
		driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[9]/a")).click();
		driver.findElement(By.id("addWorkExperience")).click();
		driver.findElement(By.id("experience_employer")).sendKeys("IBM1");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Testing1");
		driver.findElement(By.id("btnWorkExpSave")).click();
	}
	
	
	 @AfterClass
		public void Aftercalss() {
			driver.quit();	
		}
}
