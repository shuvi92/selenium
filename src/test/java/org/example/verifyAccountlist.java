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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class verifyAccountlist {
    WebDriver driver;
    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();
    }


    @Test
    public void verifyList() throws InterruptedException{
        List<WebElement> lists = new ArrayList<WebElement>();
        List<String> acc = new ArrayList<String>(Arrays.asList("My orders", "My credit slips", "My addresses", "My personal info"));
        lists = driver.findElements(By.cssSelector(".bullet>li"));
        List<String> str = new ArrayList<String>();
        for (WebElement list: lists){
            str.add(list.getText());
        }
        Assert.assertEquals(str,acc);
    }

    @After
    public void quit(){ driver.close();}
}
