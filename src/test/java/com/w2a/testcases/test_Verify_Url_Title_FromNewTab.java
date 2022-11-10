package com.w2a.testcases;

import base.TestBase;
import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test_Verify_Url_Title_FromNewTab extends TestBase {
    HomePage hp;
    LoginPage lp;
    MyAccountPage map;
    JavascriptExecutor jse;

    @Test
    public void verifyUrlAndTitleFromNewTab() throws InterruptedException {
        hp = new HomePage(driver);
        try {
            if(hp.getBtnShopNow()){
                hp.selectBtnShopNow();
            }
        }
        catch (Exception e) {
            System.out.println("The button is not present");
            e.printStackTrace();
            e.getCause();
            e.getMessage();
            Assert.assertEquals("http://automationpractice.com/index.php", driver.getCurrentUrl());
            System.out.println("I still keep on the original url");
        }
        String url= driver.getCurrentUrl();
        System.out.println("The actual url is: "+url);
        String title = hp.getExternalTitle();
        Assert.assertEquals(title, "Libera el potencial de tu comercio electrónico");
        System.out.println("The title of new page is: "+title);
        driver.navigate().back();


    }

}
