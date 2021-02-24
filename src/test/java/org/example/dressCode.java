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

public class dressCode {
    WebDriver driver;
    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();
    }

    @Test
    public void sareeFind() throws InterruptedException{
        WebElement search_box = driver.findElement(By.id("search_query_top"));
        search_box.sendKeys("Saree");
        driver.findElement(By.name("submit_search")).click();
        Thread.sleep(3000);
        String msg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span")).getText();
        Assert.assertEquals(msg,"0 results have been found.");

    }

    @After
    public void quit(){driver.close();}
}
