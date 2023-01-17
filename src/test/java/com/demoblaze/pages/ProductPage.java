package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.dnd.DragGestureEvent;

public class ProductPage extends BasePage {

    @FindBy(id = "nameofuser")
    public WebElement welcomeUsername_lc;
    @FindBy(xpath ="//a[.='Add to cart']" )
    public WebElement addToCart_lc;

    public void verifyLogin_mtd(String expextedUsername) {
        String actualUsername = welcomeUsername_lc.getText();
        Assert.assertEquals("user does Not match", expextedUsername, actualUsername);
        System.out.println("expextedUsername = " + expextedUsername);
        System.out.println("actualUsername = " + actualUsername);

    }

    public void addProduct_mtd(String product, String category) {
        WebElement categoryModul = Driver.get().findElement(By.xpath("//a[.='" + category + "']"));
        BrowserUtils.waitForClickablility(categoryModul, 5).click();
        WebElement productItem = Driver.get().findElement(By.xpath("//a[.='" + product + "']"));
        BrowserUtils.scrollToElement(productItem);
        BrowserUtils.waitForClickablility(productItem, 5).click();
        BrowserUtils.waitFor(2);
        addToCart_lc.click();
        BrowserUtils.waitFor(2);
        Alert alert=Driver.get().switchTo().alert();
        alert.accept();
       BrowserUtils.waitForClickablility(homelink_lc,5).click();
       BrowserUtils.waitFor(2);

    }
}

