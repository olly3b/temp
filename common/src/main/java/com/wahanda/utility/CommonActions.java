package com.wahanda.utility;

import com.thoughtworks.selenium.Wait;
import com.wahanda.forms.AccountForm;
import com.wahanda.pages.wahanda.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by oliver on 24/10/2014.
 */
public class CommonActions {

    private final Logger LOG = Logger.getLogger(CommonActions.class);

    public AccountForm createNewRandomAccount() {
        LOG.info(AbstractTest.browserDescription + "Starting new random account process");

        HomePage homePage = new HomePage();
        homePage.open();

        HeaderPage headerPage = new HeaderPage();
        AbstractTest.utility.click(headerPage.getLogInButton());

        AccountHeaderPage accountHeaderPage = new AccountHeaderPage();
        AbstractTest.utility.click(accountHeaderPage.getSignUpButton());

        AccountForm accountForm = new AccountForm();
        accountForm.generateTestUser();

        CreateProfilePage createProfilePage = new CreateProfilePage();
        createProfilePage.fillAccountDetails(AbstractTest.utility, accountForm);
        AbstractTest.utility.jsClick(createProfilePage.getNewsletterRadio());
        AbstractTest.utility.click(createProfilePage.getJoinWahandaButton());

        MyAccountPage myAccountPage = new MyAccountPage();
        try {
            AbstractTest.utility.waitForElementToBeVisible(myAccountPage.getEditMyProfileButton());
        } catch(Wait.WaitTimedOutException e) {
            LOG.error("Account not created. Possible creation process failure.");
        }

        LOG.info(AbstractTest.browserDescription + "New account created: profile=" + accountForm.getProfileName() + " email=" + accountForm.getEmail() +
                " password=" + accountForm.getPassword() + " firstName=" + accountForm.getFirstName() + " lastName=" +
                accountForm.getLastName() + " gender=" + accountForm.getGender() + " postcode=" + accountForm.getPostcode());

        return accountForm;
    }

    public void login(AccountForm accountForm) {
        HeaderPage headerPage = new HeaderPage();
        headerPage.login(accountForm);
    }

    public void logout() {
        HeaderPage headerPage = new HeaderPage();
        headerPage.logout();
    }
}
