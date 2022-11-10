package com.w2a.executables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "passwd")
    WebElement txtPassword;
    @FindBy(id = "SubmitLogin")
    WebElement btnLogin;
    @FindBy(css = "#center_column>div.alert.alert-danger")
    WebElement alertEmailandPass;



    public LoginPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void makeLogin(String email, String pass){
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(pass);
        btnLogin.click();
    }

    public WebElement verifyRedAlert(){
        return alertEmailandPass;
    }

    public void completeEmailBox(String email){
        txtEmail.sendKeys(email);
        txtPassword.click();
            }

    public String getColorEmailBox(){
        return txtEmail.getCssValue("background");
    }


}
