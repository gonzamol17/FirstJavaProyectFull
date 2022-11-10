package com.w2a.executables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumFrameworkPage {
    WebDriver driver;

    @FindBy(css="div>h2>span>strong")
    WebElement titleOfPage;



    public SeleniumFrameworkPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean getTitleOfPage(){
        return titleOfPage.isDisplayed();
    }

}
