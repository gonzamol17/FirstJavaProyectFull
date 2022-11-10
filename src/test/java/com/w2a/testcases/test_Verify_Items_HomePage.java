package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test_Verify_Items_HomePage extends TestBase {

    HomePage hp;
    LoginPage lp;
    MyAccountPage map;


    @Test
    public void verifyItemsHomePage() throws InterruptedException {
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        hp.selectLoginBtn();
        Thread.sleep(2000);
        lp.makeLogin("gonza_mol@hotmail.com", "Maestruli10");
        map = new MyAccountPage(driver);
        log.info("Ver si esto se visualiza en algún lado");
        Assert.assertEquals(map.getNumberOfMenuItems(),4);
        log.info("Ver si esto se visualiza en algún lado posterior");
        System.out.println("La cantidad de items mostrados en el home es: "+map.getNumberOfMenuItems());
        System.out.println("Y son los siguientes:");
        map.getMenuItems();
        map.selectSignOut();
        Assert.assertTrue(hp.getLinkSignOut());
        System.out.println("El usuario está deslogueado");


    }
}
