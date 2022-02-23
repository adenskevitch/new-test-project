package com.solvd.newtestproject.service;

public enum Browsers {
    CHROME("chrome"), FIREFOX ("firefox"), SAFARI ("safari");

    private final String title;

    Browsers(String browserName) {
        this.title = browserName;
    }

    public String getTitle() {
        return title;
    }
}

