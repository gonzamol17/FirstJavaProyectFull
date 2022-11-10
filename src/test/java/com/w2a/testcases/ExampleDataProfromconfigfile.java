package com.w2a.testcases;

import base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ExampleDataProfromconfigfile extends TestBase {

    public WebDriver driver;
    public Properties properties = new Properties();
    public FileInputStream inputStream;



    @Test(dataProvider = "getData")
    public void Example(String user, String pass) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Automation\\Selenium webdriver with java-Basics to Advanced+Frameworks\\DataDrivenFramework\\src\\test\\java\\utilities\\chromedriver.exe");
        //driver = new ChromeDriver();
        //driver.get("http://automationpractice.com/index.php");
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.cssSelector("div.header_user_info > a")).click();
        System.out.println(user);
        System.out.println(pass);


    }


    @DataProvider
    public Object[][] getData() throws IOException {
        inputStream= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\OR.properties");
        properties.load(inputStream);
        Object [][] data = new Object[5][2];
        int aux=1;
        int n=1;
        for (int i=0; i<5; i++){
            for(int j=0; j<1;j++){
                data[i][j]=properties.getProperty("username"+n);
                data[i][j+aux]=properties.getProperty("password"+n);
            }
            n=n+1;
        }
        /*
        data [0][0] = properties.getProperty("username1");
        data [0][1] = properties.getProperty("password1");
        data [1][0] = properties.getProperty("username2");
        data [1][1] = properties.getProperty("password2");
        data [2][0] = properties.getProperty("username3");
        data [2][1] = properties.getProperty("password3");
        data [3][0] = properties.getProperty("username4");
        data [3][1] = properties.getProperty("password4");
        data [4][0] = properties.getProperty("username5");
        data [4][1] = properties.getProperty("password5");
        */
        return data;
    }
}
