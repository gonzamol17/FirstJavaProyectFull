package com.w2a.testcases;

import base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.executables.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    //LandingPage lp;
    //BankManagerPage logp;
    //public WebDriver driver;
    HomePage hp;
    LoginPage lp;
    MyAccountPage map;

    @Test
    public void loginSuccess() throws InterruptedException {
    hp = new HomePage(driver);
    lp = new LoginPage(driver);
    hp.selectLoginBtn();
    Thread.sleep(2000);
    lp.makeLogin("gonza_mol@hotmail.com", "Maestruli10");
    map = new MyAccountPage(driver);
    String username = map.getUserName();
    Assert.assertEquals(username, "Gonzalo Molina");
    System.out.println("El usuario que aparece logueado es: "+ username);
    Thread.sleep(3000);
  }

    @Test
    public void loginFailedWithoutEmail() throws InterruptedException {
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        hp.selectLoginBtn();
        Thread.sleep(2000);
        lp.makeLogin("", "Maestruli10");
        Thread.sleep(3000);
        String alert = lp.verifyRedAlert().getText();
        System.out.println(alert);
        Thread.sleep(3000);
        Assert.assertTrue(alert.contains("An email address required."));
    }


    @Test
    public void loginFailedWithoutPassword() throws InterruptedException {
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        hp.selectLoginBtn();
        Thread.sleep(2000);
        lp.makeLogin("gonza_mol@hotmail.com", "");
        Thread.sleep(3000);
        String alert = lp.verifyRedAlert().getText();
        System.out.println(alert);
        Assert.assertTrue(alert.contains("Password is required."));
    }

}