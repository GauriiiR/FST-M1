package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
	
public class Activity8 {
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
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/span")).click();
	Select dropdown = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
	dropdown.selectByVisibleText("DayOff");
	driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2024-08-25");
	driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2024-08-30");
	driver.findElement(By.id("applyBtn")).click();
}

@AfterClass
public void Aftercalss() {
	driver.quit();	
}

}

