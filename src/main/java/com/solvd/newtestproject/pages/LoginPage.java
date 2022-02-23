package com.solvd.newtestproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[contains(@id,'ap_email')]")
    private static WebElement emailField;

    @FindBy(xpath = "//input[contains(@id,'continue') and contains(@class,'a-button')]")
    private static WebElement continueButton;

    @FindBy(xpath = "//*[contains(@id,'auth-error-message-box')]//*[contains(@class,'a-alert-content')]//span[contains(@class,'a-list-item')]")
    private static WebElement errorMessageTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputToEmailFieldText(String text) {
        inputTextTo(emailField, text);
        return this;
    }

    public LoginPage clickOnContinueButton() {
        clickOnElement(continueButton);
        return this;
    }

    public String getErrorMessageText() {
        return getTextFromElement(errorMessageTitle);
    }
}
