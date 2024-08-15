package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/popups");
		System.out.println("Title is: " + driver.getTitle());
		
		//wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		
		
		WebElement button = driver.findElement(By.className("orange"));
		action.moveToElement(button).build().perform();

        String tooltipMessage = button.getAttribute("data-tooltip");
        System.out.println(tooltipMessage);

        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        WebElement user = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("password"));
       
        user.sendKeys("admin");
        pass.sendKeys("password");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("confirmations message: " + message);

        driver.quit();
	
	}

}
