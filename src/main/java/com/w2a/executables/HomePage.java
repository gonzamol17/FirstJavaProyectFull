package com.w2a.executables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    @FindBy(css = "div.header_user_info>a")
    WebElement btn_Login;
    @FindBy(css = "nav>span")
    WebElement iconCallUs;
    @FindBy(css = "section.blockcategories_footer.footer-block.col-xs-12.col-sm-2>h4")
    WebElement categoriesLink;
    @FindBy(css = "#block_various_links_footer>h4")
    WebElement informationLink;
    @FindBy(css = "#footer>div>section:nth-child(7)>h4")
    WebElement myAccountLink;
    @FindBy(css = "#block_contact_infos>div>h4")
    WebElement storeInformationLink;
    //@FindBy(xpath = "//*[@id=\"footer\"]/div/section[2]/div/div/ul/li/a")
    //WebElement listOfCategoriesLink;
    //@FindBy(css = "#block_various_links_footer>ul>li")
    //WebElement listOfInformationLink;
    //@FindBy (css = "section:nth-child(7)>div>ul>li")
   // WebElement listOfMyAccountLink;
    @FindBy(css = "li:nth-child(2)>div>h3")
    WebElement callUsDetail;
    @FindBy(css = "li:nth-child(2)>div>p>a")
    WebElement btnSeleniumFramework;
    @FindBy(css = "div:nth-child(2)>h3")
    WebElement customBlockTitle;
    @FindBy(css = "p:nth-child(2)>strong")
    WebElement subtitle1;
    @FindBy(id = "newsletter-input" )
    WebElement textBoxNewsletter;
    @FindBy(css = "div>button")
    WebElement btnSendEmail;
    @FindBy(css = "#columns>p")
    WebElement bannerSubscribed;
    @FindBy(css = "#homepage-slider a.bx-next")
    WebElement nextSlider;
    @FindBy(css = "#homeslider>li:nth-child(2)>div>p:nth-child(3)>button")
    WebElement btnShopNow;
    @FindBy(css = "#homepage div.header-content-details>h1")
    WebElement externalTitle;







    public HomePage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void selectLoginBtn(){
        btn_Login.click();
    }

    public boolean getLinkSignOut(){
        return btn_Login.isDisplayed();
    }

    public String getIconCallUs(){
        return iconCallUs.getText();
    }
    public String getCategoriesFooterLink(){
        return categoriesLink.getText();
    }
    public String getInformationFooterLink(){
        return informationLink.getText();
    }
    public String getMyAccountFooterLink(){
        return myAccountLink.getText();
    }
    public String getStoreInformationFooterLink(){return storeInformationLink.getText();}
    public void getAllCategories(){
        List<WebElement> categorieList= driver.findElements(By.xpath("//body/div[@id='page']/div[3]/footer[1]/div[1]/section[2]/div[1]/div[1]/ul[1]/li[1]/a[1]"));
        for (WebElement list:categorieList) {
            String name= list.getText();
            System.out.println(name);
        }
    }

    public void getAllInformation() {
        List<WebElement> informationList = driver.findElements(By.cssSelector("#block_various_links_footer>ul>li"));
        for (WebElement list : informationList) {
            String name = list.getText();
            System.out.println(name);
        }
    }

    public void getAllAccount(){
        List<WebElement> myAccountList = driver.findElements(By.cssSelector("section:nth-child(7)>div>ul>li"));
        for (WebElement list : myAccountList) {
            String name = list.getText();
           System.out.println(name);
           }
    }

    public Boolean getCallUsLeyend(){
       return callUsDetail.isDisplayed();

    }

    public void selectBtnSeleniumFramework(){
        btnSeleniumFramework.click();
    }


    public Boolean verifyCustomBlockTitleIsPresent(){
        return customBlockTitle.isDisplayed();
    }

    public String getCustomBlockTitle(){
        return customBlockTitle.getText();
    }

    public String getSubtitle(){
        return subtitle1.getText();
    }

    public String getColorSubtitle(){
        return subtitle1.getCssValue("color");
    }

    public void sendEmailToSubscribe(String email){
        textBoxNewsletter.click();
        textBoxNewsletter.sendKeys(email);
        btnSendEmail.click();
    }

    public Boolean verificarExistenciaTextBoxNewsletter(){
        return textBoxNewsletter.isDisplayed();
    }

    public String getTitleTextBoxNewsletterSubscribe(){
        return textBoxNewsletter.getAttribute("value");
    }

    public Boolean verificarExistenciaBannerSubscribed(){
        return bannerSubscribed.isDisplayed();
    }
    public String getTitleOfBannerSubscribed(){
        return bannerSubscribed.getText();
    }

    public String getColorBannerSubscribed(){
        return bannerSubscribed.getCssValue("background-color");
    }

    public void selectBtnShopNow(){
        btnShopNow.click();
    }
    public boolean getBtnShopNow(){
        return btnShopNow.isDisplayed();
    }

    public String getExternalTitle(){
        return externalTitle.getText();
    }


}


