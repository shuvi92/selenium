package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class takeScreenshot {
    @Test
    public void openBrowserfail() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.gmail.com");
        driver.manage().window().maximize();

        String expectedInbox = "Wrong password. Try again or click Forgot password to reset it.";
        String gmailUser = "sitashrestha9792@gmail.com";
        String gmailPassword = "123487";

        WebElement emailElement = driver.findElement(By.id("identifierId"));
        emailElement.sendKeys(gmailUser);
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(7000);
        WebElement pwElement = driver.findElement(By.name("password"));
        //String pw = "sammy979";
        pwElement.sendKeys(gmailPassword);
        driver.findElement(By.id("passwordNext")).click();

        Thread.sleep(3000);
        takeSnapShot(driver);

        Thread.sleep(3000);
        driver.close();
    }



    @Test
    public void openBrowserpass() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.gmail.com");
        driver.manage().window().maximize();

        String expectedInbox = "Wrong password. Try again or click Forgot password to reset it.";
        String gmailUser = "sitashrestha9792@gmail.com";
        String gmailPassword = "sammy9792";

        WebElement emailElement = driver.findElement(By.id("identifierId"));
        takeSnapShot(driver);
        emailElement.sendKeys(gmailUser);
        takeSnapShot(driver);
        driver.findElement(By.id("identifierNext")).click();
        takeSnapShot(driver);
        Thread.sleep(5000);
        WebElement pwElement = driver.findElement(By.name("password"));
        //String pw = "sammy979";
        pwElement.sendKeys(gmailPassword);
        takeSnapShot(driver);
        driver.findElement(By.id("passwordNext")).click();
        takeSnapShot(driver);
        Thread.sleep(5000);



        Thread.sleep(3000);
        driver.close();
    }


    public static void takeSnapShot (WebDriver driver) throws IOException{

        TakesScreenshot scrsht = ((TakesScreenshot) driver);

        File Srctfile = scrsht.getScreenshotAs(OutputType.FILE);
        Random r = new Random();

        int rand = r.nextInt(1000);

        String filePth = System.getProperty("user.dir")+ "\\Screens";

        File file = new File(filePth + "\\"+ rand+ "_shot.jpeg");

        FileUtils.copyFile(Srctfile,file);
    }


}
