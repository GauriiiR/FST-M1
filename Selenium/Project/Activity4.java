package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver = new FirefoxDriver();

	@BeforeClass
	public void BeforeClass() {
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	}
	
	@Test
	public void Addtest() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		String message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
	    System.out.println("Logged in successfully, displays: " + message);
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();	
		String message0 = driver.findElement(By.xpath("//*[@id=\"employee-information\"]/a")).getText();
	    System.out.println("on Emplyee info add page: " + message0);
		driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
		driver.findElement(By.id("firstName")).sendKeys("hibiscus5");
		driver.findElement(By.id("lastName")).sendKeys("test3");
		driver.findElement(By.id("btnSave")).click();
		String message1 = driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1")).getText();
	    System.out.println("on Emplyee view info: " + message1);
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		String message3 = driver.findElement(By.xpath("//*[@id=\"employee-information\"]/a")).getText();
	    System.out.println("Emp search info: " + message3);
	    driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("hibiscus5 test3");
	    driver.findElement(By.id("searchBtn")).click();
	    String message4 = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[3]/a")).getText();
	    System.out.println("Emp search info: " + message4);
	}
	
	 @AfterClass
	public void Aftercalss() {
		driver.quit();	
	}
}
