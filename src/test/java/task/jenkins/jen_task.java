package task.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class jen_task {

    @Test
    public void testLogin() {
        // Set ChromeDriver path
        String chromeDriverPath = "C:\\Users\\sanja\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe";

        // Set Chrome options and set headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        // Create a new instance of the Chrome driver with options
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the Saucedemo login page
        driver.get("https://www.saucedemo.com/");

        // Enter username and password
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");

        // Click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify if login is successful
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("inventory.html")) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Login Failed!");
        }

        // Close the browser
        driver.quit();
    }
}
