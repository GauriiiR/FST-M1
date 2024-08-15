package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity5 {
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("User is Present on Login pages")
    public void login_Page() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    
 
    @When("User intert {string} and {string}")
    public void user_enters_and(String username, String password) throws Throwable {
       
        driver.findElement(By.id("username")).sendKeys(username);
       
        driver.findElement(By.id("password")).sendKeys(password);
      
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    
    @Then("Captured page title and heading")
    public void readTitle_Heading() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        
       
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);
        
        if(confirmMessage.contains("admin")) {
            Assert.assertEquals(confirmMessage, "Welcome Back, admin");
        } else {
            Assert.assertEquals(confirmMessage, "Invalid Credentials");
        }
    }
    
    @And("quite the Browser")
    public void quitBrowser() {
        driver.close();
    }
}
