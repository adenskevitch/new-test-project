package com.solvd.newtestproject.pages;

import com.solvd.newtestproject.service.ConfigService;
import com.solvd.newtestproject.service.WaiteService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(css = "#twotabsearchtextbox")
    private static WebElement searchField;

    @FindBy(css = "#nav-search-submit-button")
    private static WebElement searchButton;

    @FindBy(xpath = "//span[contains(@id,'nav-link-accountList')]")
    private static WebElement accountBar;

    public HomePage(WebDriver driver) {
        super(driver, ConfigService.getProperty("page_url"));
        openPage(ConfigService.getProperty("page_url"));
    }

    public HomePage inputToSearchFieldText(String searchText) {
        WaiteService.waitElement(driver, searchField);
        inputTextTo(searchField, searchText);
        return this;
    }

    public ProductListPage clickOnSearchButton() {
        clickOnElement(searchButton);
        ProductListPage productListPage = new ProductListPage(driver);
        WaiteService.waitLoadPage(driver);
        return productListPage;
    }

    public LoginPage clickOnAccountBar() {
        clickOnElement(accountBar);
        LoginPage loginPage = new LoginPage(driver);
        WaiteService.waitLoadPage(driver);
        return loginPage;
    }
}
