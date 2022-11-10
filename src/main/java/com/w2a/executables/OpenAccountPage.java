package com.w2a.executables;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OpenAccountPage {
    WebDriver driver;

    @FindBy(id="userSelect")
    WebElement dropDownCustomer;
    @FindBy(id="currency")
    WebElement dropDownCurrency;
    @FindBy(css="div>form>button")
    WebElement btnProcess;



    public OpenAccountPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setDropDownCustomer() throws InterruptedException {
        Select sel= new Select(dropDownCustomer);
        List<WebElement> options= sel.getOptions();
        int size=options.size();
        for(int i=1; i<size;i++){
            sel.selectByIndex(i);
            Thread.sleep(1000);
            setCurrency("Dollar");
            Thread.sleep(1000);
            String optionName=options.get(i).getText();
            System.out.println("Se cargó el customer: "+optionName);
            setBtnProcess();
            Alert alt = driver.switchTo().alert();
            alt.accept();


        }

    }

    public void setCurrency(String currency) throws InterruptedException {
        Select sel= new Select(dropDownCurrency);
        sel.selectByVisibleText(currency);
        Thread.sleep(1000);
    }

    public void setBtnProcess(){
        btnProcess.click();
    }



}
