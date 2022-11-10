package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test_Verify_Green_Color_UserNameBox extends TestBase {

    HomePage hp;
    LoginPage lp;


    @Test
    public void verifyGreenColorEmailBox() throws InterruptedException {
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        Thread.sleep(2000);
        hp.selectLoginBtn();
        Thread.sleep(2000);
        lp.completeEmailBox("gonza_mol@hotmail.com");
        Thread.sleep(2000);
        Assert.assertTrue(lp.getColorEmailBox().contains("rgb(221, 249, 225)"));
        System.out.println("En el box de Email se está visualizando el color verde");
        Thread.sleep(2000);
        driver.get("http://automationpractice.com/index.php");





    }



}