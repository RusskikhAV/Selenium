package ru.selenium.training.groupFive.homework8;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver;
    private final static String login = "admin";
    private final static String password = "admin";

    @Before
    public void start() {
        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        //Runtime.getRuntime().addShutdownHook(new Thread(() -> {driver.quit(); driver = null; }));
    }

    @After
    public void stop() {
        //driver.quit();
        //driver = null;
    }
}
