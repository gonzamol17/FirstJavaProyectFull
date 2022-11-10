package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;
import com.w2a.executables.ShoppingCartSummaryPage;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test_Verify_CartEmptyBannerAndColor extends TestBase {
    HomePage hp;
    LoginPage lp;
    MyAccountPage map;
    ShoppingCartSummaryPage scs;


    @Test
    public void verifyCartEmptyBannerAndColor() throws InterruptedException {
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        hp.selectLoginBtn();
        Thread.sleep(2000);
        lp.makeLogin("gonza_mol@hotmail.com", "Maestruli10");
        map = new MyAccountPage(driver);
        map.selectbtnCart();
        scs = new ShoppingCartSummaryPage(driver);
        Assert.assertEquals(scs.getBannerCartEmpty(), "Your shopping cart is empty.");
        //Aca primero se capta el color en rgba y eso se guarda en bannerColor
        String bannerColor = scs.getColorOfBannerEmpty();
        //luego en la variable exaColor, convierto el color de Rgba a exa
        String exaColor = Color.fromString(bannerColor).asHex();
        System.out.println(exaColor);
        //Aca estoy usando dos assert que hacen lo mismo, o lo dejo en rgba o
        // uso la clase Color.fromString(bannerColor).asHex() y convierto el
        // color de rgba a exa
        Assert.assertEquals(exaColor, "#fe9126");
        Assert.assertEquals(bannerColor, "rgba(254, 145, 38, 1)");
        System.out.println("Se está mostrando el banner naranja");
        System.out.println("El carrito de compras está vacío");



    }
}