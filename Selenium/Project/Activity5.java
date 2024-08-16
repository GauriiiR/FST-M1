package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.Select;


public class Activity5 {
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
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();	
		String message0 = driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1")).getText();
	    System.out.println("on Emplyee info add page: " + message0);
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("hibiscus5change");
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("test3change");
		driver.findElement(By.xpath("//*[@id=\"frmEmpPersonalDetails\"]/fieldset/ol[3]/li[1]/ul/li[2]/label")).click();
		Select dropdown = new Select(driver.findElement(By.id("personal_cmbNation")));
		dropdown.selectByVisibleText("Angolan ");
		driver.findElement(By.id("btnSave")).click();
	}
	
	 @AfterClass
		public void Aftercalss() {
			driver.quit();	
		}
}
