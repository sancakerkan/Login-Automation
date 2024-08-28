package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class FirefoxLoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
    }

    @Test
    public void testCorrectLogin() {
        URL loginUrl = getClass().getResource("/login.html");
        driver.get(loginUrl.toString());

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        username.sendKeys("user");
        password.sendKeys("password");
        loginButton.click();

        // Log the current URL before waiting for the redirection
        System.out.println("Current URL after login attempt: " + driver.getCurrentUrl());

        // Wait for the success message
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success")));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message should be displayed.");

        // Wait for 2 seconds before navigating to the home page
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        URL homeUrl = getClass().getResource("/home.html");
        driver.get(homeUrl.toString());

        // Wait for the URL to change to the home page
        boolean isRedirected = wait.until(ExpectedConditions.urlContains("home.html"));
        Assert.assertTrue(isRedirected, "Should be redirected to a URL containing 'home.html'.");

        // Normalize URLs by removing "file:///" or "file:/"
        String expectedUrl = homeUrl.toString().replace("file:/", "file:///");  // Normalize to match the format
        String actualUrl = driver.getCurrentUrl();

        // Verify the final URL
        Assert.assertEquals(actualUrl, expectedUrl, "Should be redirected to home page.");

        // Wait for 3 seconds before ending the test
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIncorrectLogin() {
        URL loginUrl = getClass().getResource("/login.html");
        driver.get(loginUrl.toString());

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        username.sendKeys("wronguser");
        password.sendKeys("wrongpassword");
        loginButton.click();

        // Wait for the error message
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed.");

        // Wait for 2 seconds before ending the test
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
