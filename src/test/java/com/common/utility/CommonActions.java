package com.common.utility;

import com.thoughtworks.selenium.Wait;
import com.common.forms.AccountForm;
import com.common.pages.wahanda.*;
import org.apache.log4j.Logger;

/**
 * Created by oliver on 24/10/2014.
 */
public class CommonActions {

    private final Logger LOG = Logger.getLogger(CommonActions.class);
    private TestUtility utility = new TestUtility();

    public AccountForm createNewRandomAccount() {
        LOG.info(AbstractTest.browserDescription + "Starting new random account process");

        HomePage homePage = new HomePage();
        homePage.open();

        HeaderPage headerPage = new HeaderPage();
        utility.click(headerPage.getLogInButton());

        AccountHeaderPage accountHeaderPage = new AccountHeaderPage();
        utility.click(accountHeaderPage.getSignUpButton());

        AccountForm accountForm = new AccountForm();
        accountForm.generateTestUser();

        CreateProfilePage createProfilePage = new CreateProfilePage();
        createProfilePage.fillAccountDetails(utility, accountForm);
        utility.jsClick(createProfilePage.getNewsletterRadio());
        utility.click(createProfilePage.getJoinWahandaButton());

        // Sometimes the page blanks after completing it, try again if so
        if (utility.getTextByValueAttribute(createProfilePage.getEmailTextBox()).equals("")) {
            createProfilePage.fillAccountDetails(utility, accountForm);
            utility.jsClick(createProfilePage.getNewsletterRadio());
            utility.click(createProfilePage.getJoinWahandaButton());
        }

        MyAccountPage myAccountPage = new MyAccountPage();
        try {
            utility.waitForElementToBeVisible(myAccountPage.getEditMyProfileButton());
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
