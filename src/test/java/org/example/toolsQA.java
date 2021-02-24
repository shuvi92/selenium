package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class toolsQA {
    WebDriver driver;

    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
    }

    @Test
    public void alert() throws InterruptedException {
        String expectedHeader = "Selenium Practice Form";
        String actualHeader = driver.findElement(By.xpath("//*[@id=\"Blog1\"]/div/article/div/div/h3")).getText();
        Assert.assertEquals(expectedHeader,actualHeader);
       driver.findElement(By.cssSelector("#post-body-3077692503353518311 > div > div > div:nth-child(12) > input[type=text]")).sendKeys("Subhechha");
        driver.findElement(By.cssSelector("#post-body-3077692503353518311 > div > div > div:nth-child(15) > input[type=text]")).sendKeys("Shrestha");
        WebElement genderbutton = driver.findElement(By.xpath("//*[@id=\"sex-1\"]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", genderbutton);
        WebElement exprncebutton = driver.findElement(By.xpath("//*[@id=\"exp-4\"]"));
        jse.executeScript("arguments[0].click()", exprncebutton);

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        System.out.println(date1);
        driver.findElement(By.cssSelector("#datepicker")).sendKeys(date1);
        driver.findElement(By.cssSelector("#profession-0")).click();
        driver.findElement(By.cssSelector("#profession-1")).click();
        driver.findElement(By.cssSelector("#tool-0")).click();
        driver.findElement(By.cssSelector("#tool-2")).click();
        Select drpdown = new Select(driver.findElement(By.name("continents")));
        drpdown.selectByVisibleText("North America");
        driver.findElement(By.linkText("Click here to Download File")).click();

        WebElement uploadfoto = driver.findElement(By.id("photo"));
        uploadfoto.click();
        uploadfoto.sendKeys("C:\\Users\\18178\\OneDrive\\Pictures\\Screenshots\\subu.png");
        //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //Robot robot = new Robot();
        //robot.keyPress(KeyEvent.VK_ENTER);


        Thread.sleep(7000);


    }

    @After
    public void quit(){driver.close();}

    }
