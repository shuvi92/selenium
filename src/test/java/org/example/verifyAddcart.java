package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class verifyAddcart
{
    WebDriver driver;
    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();

    }


    @Test
    public void addTocart() throws InterruptedException{

        driver.findElements(By.cssSelector(".replace-2x.img-responsive")).get(2).click();
        Thread.sleep(5000);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);
        driver.switchTo().frame(1);
        Thread.sleep(5000);
        driver.findElement(By.id("bigpic")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")).click();
        Thread.sleep(3000);
        String cart_qtty = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")).getText();
        Assert.assertEquals(cart_qtty,"1");
        Thread.sleep(3000);
    }


    @After
    public void quit(){driver.close();}
}
