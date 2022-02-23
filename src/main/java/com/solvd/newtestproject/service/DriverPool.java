package com.solvd.newtestproject.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class DriverPool {

    public final static ConcurrentHashMap<Long, WebDriver> drivers = new ConcurrentHashMap<>();

    public static void createDriver(WebDriver driver) {
        drivers.put(Thread.currentThread().getId(), driver);
    }

    public static WebDriver getDriver() {
        return drivers.get(Thread.currentThread().getId());
    }

    public static void initDriver(){
        AbstractDriverOptions<?> options = OptionsFactory.buildOption(Browsers.valueOf(ConfigService.getProperty("browser").toUpperCase()));
        try {
            WebDriver driver = new RemoteWebDriver(new URL(ConfigService.getProperty("grid_hub_url")), options);
            DriverPool.createDriver(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
