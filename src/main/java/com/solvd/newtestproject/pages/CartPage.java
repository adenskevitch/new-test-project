package com.solvd.newtestproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage{

    @FindBy(xpath = "//*[contains(@data-name,'Active Items')]")
    private static List<WebElement> products;

    public CartPage(WebDriver driver) {
        super(driver);
    }
}
