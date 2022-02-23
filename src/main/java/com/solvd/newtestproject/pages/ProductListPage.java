package com.solvd.newtestproject.pages;

import com.solvd.newtestproject.service.WaiteService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListPage extends AbstractPage {

    @FindBy(css = "div[data-component-type='s-search-result'].s-result-item .s-title-instructions-style h2:first-child")
    private List<WebElement> products;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProducts() {
        WaiteService.waitElements(driver, products);
        return products;
    }
}
