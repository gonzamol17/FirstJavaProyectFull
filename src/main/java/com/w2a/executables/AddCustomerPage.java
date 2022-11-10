package com.w2a.executables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    WebDriver driver;

    @FindBy(css="div:nth-child(1)>input")
    WebElement lbl_first_name;

    @FindBy(css="div.ng-scope>div>div>form>div:nth-child(2)>input")
    WebElement lbl_last_name;

    @FindBy(css="div:nth-child(3) > input")
    WebElement lbl_post_code;

    @FindBy(css="div>div>form>button")
    WebElement btn_AddCustomer;

    @FindBy(css = "div.box.mainhdr>button.btn.home")
    WebElement btn_Home;


    public AddCustomerPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setFirstName(String name){
        lbl_first_name.sendKeys(name);
    }

    public void setLastName(String lname){
        lbl_last_name.sendKeys(lname);
    }

    public void setPostCode(String code){
        lbl_post_code.sendKeys(code);
    }

    public void btnAddCustomer(){
        btn_AddCustomer.click();
    }
    public void btnGoHome(){
        btn_Home.click();
    }
}
