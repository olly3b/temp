package com.wahanda.utility;

/**
 * Created by oliver on 23/10/2014.
 */
public class Element {
    private String name;
    private String locatorString;
    private Locator locator;

    public Element (String name, Locator locator, String locatorString) {
        this.name = name;
        this.locator = locator;
        this.locatorString = locatorString;
    }

    public String getName() {
        return this.name;
    }

    public Locator getLocator() {
        return this.locator;
    }

    public String getLocatorString() {
        return this.locatorString;
    }
}
