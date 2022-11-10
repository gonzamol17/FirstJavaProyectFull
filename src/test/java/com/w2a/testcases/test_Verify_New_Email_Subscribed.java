package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.SchemaOutputResolver;

public class test_Verify_New_Email_Subscribed extends TestBase {

    HomePage hp;
    LoginPage lp;
    MyAccountPage map;
    JavascriptExecutor jse;

    @Test
    public void verifyNewEmailSubscribed() throws InterruptedException {
        hp = new HomePage(driver);
        Thread.sleep(2000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2300)");
        Thread.sleep(2000);
        Assert.assertTrue(hp.verificarExistenciaTextBoxNewsletter());
        System.out.println("Se está visualizando el box de Subscribe a Newsletter y el texto dentro de él:--> "+hp.getTitleTextBoxNewsletterSubscribe());
        Thread.sleep(2000);
        hp.sendEmailToSubscribe("test105@gmail.com");
        Assert.assertTrue(hp.verificarExistenciaBannerSubscribed());
        //System.out.println(hp.getTitleOfBannerSubscribed());
        Thread.sleep(2000);
        if(hp.getTitleOfBannerSubscribed().equalsIgnoreCase("Newsletter : You have successfully subscribed to this newsletter."))
        {
            Assert.assertEquals(hp.getTitleOfBannerSubscribed(), "Newsletter : You have successfully subscribed to this newsletter.");
            Assert.assertEquals(hp.getColorBannerSubscribed(), "rgba(85, 198, 94, 1)");
            System.out.println("Se visualiza un banner verde informando:");
            System.out.println("Se pudo realizar la nueva subscripción: "+hp.getTitleOfBannerSubscribed());
            System.out.println("Y ahora el mensaje dentro de textbox de Newsletter es: "+hp.getTitleTextBoxNewsletterSubscribe());
        }
        else {
            if(hp.getTitleOfBannerSubscribed().equalsIgnoreCase("Newsletter : This email address is already registered.")) {
                Assert.assertEquals(hp.getTitleOfBannerSubscribed(), "Newsletter : This email address is already registered.");
                Assert.assertEquals(hp.getColorBannerSubscribed(), "rgba(243, 81, 92, 1)");
                System.out.println("Se visualiza un banner rojo informando:");
                System.out.println("No se realizó la subscripción " + hp.getTitleOfBannerSubscribed());
                System.out.println("Y ahora el mensaje dentro de textbox de Newsletter es: "+hp.getTitleTextBoxNewsletterSubscribe());
            }
            else System.out.println("No se visualiza ningún banner, ver poqué");
        }


        }


}
