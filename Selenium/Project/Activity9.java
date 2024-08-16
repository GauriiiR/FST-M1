package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Activity9 {
	WebDriver driver = new FirefoxDriver();
	List<WebElement> rows;
	List<WebElement> col;
	int rws_cnt,col_cnt;


@BeforeClass
public void BeforeClass() {
	driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
}

@Test
public void dirtest() {
	
	driver.findElement(By.id("txtUsername")).sendKeys("orange");
	driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	driver.findElement(By.id("btnLogin")).click();
	String message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
    System.out.println("Logged in successfully, displays: " + message);
    driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();	
	String message0 = driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1")).getText();
    System.out.println("now on emergency contact page, text is : " + message0);
    driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[3]/a")).click();
    WebElement t = driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]"));
    List<WebElement> rows = t.findElements(By.tagName("tr"));
    int rws_cnt = rows.size();
    for (int i = 0;i < rws_cnt; i++) {
    	List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
    	 int col_cnt = col.size();
    	  for (int j = 0;j < col_cnt; j++) {
    		   String c = col.get(j).getText();
    		   System.out.println("cell value: " + c);
    	  }
    	  }
            }

@AfterClass
	public void Aftercalss() {
		driver.quit();	
	}

}
