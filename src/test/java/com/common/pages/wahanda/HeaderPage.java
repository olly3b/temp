package com.common.pages.wahanda;

import com.common.forms.AccountForm;
import com.common.utility.Element;
import com.common.utility.Locator;
import com.common.utility.TestUtility;
import org.apache.log4j.Logger;

/**
 * Created by oliver on 23/10/2014.
 */
public class HeaderPage {
    private final Logger LOG = Logger.getLogger(HeaderPage.class);
    private TestUtility utility = new TestUtility();

    private Element logInButton = new Element("login button", Locator.CSS,"#user-nav > div.button.other-button.a-login.hide > span");
    private Element emailTextBox = new Element("email text box", Locator.CSS, "#header-login > div > form > div:nth-child(1) > div.txt-input > input");
    private Element passwordTextBox = new Element("password text box", Locator.CSS, "#header-login > div > form > div:nth-child(2) > div > input");
    private Element submitLoginButton = new Element("submit login button", Locator.CSS, "#header-login > div > form > div.button.main-button.a-login");

    private Element controlOpen = new Element("control open", Locator.CSS, " #user-nav > div.user-info.hide.page-content-overlay-persist > div.control-open > span");
    private Element logOutButton = new Element("logout link", Locator.CSS, "#user-nav > div.user-info.hide.page-content-overlay-persist.on > ul > li.logout > a");
    private Element myBookings = new Element("my bookings link", Locator.CSS, "#user-nav > div.user-info.hide.page-content-overlay-persist.on > ul > li:nth-child(1) > a");
    private Element myWallet = new Element("my wallet link", Locator.CSS, "#user-nav > div.user-info.hide.page-content-overlay-persist.on > ul > li:nth-child(2) > a");

    private Element listYourBusiness = new Element("list your business button", Locator.CSS,"#user-nav > a.button.other-button.a-list-business.hide");

    private Element searchByVenueNameTextBox = new Element("search by venue text box", Locator.CSS,"#header > div.wrapper > div.venue-search.wahanda-complete-small-home > input");

    private Element hairLink = new Element("hair link", Locator.CSS,"#nav > div:nth-child(1) > a > span");
    private Element hairRemovalLink = new Element("hair removal link", Locator.CSS,"#nav > div:nth-child(3) > a > span");
    private Element massageLink = new Element("massage link", Locator.CSS,"#nav > div:nth-child(5) > a > span");
    private Element nailsLink = new Element("nails link", Locator.CSS,"#nav > div:nth-child(7) > a > span");
    private Element faceLink = new Element("face link", Locator.CSS,"#nav > div:nth-child(9) > a > span");
    private Element bodyLink = new Element("body link", Locator.CSS,"#nav > div:nth-child(9) > a > span");
    private Element spaDaysLink = new Element("spa days link", Locator.CSS,"#nav > div:nth-child(9) > a > span");
    private Element spaBreaksLink = new Element("spa breaks link", Locator.CSS,"#nav > div:nth-child(9) > a > span");
    private Element downloadAppLink = new Element("download app link", Locator.CSS,"#nav > div.nav-unit.no-subnav > a > span");

    public void login(AccountForm accountForm) {
        HomePage homePage = new HomePage();
        homePage.open();

        utility.click(getLogInButton());
        utility.enterText(getEmailTextBox(), accountForm.getEmail());
        utility.enterText(getPasswordTextBox(), accountForm.getPassword());
        utility.click(getSubmitLoginButton());

        LOG.info("Logged in as " + accountForm.getEmail());
    }

    public void logout() {
        utility.click(getControlOpen());
        utility.click(getLogOutButton());
        utility.waitForElementToBeVisible(getLogInButton());

        LOG.info("Logged out");
    }

    public Element getLogInButton() {
        return logInButton;
    }

    public Element getControlOpen() {
        return controlOpen;
    }

    public Element getLogOutButton() {
        return logOutButton;
    }

    public Element getMyBookings() {
        return myBookings;
    }

    public Element getMyWallet() {
        return myWallet;
    }

    public Element getListYourBusiness() {
        return listYourBusiness;
    }

    public Element getMassageLink() {
        return massageLink;
    }

    public Element getSearchByVenueNameTextBox() {
        return searchByVenueNameTextBox;
    }

    public Element getHairLink() {
        return hairLink;
    }

    public Element getHairRemovalLink() {
        return hairRemovalLink;
    }

    public Element getEmailTextBox() {
        return emailTextBox;
    }

    public Element getPasswordTextBox() {
        return passwordTextBox;
    }

    public Element getSubmitLoginButton() {
        return submitLoginButton;
    }

    public Element getNailsLink() {
        return nailsLink;
    }

    public Element getFaceLink() {
        return faceLink;
    }

    public Element getBodyLink() {
        return bodyLink;
    }

    public Element getSpaDaysLink() {
        return spaDaysLink;
    }

    public Element getSpaBreaksLink() {
        return spaBreaksLink;
    }

    public Element getDownloadAppLink() {
        return downloadAppLink;
    }


}
