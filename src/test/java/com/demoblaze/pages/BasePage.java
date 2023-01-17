package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "login2")
    public WebElement loginHomePage;
    @FindBy(xpath = "//a[text()='Home ']")
    public WebElement homelink_lc;

    @FindBy(xpath = "//a[.='Cart']")
    public WebElement cart_lc;


}
