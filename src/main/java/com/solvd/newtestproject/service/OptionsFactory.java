package com.solvd.newtestproject.service;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.safari.SafariOptions;

public class OptionsFactory {

    public static AbstractDriverOptions<?> buildOption(Browsers browserName) {
        AbstractDriverOptions<?> browserOptions = null;
        switch (browserName) {
            case SAFARI:
                browserOptions = new SafariOptions();
                break;
            case CHROME:
                browserOptions = new ChromeOptions();
                break;
            case FIREFOX:
                browserOptions = new FirefoxOptions();
                break;
            default:
                break;
        }
        return browserOptions;
    }
}
