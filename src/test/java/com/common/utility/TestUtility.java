package com.common.utility;

import com.thoughtworks.selenium.Wait;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by oliver on 23/10/2014.
 */
public class TestUtility {

    private final Logger LOG = Logger.getLogger(TestUtility.class);

    public void navigateTo(String url) {

        LOG.info(AbstractTest.browserDescription + "Attempting to navigate to " + url);

        if (!url.contains("https://")) { LOG.warn("Missing http:// from url"); }
        if (!url.contains("www.")) { LOG.warn("Missing www. from url"); }

        try {
            AbstractTest.driver.get(url);
            LOG.info(AbstractTest.browserDescription + "Navigated to " + url);
        } catch (Exception e) {
            LOG.error(AbstractTest.browserDescription + "Failed to navigate to " + url);
            e.printStackTrace();
        }
    }

    public void enterText(Element element, String text) {

        waitForElementToBeVisible(element);

        try {
            switch (element.getLocator()) {
                case CSS:
                    AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).sendKeys(text);
                    if (!AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).getText().equals(text) && AbstractTest.browserDescription.contains("safari")) {
                        LOG.error(AbstractTest.browserDescription + "Entering text failed. Found '" + AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).getText().equals(text) + "' Retrying with reverse text");
                        clearAndEnterText(element, new StringBuilder(text).reverse().toString());
                    }
                    break;
                case ID:
                    AbstractTest.driver.findElement(By.id(element.getLocatorString())).sendKeys(text);
                    if (!AbstractTest.driver.findElement(By.id(element.getLocatorString())).getText().equals(text) && AbstractTest.browserDescription.contains("safari")) {
                        LOG.error(AbstractTest.browserDescription + "Entering text failed. Found '" + AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).getText().equals(text) + "' Retrying");
                        clearAndEnterText(element, new StringBuilder(text).reverse().toString());
                    }
                    break;
                case XPATH:
                    AbstractTest.driver.findElement(By.xpath(element.getLocatorString())).sendKeys(text);
                    if (!AbstractTest.driver.findElement(By.xpath(element.getLocatorString())).getText().equals(text) && AbstractTest.browserDescription.contains("safari")) {
                        LOG.error(AbstractTest.browserDescription + "Entering text failed. Found '" + AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).getText().equals(text) + "' Retrying");
                        clearAndEnterText(element, new StringBuilder(text).reverse().toString());
                    }
                    break;
                case LINKTEXT:
                    AbstractTest.driver.findElement(By.linkText(element.getLocatorString())).sendKeys(text);
                    if (!AbstractTest.driver.findElement(By.linkText(element.getLocatorString())).getText().equals(text) && AbstractTest.browserDescription.contains("safari")) {
                        LOG.error(AbstractTest.browserDescription + "Entering text failed. Found '" + AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).getText().equals(text) + "' Retrying");
                        clearAndEnterText(element, new StringBuilder(text).reverse().toString());
                    }
                    break;
                case NAME:
                    AbstractTest.driver.findElement(By.name(element.getLocatorString())).sendKeys(text);
                    if (!AbstractTest.driver.findElement(By.name(element.getLocatorString())).getText().equals(text) && AbstractTest.browserDescription.contains("safari")) {
                        LOG.error(AbstractTest.browserDescription + "Entering text failed. Found '" + AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).getText().equals(text) + "' Retrying");
                        clearAndEnterText(element, new StringBuilder(text).reverse().toString());
                    }
                    break;
            }

            LOG.info(AbstractTest.browserDescription + "Entered text '" + text + "' into " + element.getName());
        } catch (Exception e) {
            LOG.error(AbstractTest.browserDescription + "Failed to enter text'" + text + "' into " + element.getName() + " by " + element.getLocator().toString() + " using string " + element.getLocatorString());
            e.printStackTrace();
        }
    }

    public void clearAndEnterText(Element element, String text) {
        waitForElementToBeVisible(element);

        try {
            switch (element.getLocator()) {
                case CSS:
                    AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).clear();
                    AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).sendKeys(text);
                    break;
                case ID:
                    AbstractTest.driver.findElement(By.id(element.getLocatorString())).clear();
                    AbstractTest.driver.findElement(By.id(element.getLocatorString())).sendKeys(text);
                    break;
                case XPATH:
                    AbstractTest.driver.findElement(By.xpath(element.getLocatorString())).clear();
                    AbstractTest.driver.findElement(By.xpath(element.getLocatorString())).sendKeys(text);
                    break;
                case LINKTEXT:
                    AbstractTest.driver.findElement(By.linkText(element.getLocatorString())).clear();
                    AbstractTest.driver.findElement(By.linkText(element.getLocatorString())).sendKeys(text);
                    break;
                case NAME:
                    AbstractTest.driver.findElement(By.name(element.getLocatorString())).clear();
                    AbstractTest.driver.findElement(By.name(element.getLocatorString())).sendKeys(text);
                    break;
            }

            LOG.info(AbstractTest.browserDescription + "Entered text '" + text + "' into " + element.getName());
        } catch (Exception e) {
            LOG.error(AbstractTest.browserDescription + "Failed to enter text'" + text + "' into " + element.getName() + " by " + element.getLocator().toString() + " using string " + element.getLocatorString());
            e.printStackTrace();
        }
    }

    public void click(Element element) {

        waitForElementToBeVisible(element);
        waitForElementToBeClickable(element);

        try {
            switch (element.getLocator()) {
                case CSS:
                    AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).click();
                    break;
                case ID:
                    AbstractTest.driver.findElement(By.id(element.getLocatorString())).click();
                    break;
                case XPATH:
                    AbstractTest.driver.findElement(By.xpath(element.getLocatorString())).click();
                    break;
                case LINKTEXT:
                    AbstractTest.driver.findElement(By.linkText(element.getLocatorString())).click();
                    break;
                case NAME:
                    AbstractTest.driver.findElement(By.name(element.getLocatorString())).click();
                    break;
            }
            LOG.info(AbstractTest.browserDescription + "Clicked on " + element.getName());
        } catch (Exception e) {
            LOG.error(AbstractTest.browserDescription + "failed to click on " + element.getName() + " by " + element.getLocator().toString() + " using string " + element.getLocatorString());
            e.printStackTrace();
        }
    }

    public void jsClick(Element element) {
        ((JavascriptExecutor) AbstractTest.driver).executeScript("arguments[0].click()", castElementToWebElement(element));
        LOG.info(AbstractTest.browserDescription + "Probably clicked on " + element.getName() + " using javascript executor");
    }

    public void waitForElementToBeVisible(Element element) throws Wait.WaitTimedOutException {
        WebDriverWait wait = new WebDriverWait(AbstractTest.driver, AbstractTest.EXPLICIT_TIMEOUT);

        try {

            switch (element.getLocator()) {
                case CSS:
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element.getLocatorString())));
                    break;
                case ID:
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element.getLocatorString())));
                    break;
                case XPATH:
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element.getLocatorString())));
                    break;
                case LINKTEXT:
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element.getLocatorString())));
                    break;
                case NAME:
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element.getLocatorString())));
                    break;
            }
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public void waitForElementToBeClickable(Element element) {
        WebDriverWait wait = new WebDriverWait(AbstractTest.driver, AbstractTest.EXPLICIT_TIMEOUT);

        switch (element.getLocator()) {
            case CSS:
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element.getLocatorString())));
                break;
            case ID:
                wait.until(ExpectedConditions.elementToBeClickable(By.id(element.getLocatorString())));
                break;
            case XPATH:
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element.getLocatorString())));
                break;
            case LINKTEXT:
                wait.until(ExpectedConditions.elementToBeClickable(By.linkText(element.getLocatorString())));
                break;
            case NAME:
                wait.until(ExpectedConditions.elementToBeClickable(By.name(element.getLocatorString())));
                break;
        }
    }

    public String getText(Element element) {

        String text = "";

        waitForElementToBeVisible(element);

        switch (element.getLocator()) {
            case CSS:
                text = AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).getText();
                break;
            case ID:
                text = AbstractTest.driver.findElement(By.id(element.getLocatorString())).getText();
                break;
            case XPATH:
                text = AbstractTest.driver.findElement(By.xpath(element.getLocatorString())).getText();
                break;
            case LINKTEXT:
                text = AbstractTest.driver.findElement(By.linkText(element.getLocatorString())).getText();
                break;
            case NAME:
                text = AbstractTest.driver.findElement(By.name(element.getLocatorString())).getText();
                break;
        }
        LOG.info(AbstractTest.browserDescription + "Found text '" + text + "' on " + element.getName());

        return text;
    }

    public String getTextByValueAttribute(Element element) {
        String text = "";

        waitForElementToBeVisible(element);

        switch (element.getLocator()) {
            case CSS:
                text = AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).getAttribute("value");
                break;
            case ID:
                text = AbstractTest.driver.findElement(By.id(element.getLocatorString())).getAttribute("value");
                break;
            case XPATH:
                text = AbstractTest.driver.findElement(By.xpath(element.getLocatorString())).getAttribute("value");
                break;
            case LINKTEXT:
                text = AbstractTest.driver.findElement(By.linkText(element.getLocatorString())).getAttribute("value");
                break;
            case NAME:
                text = AbstractTest.driver.findElement(By.name(element.getLocatorString())).getAttribute("value");
                break;
        }
        LOG.info(AbstractTest.browserDescription + "Found text '" + text + "' on " + element.getName());

        return text;
    }

    public boolean isVisible(Element element) throws NoSuchElementException {
        try {
            switch (element.getLocator()) {
                case CSS:
                    return AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString())).isDisplayed();
                case ID:
                    return AbstractTest.driver.findElement(By.id(element.getLocatorString())).isDisplayed();
                case XPATH:
                    return AbstractTest.driver.findElement(By.xpath(element.getLocatorString())).isDisplayed();
                case LINKTEXT:
                    return AbstractTest.driver.findElement(By.linkText(element.getLocatorString())).isDisplayed();
                case NAME:
                    return AbstractTest.driver.findElement(By.name(element.getLocatorString())).isDisplayed();
            }

            return false;
        } catch (NoSuchElementException e) {
            LOG.info(element.getName() + " does not exist");
            throw e;
        }
    }

    private WebElement castElementToWebElement(Element element) {
        switch (element.getLocator()) {
            case CSS:
                return AbstractTest.driver.findElement(By.cssSelector(element.getLocatorString()));
            case ID:
                return AbstractTest.driver.findElement(By.id(element.getLocatorString()));
            case LINKTEXT:
                return AbstractTest.driver.findElement(By.linkText(element.getLocatorString()));
            case XPATH:
                return AbstractTest.driver.findElement(By.xpath(element.getLocatorString()));
            case NAME:
                return AbstractTest.driver.findElement(By.name(element.getLocatorString()));
        }

        LOG.error(AbstractTest.browserDescription + "Could not cast element " + element.getName() + " into a web element");
        return null;
    }

    public void selectFromDropDownByText(Element element, String text) {
        Select select = new Select(castElementToWebElement(element));
        select.selectByVisibleText(text);
    }
}
