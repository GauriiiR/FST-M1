from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/login-form")
    # title of the page
    print("Page title is: ", driver.title)

    # username field
    username = driver.find_element(By.XPATH, "//input[@id='username']")
    # password field
    password = driver.find_element(By.XPATH, "//input[@id='password']")

    # username
    username.send_keys("admin")
    # password
    password.send_keys("password")

    login = driver.find_element(By.XPATH, "//button[@type='submit']") 
    login.click()

    message = driver.find_element(By.XPATH, "//div[@id='action-confirmation']")
    print("Login message: ", message.text)
