package com.w2a.executables;

import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountPage {

    WebDriver driver;

    @FindBy(css = "div.nav div:nth-child(1)>a")
    WebElement linkUserName;
    @FindBy(xpath = "//span[contains(text(),'Order history and details')]")
    WebElement itemOrder;
    @FindBy(xpath = "//span[contains(text(),'My credit slips')]")
    WebElement itemMyCredit;
    @FindBy(xpath = "//span[contains(text(),'My addresses')]")
    WebElement itemMyAdress;
    @FindBy(xpath = "//span[contains(text(),'My personal information')]")
    WebElement itemMyPersonal;
    @FindBy(xpath = "//span[contains(text(),'My wishlists')]")
    WebElement itemWishlist;
    @FindBy(css = "div:nth-child(2)>a")
    WebElement linkSignOut;
    @FindBy(css = "div:nth-child(3)>div>a")
    WebElement btnCart;
    @FindBy(css = "#header_logo>a>img")
    WebElement btnGoHomePage;
    @FindBy(css = "div:nth-child(2)>a")
    WebElement btnLogOut;





        public MyAccountPage(WebDriver driver){

            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

        public String getUserName(){
            return  linkUserName.getText();
        }

        public void getMenuItems() {
            List<WebElement> menuItems = driver.findElements(By.cssSelector("#center_column div li"));
            for (WebElement listItems : menuItems) {
                String name = listItems.getText();
                System.out.println(name);

            }
        }

        public int getNumberOfMenuItems(){
            List<WebElement> menuItems = driver.findElements(By.cssSelector("#center_column div li"));
            return menuItems.size();

        }

        public String getItemOrder(){

           return itemOrder.getText();
        }

        public String getItemMyCredit(){

            return itemMyCredit.getText();
    }


        public String getItemMyAddress(){

            return itemMyAdress.getText();
    }

        public String getItemMyPersonal(){

            return itemMyPersonal.getText();
    }

        public String getItemWishlist(){

            return itemWishlist.getText();
    }

        public void selectSignOut(){
            linkSignOut.click();
        }

        public String getTextBtnCart(){
            return btnCart.getText();
        }

        public void selectbtnCart(){
            btnCart.click();
        }

        public void GoHomePage(){
            btnGoHomePage.click();
        }

        public void selectBtnLogOut(){
            btnLogOut.click();
        }

}


