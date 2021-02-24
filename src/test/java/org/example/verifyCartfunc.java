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
import org.openqa.selenium.support.ui.Select;

public class verifyCartfunc {
    WebDriver driver;
    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();
    }


    @Test
    public void cartFunc() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        driver.findElement(By.className("icon-th-large")).click();
        Thread.sleep(5000);
        driver.findElements(By.cssSelector(".replace-2x.img-responsive")).get(4).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        Thread.sleep(5000);
        driver.findElement(By.id("bigpic")).click();
        Thread.sleep(7000);
        driver.findElement(By.cssSelector(".icon-plus")).click();
        driver.findElement(By.cssSelector(".icon-plus")).click();

        Select drpdwn = new Select(driver.findElement(By.xpath("//*[@id=\"group_1\"]")));
        drpdwn.selectByVisibleText("L");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        Thread.sleep(5000);

        String size = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_attributes\"]")).getText();
        String[] arrOfStr = size.split(",");
        Assert.assertEquals(arrOfStr[1]," L");
        String qtty = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_quantity\"]")).getText();
        Assert.assertEquals(qtty,"3");
        String total = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/span")).getText();
        Assert.assertEquals(total,"$93.50");

        driver.switchTo().defaultContent();
        Thread.sleep(7000);



    }

    @After
    public void sleep(){driver.close();}

}
