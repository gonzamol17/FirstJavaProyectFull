package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test_Verify_CartEmptyIcon extends TestBase {
    HomePage hp;
    LoginPage lp;
    MyAccountPage map;


    @Test
    public void verifyCartEmptyIcon() throws InterruptedException {
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        hp.selectLoginBtn();
        Thread.sleep(2000);
        lp.makeLogin("gonza_mol@hotmail.com", "Maestruli10");
        map = new MyAccountPage(driver);
        String aux = map.getTextBtnCart();
        Assert.assertTrue(aux.contains("empty"));
        //estos dos assert hacen lo mismo, uno es con equals y el otro usando
        //el metodo contains me devuelve true, y ahi uso assertTrue
        //Assert.assertEquals(aux, "Cart (empty)");
        System.out.println("El carrito de compra está vacío");



    }
}
