package com.cepheid.training.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

// Starting point: only the happy-path login test exists. Participants must
// add missing scenarios (empty fields, navigation to dashboard, etc.)
public class LoginPageTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
    }

    @Test
    public void loginFormAcceptsCredentials() {
        driver.get(TestConfig.pageUrl("login.html"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("trainee1");
        password.sendKeys("Training@123");
        // Minimal assertion only -- participants should add more coverage.
        assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
