package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.sql.Driver;

public class dragnDrop {
    WebDriver driver;

    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();
    }

    @Test
    public void alert() throws InterruptedException {
        //Drag the Bank block to Debit Side on Account [ Verify Debit movement 0,  Credit Movement 0]
        WebElement drag = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
        Actions act = new Actions(driver);
        act.dragAndDrop(drag,drop).build().perform();
        Thread.sleep(3000);
        String debit = driver.findElement(By.cssSelector("#t7")).getText();
        String credit = driver.findElement(By.cssSelector("#t8")).getText();
        Assert.assertEquals("0",debit);
        Assert.assertEquals("0",credit);
        Thread.sleep(3000);

        //Drag 5000 Block to Debit Side on Amount [verify Debit movement 5000,  Credit Movement 0]
        drag = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
        drop =driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
        act.dragAndDrop(drag,drop).build().perform();
        debit = driver.findElement(By.cssSelector("#t7")).getText();
        credit = driver.findElement(By.cssSelector("#t8")).getText();
        Assert.assertEquals("5000",debit);
        Assert.assertEquals("0",credit);
        Thread.sleep(3000);

        //Drag the Sales block to Credit Side on Account [ Verify Debit movement 0,  Credit Movement 0]
        drag = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
        drop =driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
        act.dragAndDrop(drag,drop).build().perform();
        debit = driver.findElement(By.cssSelector("#t7")).getText();
        credit = driver.findElement(By.cssSelector("#t8")).getText();
        Assert.assertEquals("5000",debit);
        Assert.assertEquals("0",credit);
        Thread.sleep(3000);

        //Drag the 5000 block to Credit Side on Account [ Verify Debit movement 0,  Credit Movement 5000] and Perfect Button is displayed
        drag = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
        drop =driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
        act.dragAndDrop(drag,drop).build().perform();
        debit = driver.findElement(By.cssSelector("#t7")).getText();
        credit = driver.findElement(By.cssSelector("#t8")).getText();
        String msg = driver.findElement(By.xpath("//*[@id=\"equal\"]/a")).getText();
        Assert.assertEquals("5000",debit);
        Assert.assertEquals("5000",credit);
        Assert.assertEquals("Perfect!",msg);
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

    @After
    public void quit(){driver.close();}
}
