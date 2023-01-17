package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    int actualAmount;
    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrderBtn_lc;

    @FindBy(id="name")
    public WebElement name_lc;

    @FindBy(id="country")
    public WebElement country_lc;

    @FindBy(id="city")
    public WebElement city_lc;

    @FindBy(id="card")
    public WebElement creditCart_lc;

    @FindBy(id="month")
    public WebElement month_lc;

    @FindBy(id="year")
    public WebElement year_lc;

    @FindBy(xpath = "(//button[@class='btn btn-primary'])[3]")
    public WebElement purchaseBtn_lc;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement confirmationMessage_lc;
    @FindBy(xpath = "//button[.='OK']")
    public WebElement ok_loc;




    public void removeProduct_mtd(String product){
        BrowserUtils.waitForClickablility(cart_lc,5).click();
        WebElement deleteProduct = Driver.get().findElement(By.xpath("//td[.='" + product + "']/..//a[text()='Delete']"));

        deleteProduct.click();

    }
    public void fiilForm_mtd(){
    Faker faker=new Faker();
    BrowserUtils.waitFor(1);
    name_lc.sendKeys(faker.name().fullName());
   BrowserUtils.waitFor(2);
   country_lc.sendKeys(faker.country().name());
   BrowserUtils.waitFor(2);
   city_lc.sendKeys(faker.country().capital());
   BrowserUtils.waitFor(2);
   creditCart_lc.sendKeys(faker.finance().creditCard());
   BrowserUtils.waitFor(2);
   month_lc.sendKeys(faker.name().lastName());
   BrowserUtils.waitFor(2);
   year_lc.sendKeys(faker.name().username());
   BrowserUtils.waitFor(1);


    }

    public  void finishPurchase_logAmount_mtd(){
        BrowserUtils.waitForClickablility(placeOrderBtn_lc,5).click();
        fiilForm_mtd();
        BrowserUtils.waitForClickablility(purchaseBtn_lc,5).click();

        String confirmationMessage = confirmationMessage_lc.getText();
        String [] confirmationArray=confirmationMessage.split("\n");

       actualAmount= Integer.parseInt(confirmationArray[1].split(" ")[1]);
        BrowserUtils.waitFor(2);
        ok_loc.click();

    }
    public void verifyPurchaseAmount_mtd(int expectedAmount){
        Assert.assertEquals(expectedAmount,actualAmount);
        System.out.println("expectedAmount = " + expectedAmount);
        System.out.println("actualAmount = " + actualAmount);
    }
}
