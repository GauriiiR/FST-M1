package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity2 {
	@Test
	public void TestMethod2() {
	WebDriver driver = new FirefoxDriver();
	driver.get("http://alchemy.hguy.co/orangehrm");
	//WebElement i = driver.findElement(By.id("divLogin"));
	WebElement i = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img"));
	String src = i.getAttribute("src");
	System.out.println("Src attribute is: " +src);
	driver.close();
 }
}
