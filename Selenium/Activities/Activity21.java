package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/tab-opener");
		System.out.println("Title is: " + driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
        System.out.println("Original tab :" + driver.getWindowHandle());
        driver.findElement(By.id("launcher")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("new open windows :" + driver.getWindowHandles());
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        System.out.println("Original tab: " + driver.getWindowHandle());
        System.out.println("Page title: " + driver.getTitle());
        String pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);
        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        System.out.println("Current tab: " + driver.getWindowHandle());
        System.out.println("Page title: " + driver.getTitle());
        pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);
        driver.quit();
			
	}

}
