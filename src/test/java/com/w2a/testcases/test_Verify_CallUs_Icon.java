package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test_Verify_CallUs_Icon extends TestBase {
    HomePage hp;
    LoginPage lp;
    MyAccountPage map;


    @Test
    public void verifyCallUsIcon() throws InterruptedException {
        hp = new HomePage(driver);
        Thread.sleep(2000);
        String aux = hp.getIconCallUs();
        Assert.assertEquals(aux, "Call us now: 0123-456-789");
        System.out.println("Se encontró el icono con la leyenda : "+aux+" en el Home");



    }
}
