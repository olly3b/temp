package com.common.pages.wahanda;

import com.common.utility.AbstractTest;
import com.common.utility.Element;
import com.common.utility.Locator;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by oliver.bray on 20/10/2014.
 */
public class HomePage {
    private final Logger LOG = Logger.getLogger(HomePage.class);

    private Element bookTreatmentButton = new Element("book treatment button", Locator.CSS, "#service-tab > a > span.link-value");
    private Element bookTreatmentWhatWouldYouLikeToBookTextBox = new Element("what would you like to book text box", Locator.CSS, "#search-service > form > div.wahanda-complete.service.select-treatment > div > input");
    private Element bookTreatmentPostcodeTextBox = new Element("postcode text box", Locator.CSS, "#search-service > form > div.wahanda-complete.form-row.location.select-location > div > input");
    private Element bookTreatmentAnyDate = new Element("date text box", Locator.CSS, "#dp1413816920214");

    private Element bookASpaDayOrBreakButton = new Element("spa day or break button", Locator.CSS, "#spa-tab > a > span.link-value");
    private Element bookASpaDayOrBreakEnterCityOrRegionName = new Element("spa city or region text box", Locator.CSS, "#search-spa > form > div.wahanda-complete.form-row.location.select-location > div > input");
    private Element bookASpaDayOrBreakAnyDate = new Element("spa date text box", Locator.CSS, "#dp1413816920215");
    private Element bookASpaDayOrBreakAnyDuration = new Element("spa duration text box", Locator.CSS, "#ui-selectmenu-3b3bf858-button > span.ui-selectmenu-status.selected");

    private Element searchButton = new Element("search button", Locator.CSS, "#search-service > form > span > span");

    private Element fiftyMassagesUnder50Button = new Element("50 massages under £50 box", Locator.CSS, "body > div.sanity > div.merchandising-area.uri-location-replace > div > div > a");

    private Element registerBox = new Element("register box", Locator.CSS, "body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.chromeless-popup.ui-draggable");
    private Element registerBoxCloseButton = new Element("register box close button", Locator.CSS, "body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.chromeless-popup.ui-draggable > div.ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix > a");

    private Element version = new Element("version text", Locator.CSS, "#header > div.wrapper > span");

    public void open() {
        AbstractTest.utility.navigateTo("https://www.uat.wahanda.com");

        if (!AbstractTest.driver.getCurrentUrl().equals("https://www.uat.wahanda.com/")) {
            AbstractTest.utility.navigateTo("https://www.uat.wahanda.com");
        }

        checkForAndCloseRegisterBox();
    }

    public boolean checkForAndCloseRegisterBox() {

        try {
            if (AbstractTest.utility.isVisible(getRegisterBox())) {
                AbstractTest.utility.click(getRegisterBoxCloseButton());
                LOG.info("Closed register popup");

                return true;
            }
        } catch (NoSuchElementException e) {
            LOG.info("No register popup. Continuing as normal");
        }

        return false;
    }

    public String getVersionText() {
        return AbstractTest.utility.getText(getVersion());
    }

    public Element getBookTreatmentButton() {
        return bookTreatmentButton;
    }

    public Element getBookTreatmentWhatWouldYouLikeToBookTextBox() {
        return bookTreatmentWhatWouldYouLikeToBookTextBox;
    }

    public Element getBookTreatmentPostcodeTextBox() {
        return bookTreatmentPostcodeTextBox;
    }

    public Element getBookTreatmentAnyDate() {
        return bookTreatmentAnyDate;
    }

    public Element getBookASpaDayOrBreakButton() {
        return bookASpaDayOrBreakButton;
    }

    public Element getBookASpaDayOrBreakEnterCityOrRegionName() {
        return bookASpaDayOrBreakEnterCityOrRegionName;
    }

    public Element getBookASpaDayOrBreakAnyDate() {
        return bookASpaDayOrBreakAnyDate;
    }

    public Element getBookASpaDayOrBreakAnyDuration() {
        return bookASpaDayOrBreakAnyDuration;
    }

    public Element getSearchButton() {
        return searchButton;
    }

    public Element getFiftyMassagesUnder50Button() {
        return fiftyMassagesUnder50Button;
    }

    public Element getRegisterBoxCloseButton() {
        return registerBoxCloseButton;
    }

    public Element getRegisterBox() {
        return registerBox;
    }

    public Element getVersion() {
        return version;
    }
}
