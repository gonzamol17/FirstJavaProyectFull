package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.AddCustomerPage;
import com.w2a.executables.BankManagerPage;
import com.w2a.executables.LandingPage;
import com.w2a.executables.OpenAccountPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtilis;

import java.io.FileInputStream;
import java.util.Properties;

public class addCustomerandCurrency extends TestBase {

    //public WebDriver driver;
    public Properties properties = new Properties();
    public FileInputStream inputStream;


    @Test()
    public void addAllCustomerAndCurrency() throws InterruptedException {

        OpenAccountPage OAP;
        LandingPage LP;
        BankManagerPage BMP;
        AddCustomerPage AP;
        OAP = new OpenAccountPage(driver);
        LP = new LandingPage(driver);
        BMP = new BankManagerPage(driver);
        AP = new AddCustomerPage(driver);
        Thread.sleep(2000);
        LP.selectBtnBankManagerLogin();
        Thread.sleep(2000);
        BMP.selectBtnOpenAccount();

        try {
            OAP.setDropDownCustomer();

        } catch(NoAlertPresentException noe) {

            noe.printStackTrace();
            System.out.println("No se visualizó ningún pop up");

        }
        Thread.sleep(2000);

        }





}