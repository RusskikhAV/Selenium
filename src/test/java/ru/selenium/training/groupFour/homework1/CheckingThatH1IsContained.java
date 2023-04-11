package ru.selenium.training.groupFour.homework1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class CheckingThatH1IsContained extends TestBase {

    @Test
    public void firstTest() {
        driver.findElement(By.xpath("//li[@id='app-'][1]")).click();
        driver.findElement(By.id("doc-template")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("#content > h1")));
    }

    @Test
    public void secondTest() {
        driver.findElement(By.xpath("//li[@id='app-'][1]")).click();
        driver.findElement(By.id("doc-logotype")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("#content > h1")));
    }

    @Test
    public void thirdTest() {
        driver.findElement(By.xpath("//li[@id='app-'][2]")).click();
        driver.findElement(By.id("doc-catalog")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("#content > h1")));
    }

    @Test
    public void fourthTest() {
        driver.findElement(By.xpath("//li[@id='app-'][2]")).click();
        driver.findElement(By.id("doc-product_groups")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("#content > h1")));
    }
}
