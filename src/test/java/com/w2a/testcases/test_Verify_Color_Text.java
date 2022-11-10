package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;
import com.w2a.executables.ShoppingCartSummaryPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class test_Verify_Color_Text extends TestBase {

    HomePage hp;
    JavascriptExecutor jse;


    @Test
    public void verifyCartEmptyBannerAndColor() throws InterruptedException {
        hp = new HomePage(driver);
        jse = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,800)");
        Assert.assertTrue(hp.verifyCustomBlockTitleIsPresent());
        System.out.println("El título: " + hp.getCustomBlockTitle() + " está presente, en la home page");
        //System.out.println(hp.getColorSubtitle());
        Assert.assertEquals(hp.getColorSubtitle(), "rgba(51, 51, 51, 1)");
        System.out.println("El subtítulo: " + hp.getSubtitle() + " también está presente y en negrita");
        Thread.sleep(2000);
        log.info("Ver si llega esto");
        driver.get("http://automationpractice.com/index.php");

    }


}