package com.w2a.testcases;

import base.TestBase;

import com.w2a.executables.HomePage;
import com.w2a.executables.LoginPage;
import com.w2a.executables.MyAccountPage;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class test_Verify_LoginWithJsonFile extends TestBase {
    HomePage hp;
    LoginPage lp;
    MyAccountPage map;
    JavascriptExecutor jse;


    @Test(dataProvider = "dp")
    public void loginSuccess(String data) throws InterruptedException {
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        hp.selectLoginBtn();
        map = new MyAccountPage(driver);
        String users[] =data.split(",");
        lp.makeLogin(users[0], users[1]);
        map.selectSignOut();
        System.out.println("El username es: " + users[0]);
        System.out.println("El password es: " + users[1]);


     }


    @DataProvider(name = "dp")
    public String[] jsonInformation() throws IOException, ParseException, InterruptedException {
        JSONParser jsonParser = new JSONParser();
        //JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src\\test\\java\\properties\\user.json"));

        FileReader reader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\user.json");
        Object obj = jsonParser.parse(reader);
        JSONObject userloginsJsonobj = (JSONObject) obj;
        JSONArray userloginsArray = (JSONArray) userloginsJsonobj.get("userslogin");
        String[] arr =new String[userloginsArray.size()];
        for (int i=0; i<userloginsArray.size(); i++){
            JSONObject users = (JSONObject) userloginsArray.get(i);
            String user= (String) users.get("username");
            String pwd= (String) users.get("password");
            arr[i] = user+","+pwd;

        }
        return arr;
    }

}
