package com.solvd.newtestproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//input[contains(@id,'add-to-card-button')]")
    private static WebElement addToCardButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

}
