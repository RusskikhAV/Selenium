package ru.selenium.training.groupFour.homework2;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestBase {
    public static WebDriver driver;

    @Before
    public void start() {
        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost/litecart");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {driver.quit(); driver = null; }));
    }
    @After
    public void stop() {
//        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='box-most-popular']//li"));
//
//        for (int i = 0; i < elements.size(); i++) {
//            String name = elements.get(i).toString();
//            WebElement element = elements.get(i).findElement(By.xpath("//div[@class='sticker new']"));
//            System.out.println(element);
//        }

        //driver.quit();
        //driver = null;
        ////li[@class='product column shadow hover-light']
        //*[@class='sticker new' or @class='sticker sale']
    }
}
