package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class imageHandling {
    WebDriver driver;
    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);
    }


    @Test
    public void image() throws InterruptedException{
       driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        driver.findElement(By.className("icon-th-large")).click();
        Thread.sleep(5000);
        driver.findElements(By.cssSelector(".replace-2x.img-responsive")).get(4).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        int noIcons=driver.findElements(By.cssSelector("#thumbs_list_frame>li")).size();
        Thread.sleep(5000);
        driver.findElement(By.id("bigpic")).click();
        driver.findElement(By.id("bigpic")).click();
        Thread.sleep(3000);
        // wd.switchTo().frame(0);
        for (int i=1;i<noIcons;i++) {
            WebElement nextArrow=driver.findElement(By.cssSelector(".fancybox-nav.fancybox-next"));
            nextArrow.click();
            Thread.sleep(3000);
        }
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".fancybox-item.fancybox-close")).click();
        Thread.sleep(3000);






    }





    @After
    public void sleep(){driver.close();}


}
