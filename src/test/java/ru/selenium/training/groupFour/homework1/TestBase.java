package ru.selenium.training.groupFour.homework1;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver;

    public boolean isElementPresent(By locator) {
        driver.findElement(locator);
        return true;
    }

    @Before
    public void start() {
        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {driver.quit(); driver = null; }));
    }
    @After
    public void stop() {
        WebElement element1 = driver.findElement(By.cssSelector("#content > h1"));
        System.out.println(element1.getAccessibleName());
        //driver.quit();
        //driver = null;
    }
}
