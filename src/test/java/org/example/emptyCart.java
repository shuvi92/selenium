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

public class emptyCart {
    WebDriver driver;
    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();
    }

    @Test
    public void cartCheck() throws InterruptedException{
        WebElement empty_cart = driver.findElement(By.cssSelector(".ajax_cart_no_product"));
        String msg = empty_cart.getText();
        Assert.assertEquals(msg,"(empty)");

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
        Thread.sleep(3000);
        String cart_msg = driver.findElement(By.cssSelector(".alert.alert-warning")).getText();
        Assert.assertEquals(cart_msg,"Your shopping cart is empty.");


    }

    @After
    public void quit(){driver.quit();}
}
