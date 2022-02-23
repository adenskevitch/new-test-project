package com.solvd.newtestproject.pages;

import com.solvd.newtestproject.service.WaiteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger();

    protected WebDriver driver;

    private String url;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AbstractPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement element) {
        WaiteService.waitElement(driver, element);
        LOGGER.info("Click on " + element);
        element.click();
    }

    public void inputTextTo(WebElement field, String text) {
        WaiteService.waitElement(driver, field);
        LOGGER.info(String.format("Enter %s on %s", text, field));
        field.sendKeys(text);
    }

    public String getTextFromElement(WebElement element) {
        WaiteService.waitElement(driver, element);
        LOGGER.info(String.format("Getting text from %s", element));
        return element.getText();
    }

    public void openPage(String url) {
        driver.get(url);
        WaiteService.waitLoadPage(driver);
        LOGGER.info("Page is loaded");
    }
}
