package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class sliderScroll {

    WebDriver driver;

    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @Test
    public void scroll() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        WebElement slider = driver.findElement(By.cssSelector("#layered_price_slider > div"));
        Actions move = new Actions(driver);
        Thread.sleep(5000);
        int method = 2;

        if(method == 1) {
            for (int i = 1 ; i < 53; i = i +10){
                Action action = move.dragAndDropBy(slider,i,0).build();
                action.perform();

            }
        }

        if (method == 2){
            move.dragAndDropBy(slider, 126, 0).build().perform();
        }
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.id("layered_price_range")).getText(),"$53.00 - $53.00");
    }

    @After
    public void quit(){driver.close();}

}

