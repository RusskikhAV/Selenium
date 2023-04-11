package ru.selenium.training.groupFive.homework8;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckCountrySorting extends TestBase {

    @Test
    public void firstTest() {
        String xpath = "//*[@id='content']//tr[@class='row']";
        List<WebElement> elementList = driver.findElements(By.xpath(xpath));


        List<String> countryList = new ArrayList<>();
        for (WebElement e : elementList) {
            String country = e.findElement(By.cssSelector("td:nth-child(5)")).getAttribute("textContent");
            countryList.add(country);
        }

        Assert.assertEquals(countryList.stream().sorted().collect(Collectors.toList()), countryList);
    }

    @Test
    public void secondTest() {
        String xpath = "//*[@id='content']//tr[@class='row']";
        List<WebElement> elementList = driver.findElements(By.xpath(xpath));
        for (WebElement e : elementList) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            String country = e.findElement(By.cssSelector("td:nth-child(5)")).getAttribute("textContent");
            int zone = Integer.parseInt(e.findElement(By.cssSelector("td:nth-child(6)")).getAttribute("textContent"));

            if (zone > 0) {
                System.out.println(country + "^" + zone);
                isCorrect(e);
            }
        }
    }

    private boolean isCorrect(WebElement e) {
        WebElement clickableElement = e.findElement(By.cssSelector("td:nth-child(5) a"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL).click(clickableElement).keyUp(Keys.LEFT_CONTROL).build().perform();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        List<WebElement> countryZoneList = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]"));

        List<String> zoneString = new ArrayList<>();
        for (WebElement webElement : countryZoneList) {
            zoneString.add(webElement.getAttribute("textContent"));
        }
        driver.close();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        return zoneString.stream().sorted().collect(Collectors.toList()).equals(zoneString);
    }
}