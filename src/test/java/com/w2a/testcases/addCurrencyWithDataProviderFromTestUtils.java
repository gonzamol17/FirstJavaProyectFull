package com.w2a.testcases;
import base.TestBase;
import com.w2a.executables.AddCustomerPage;
import com.w2a.executables.BankManagerPage;
import com.w2a.executables.LandingPage;
import com.w2a.executables.OpenAccountPage;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtilis;
import utilities.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class addCurrencyWithDataProviderFromTestUtils extends TestBase {


        public WebDriver driver;
        public Properties properties = new Properties();
        public FileInputStream inputStream;


        @Test(dataProviderClass = TestUtil.class, dataProvider = "getUtilData")
        public void test1(String customer, String currency) throws InterruptedException {

           System.out.println("Customer "+customer+" And Currency "+currency);


        }

            //Este test está usando el Data provider, que está en la clase TestUtil
        //Dentro del package Utilities, o sea que podemos reutilizar el data provider
        //sin necesidad de reescribir varias veces el método del data provider
        //Esto es posible ya que dentro del @Test(estamos haciendo referencia donde
        // está el data provider)
    }
