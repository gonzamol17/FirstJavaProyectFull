package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class test_Verify_Footer_Elements extends TestBase {

    HomePage hp;
    LoginPage lp;
    MyAccountPage map;
    JavascriptExecutor jse;

    @Test
    public void verifyFooterElements() throws InterruptedException {
        hp = new HomePage(driver);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,3000)");
        Thread.sleep(1000);
        System.out.println("Estos son todos los elementos del footer de la web:");
        System.out.println("1 "+hp.getCategoriesFooterLink());
        System.out.println("2 "+hp.getInformationFooterLink());
        System.out.println("3 "+hp.getMyAccountFooterLink());
        System.out.println("4 "+hp.getStoreInformationFooterLink());

    }
}
