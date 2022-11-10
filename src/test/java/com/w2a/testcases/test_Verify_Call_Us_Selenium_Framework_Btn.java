package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;
import com.w2a.executables.SeleniumFrameworkPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test_Verify_Call_Us_Selenium_Framework_Btn extends TestBase {

    HomePage hp;
    LoginPage lp;
    MyAccountPage map;
    JavascriptExecutor jse;
    SeleniumFrameworkPage sf;


    @Test
    public void verifyCallUsSeleniumFrameworkBtn() throws InterruptedException {
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        map = new MyAccountPage(driver);
        hp.selectLoginBtn();
        Thread.sleep(2000);
        lp.makeLogin("gonza_mol@hotmail.com", "Maestruli10");
        map.GoHomePage();
        jse = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,500)");
        Assert.assertTrue(hp.getCallUsLeyend());
        hp.selectBtnSeleniumFramework();
        sf = new SeleniumFrameworkPage(driver);
        Assert.assertTrue(sf.getTitleOfPage());
        System.out.println("Se está en la página de: "+ driver.getCurrentUrl());
        Thread.sleep(2000);
    }
}
