package com.w2a.testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtilis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ExampleDataPro2fromExcelFile {

    public WebDriver driver;
    public Properties properties = new Properties();
    public FileInputStream inputStream;


    @Test(dataProvider = "getData")
    public void test1(String customer, String currency) {
        System.out.println("Customer "+customer+" And Currency "+currency);

    }


    @DataProvider
    public Object[][] getData() {
        String excelPath = System.getProperty("user.dir")+"\\src\\test\\java\\excel\\testdata.xlsx";
        ExcelUtilis excel = new ExcelUtilis(excelPath, "OpenAccountTest");
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();
        Object data[][] = new Object[rowCount - 1][colCount];
        for (int i=1; i<rowCount; i++) {
            for (int j=0; j<colCount; j++) {
                String cellData = excel.getCellDataString(i, j);
                data[i-1][j] = cellData;

            }
        }

        return data;

    }

/*

    @DataProvider
    public Object[][] getData() {
        String excelPath = "C:\\Users\\User\\Desktop\\Automation\\Selenium webdriver with java-Basics to Advanced+Frameworks\\DataDrivenFramework\\src\\test\\java\\excel\\testdata.xlsx";
        Object[][] data = testData(excelPath, "OpenAccountTest");
        return data;

    }
*/

    /*public Object[][] testData(String excelPath, String sheetName) {

        ExcelUtilis excel = new ExcelUtilis(excelPath, sheetName);
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount - 1][colCount];
        for (int i=1; i<rowCount; i++) {
            for (int j=0; j<colCount; j++) {
                String cellData = excel.getCellDataString(i, j);
                data[i-1][j] = cellData;

            }
        }
     return data;
    }*/
}
