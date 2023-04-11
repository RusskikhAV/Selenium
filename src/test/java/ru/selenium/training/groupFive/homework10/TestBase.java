package ru.selenium.training.groupFive.homework10;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost/litecart");

        //Runtime.getRuntime().addShutdownHook(new Thread(() -> {driver.quit(); driver = null; }));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
