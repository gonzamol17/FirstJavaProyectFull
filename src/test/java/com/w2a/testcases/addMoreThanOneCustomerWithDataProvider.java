package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.AddCustomerPage;
import com.w2a.executables.BankManagerPage;
import com.w2a.executables.LandingPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtilis;

import java.io.FileInputStream;
import java.util.Properties;

public class addMoreThanOneCustomerWithDataProvider extends TestBase {




        @Test(dataProvider = "getData")
        public void test1(String name, String lname, String postal) throws InterruptedException {
            LandingPage lp;
            BankManagerPage bm;
            AddCustomerPage ac;
            Alert alert;
            lp = new LandingPage(driver);
            bm = new BankManagerPage(driver);
            ac = new AddCustomerPage(driver);
            lp.selectBtnBankManagerLogin();
            Thread.sleep(3000);
            bm.selectBtnAddCustomer();
            Thread.sleep(3000);
            ac.setFirstName(name);
            Thread.sleep(2000);
            ac.setLastName(lname);
            Thread.sleep(2000);
            ac.setPostCode(postal);
            Thread.sleep(2000);
            ac.btnAddCustomer();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            Thread.sleep(2000);
            System.out.println("Customer Name " + name);
            ac.btnGoHome();
            Thread.sleep(2000);

        }


        @DataProvider
        public Object[][] getData() {
            String excelPath = System.getProperty("user.dir")+"\\src\\test\\java\\excel\\addCustomerTest.xlsx";
            ExcelUtilis excel = new ExcelUtilis(excelPath, "addCustomerTest");
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
}
