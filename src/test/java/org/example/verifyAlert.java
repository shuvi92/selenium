package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class verifyAlert {

    WebDriver driver;

    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
        driver.manage().window().maximize();
    }

    @Test
            public void alert() throws InterruptedException {
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button")).isDisplayed());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // This  will scroll down the page by  1000 pixel vertical
        js.executeScript("window.scrollBy(0,400)");//input invalid email and hit enter key
        //SIMPLE ALERT
        driver.findElement(By.xpath("//*[@id='content']/p[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.accept();
    }

    @After
    public void quit(){driver.close();}
}
