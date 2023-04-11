package ru.selenium.training.groupFive.homework10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyThatTheCorrectProductPageOpens extends TestBase {

    @Test
    public void firstTest() {
        WebElement currentElementOnMainPage = driver
                .findElement(By.xpath("//div[@id='box-campaigns']//li"));
        String productNameOnMainPage = currentElementOnMainPage
                .findElement(By.cssSelector("div.name"))
                .getAttribute("textContent");
        String manufacturerOnNameMainPage = currentElementOnMainPage
                .findElement(By.cssSelector("div.manufacturer"))
                .getAttribute("textContent");

        currentElementOnMainPage.click();
        WebElement currentElementOnProductPage = driver.findElement(By.xpath("//div[@id='box-product']"));
        String productNameOnProductPage = currentElementOnProductPage
                .findElement(By.cssSelector("h1.title"))
                .getAttribute("textContent");
        String manufacturerOnNameProductPage = currentElementOnProductPage
                .findElement(By.cssSelector("div.manufacturer > a > img"))
                .getAttribute("title");
        Assert.assertEquals(productNameOnMainPage, productNameOnProductPage);
        Assert.assertEquals(manufacturerOnNameMainPage, manufacturerOnNameProductPage);
    }

    @Test
    public void secondTest() {
        WebElement currentElementOnMainPage = driver
                .findElement(By.xpath("//div[@id='box-campaigns']//li"));
        String regularPriceOnMainPage = currentElementOnMainPage
                .findElement(By.cssSelector("s.regular-price"))
                .getAttribute("textContent");

        String campaignPriceOnMainPage = currentElementOnMainPage
                .findElement(By.cssSelector("strong.campaign-price"))
                .getAttribute("textContent");

        currentElementOnMainPage.click();
        WebElement currentElementOnProductPage = driver.findElement(By.xpath("//div[@id='box-product']"));
        String regularPriceOnProductPage = currentElementOnProductPage
                .findElement(By.cssSelector("s.regular-price"))
                .getAttribute("textContent");

        String campaignPriceOnProductPage = currentElementOnProductPage
                .findElement(By.cssSelector("strong.campaign-price"))
                .getAttribute("textContent");

        Assert.assertEquals(regularPriceOnProductPage, regularPriceOnMainPage);
        Assert.assertEquals(campaignPriceOnMainPage, campaignPriceOnProductPage);
    }

    @Test
    public void thirdTest() {
        WebElement currentElementOnMainPage = driver
                .findElement(By.xpath("//div[@id='box-campaigns']//li"));
        String regularPrice = currentElementOnMainPage
                .findElement(By.cssSelector("s.regular-price")).getCssValue("color");

        List<String> list = new ArrayList<>(Arrays.asList(regularPrice.split(" ")));

        for (String s : list) {
            s = s.replace("rgba", "");
            s = s.replace("(", "");
            s = s.replace(")", "");
            s = s.replace(",", "");
        }

        String r = list.get(0);
        String g = list.get(1);
        String b = list.get(2);

        Assert.assertEquals(r, g, b);

        String textDecorationLine = currentElementOnMainPage
                .findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line");

        Assert.assertEquals("line-through", textDecorationLine);
    }

    @Test
    public void fourthTest() {
        WebElement currentElementOnMainPage = driver
                .findElement(By.xpath("//div[@id='box-campaigns']//li"));
        String campaignPriceOnMainPage = currentElementOnMainPage
                .findElement(By.cssSelector("strong.campaign-price"))
                .getCssValue("color");
        System.out.println(campaignPriceOnMainPage);
        List<String> list = new ArrayList<>(Arrays.asList(campaignPriceOnMainPage.split(" ")));

        for (String s : list) {
            s = s.replace("rgba", "");
            s = s.replace("(", "");
            s = s.replace(")", "");
            s = s.replace(",", "");
        }

        String g = list.get(1);
        String b = list.get(2);

        Assert.assertEquals(g, b);


        String campaignPriceOnMainPageFrontWeight = currentElementOnMainPage
                .findElement(By.cssSelector("strong.campaign-price"))
                .getCssValue("font-weight");
        int fontWeight = Integer.parseInt(campaignPriceOnMainPageFrontWeight);

        Assert.assertTrue(fontWeight > 500);
    }

    @Test
    public void fifthTest() {
        WebElement currentElementOnMainPage = driver
                .findElement(By.xpath("//div[@id='box-campaigns']//li"));
        String campaignPriceOnMainPage = currentElementOnMainPage
                .findElement(By.cssSelector("strong.campaign-price"))
                .getCssValue("font-weight");
        int fontWeight = Integer.parseInt(campaignPriceOnMainPage);

        Assert.assertTrue(fontWeight > 500);
    }
}
