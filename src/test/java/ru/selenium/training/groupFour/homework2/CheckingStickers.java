package ru.selenium.training.groupFour.homework2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckingStickers extends TestBase {

    @Test
    public void firstTest() {
        String xpath =
                "//li[@class='product column shadow hover-light']//div[@class='sticker new' or @class='sticker sale']";
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        for (WebElement element : elements) {
            String elementAttribute = element.getAttribute("title");
            Assert.assertTrue(elementAttribute.equals("New") || elementAttribute.equals("On Sale"));
        }
    }
}
//div[@id='box-most-popular']//div[@class='sticker new' or @class='sticker sale']