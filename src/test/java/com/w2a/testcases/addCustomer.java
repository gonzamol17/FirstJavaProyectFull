package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.AddCustomerPage;
import com.w2a.executables.BankManagerPage;
import com.w2a.executables.LandingPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class addCustomer extends TestBase {


    @Test
    public void verifyPopUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\DataDrivenFramework\\src\\test\\java\\utilities\\chromedriver.exe");
        LandingPage lp;
        BankManagerPage bm;
        AddCustomerPage ac;
        lp = new LandingPage(driver);
        bm = new BankManagerPage(driver);
        ac = new AddCustomerPage(driver);
        lp.selectBtnBankManagerLogin();
        Thread.sleep(3000);
        bm.selectBtnAddCustomer();
        Thread.sleep(3000);
        ac.setFirstName("Gonza");
        Thread.sleep(2000);
        ac.setLastName("Malcovich");
        Thread.sleep(2000);
        ac.setPostCode("5000");
        Thread.sleep(2000);
        ac.btnAddCustomer();
        Thread.sleep(2000);
        try {

            Alert alt = driver.switchTo().alert();
            System.out.println("El customer fue agregado");
            System.out.println("Se visualizó un pop de alerta y dice " + alt.getText());
            Assert.assertTrue(alt.getText().contains("Customer added successfully with customer id"));
            alt.accept();
        } catch(NoAlertPresentException noe) {

            noe.printStackTrace();
            System.out.println("No se visualizó ningún pop up");
            System.out.println("Y se pudo agregar el usuario");
        }

    }





}
