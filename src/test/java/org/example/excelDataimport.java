package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class excelDataimport {
    WebDriver driver;

    @Test
    public void test() throws IOException, InterruptedException {
        File f = new File("C:\\Users\\18178\\OneDrive\\Desktop\\job\\automation.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook excelWorkbook = new XSSFWorkbook(fis);
        XSSFSheet excelSheet = excelWorkbook.getSheetAt(0);
        int rows = excelSheet.getPhysicalNumberOfRows();//3
        int cols = excelSheet.getRow(0).getPhysicalNumberOfCells();//2
       String data[][] = new String[rows][cols];
        XSSFCell cell;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols;j++)
            {
               cell = excelSheet.getRow(i).getCell(j);
               String celldata = cell.getStringCellValue();
               data[i][j] = celldata;
            }
        }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(data[0][1]);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(data[1][1]);
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("password")).sendKeys(data[2][1]);
        driver.findElement(By.id("passwordNext")).click();

        Thread.sleep(7000);
    }

    @After
    public void quit(){driver.close();}
}


