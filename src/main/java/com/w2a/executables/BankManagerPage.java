package com.w2a.executables;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BankManagerPage {

    WebDriver driver;

    @FindBy(css="div.center>button:nth-child(1)")
    WebElement btn_AddCustomer;
    @FindBy(css="div.center>button:nth-child(2)")
    WebElement btn_OpenAccount;
    @FindBy(css="div.center>button:nth-child(3)")
    WebElement btn_Customers;

    public BankManagerPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void selectBtnOpenAccount(){
        btn_OpenAccount.click();
    }

    public void selectBtnAddCustomer(){
        btn_AddCustomer.click();
    }

    public void selectBtnCustomers(){
        btn_Customers.click();
    }

    public WebElement existBtnAddCustomer() {
        return btn_AddCustomer;

    }

    public boolean existBtnAddCustomer1() {
        try
        {
            btn_AddCustomer.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }

    }


}