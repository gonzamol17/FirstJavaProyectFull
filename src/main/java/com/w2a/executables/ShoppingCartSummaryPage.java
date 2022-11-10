package com.w2a.executables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage {

    WebDriver driver;

    @FindBy(css = "#center_column>p")
    WebElement bannerCartEmpty;


    public ShoppingCartSummaryPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getBannerCartEmpty(){

        return  bannerCartEmpty.getText();
    }

    public String getColorOfBannerEmpty(){
        return bannerCartEmpty.getCssValue("background-color");
    }
}
