package ru.selenium.training.groupTHREE;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestWithEdge {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void myFirstTest() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
        wait.until(ExpectedConditions.titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
