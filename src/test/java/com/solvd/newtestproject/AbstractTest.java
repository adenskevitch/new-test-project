package com.solvd.newtestproject;

import com.solvd.newtestproject.service.ConfigService;
import com.solvd.newtestproject.service.DriverPool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractTest {

    @BeforeSuite
    public void beforeSuite() {
        ConfigService.initInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        DriverPool.initDriver();
    }

    @AfterMethod
    public void afterMethod() {
        DriverPool.getDriver().quit();
    }
}
