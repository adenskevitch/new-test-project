package com.solvd.newtestproject;

import com.solvd.newtestproject.pages.HomePage;
import com.solvd.newtestproject.pages.LoginPage;
import com.solvd.newtestproject.pages.ProductListPage;
import com.solvd.newtestproject.service.ConfigService;
import com.solvd.newtestproject.service.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTest extends AbstractTest {

    @Test(testName = "Search verification")
    public void searchProductVerification() {
        String productName = ConfigService.getProperty("search_product");
        WebDriver driver = DriverPool.getDriver();
        HomePage homePage = new HomePage(driver);
        ProductListPage productPage = homePage.inputToSearchFieldText(productName).clickOnSearchButton();
        SoftAssert sa = new SoftAssert();
        productPage.getProducts()
                .forEach(product -> sa.assertTrue(product.getText().toLowerCase().contains(productName)));
        sa.assertAll();
    }

    @Test(testName = "Fail login test")
    public void failLoginVerify() {
        String invalidEmail = ConfigService.getProperty("invalid_email");
        WebDriver driver = DriverPool.getDriver();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnAccountBar();
        loginPage.inputToEmailFieldText(invalidEmail).clickOnContinueButton();
        String errorMessage = loginPage.getErrorMessageText();
        Assert.assertEquals(ConfigService.getProperty("login_error_text"), errorMessage);
    }
}
