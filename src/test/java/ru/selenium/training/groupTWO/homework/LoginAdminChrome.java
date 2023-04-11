package ru.selenium.training.groupTWO.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAdminChrome {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-fullscreen");
        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void loginToAdminPanel() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        //wait.until(ExpectedConditions.titleIs("Dashboard | My Store"));
        //System.out.println(((HasCapabilities)driver).getCapabilities());
    }

    @After
    public void stop() {
        //driver.quit();
        //driver = null;
    }
}
