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

public class newsLetter {
    WebDriver driver;
    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();
    }


    @Test
    public void bademail() throws InterruptedException{

        WebElement email_entry = driver.findElement(By.xpath("//*[@id=\"newsletter-input\"]"));
        email_entry.sendKeys("swexastha1@gmail");
        driver.findElement(By.name("submitNewsletter")).click();
        Thread.sleep(3000);
        String msg = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals(msg,"Newsletter : Invalid email address.");

    }

    @Test
    public void happypath() throws InterruptedException{

        WebElement email_entry1 = driver.findElement(By.xpath("//*[@id=\"newsletter-input\"]"));
        email_entry1.sendKeys("mayamutu66@gmail.com");
        driver.findElement(By.name("submitNewsletter")).click();
        Thread.sleep(3000);
        String msg = driver.findElement(By.cssSelector("#columns > p")).getText();
        Assert.assertEquals(msg,"Newsletter : You have successfully subscribed to this newsletter.");

    }

    @After
    public void quit(){driver.close();}
}
