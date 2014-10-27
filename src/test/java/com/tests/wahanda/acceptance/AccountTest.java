package com.tests.wahanda.acceptance;

import com.common.forms.AccountForm;
import com.common.pages.wahanda.*;
import com.common.utility.AbstractTest;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by oliver on 22/10/2014.
 */
public class AccountTest extends AbstractTest {

    private final Logger LOG = Logger.getLogger(AccountTest.class);

    @Test()
    public void accountCreationTest() {
        LOG.info(browserDescription + "********** Test accounts are created properly **********");

        AccountForm accountForm = commonActions.createNewRandomAccount();

        MyAccountPage myAccountPage = new MyAccountPage();
        assertTrue(myAccountPage.getTextOfNameText(utility).equals(accountForm.getFirstName() + " " + accountForm.getLastName()), "Failed to match name text on profile with expected text");
        assertTrue(myAccountPage.getTextOfEmailText(utility).equals(accountForm.getEmail()), "Failed to match email text on profile with expected text");
        assertTrue(myAccountPage.getTextOfProfileText(utility).equals(accountForm.getProfileName()), "Failed to match profile name text on profile with expected text");
        assertTrue(myAccountPage.getTextOfGenderText(utility, accountForm).equals(accountForm.getGender().substring(0, 1).toUpperCase() + accountForm.getGender().substring(1)), "Failed to match gender text on profile with expected text");
        assertTrue(utility.isVisible(myAccountPage.getProfilePicture()), "Profile picture is not visible");

        try {
            MyAccountBookingsPage myAccountBookingsPage = new MyAccountBookingsPage();
            assertTrue(myAccountBookingsPage.getTextOfCentreBlock(utility).contains("NO BOOKINGS YET") &&
                    myAccountBookingsPage.getTextOfCentreBlock(utility).contains("Why not book something today?"));
        } catch (AssertionError e) {
            LOG.error("Not seeing correct text in bookings centre block");
        }

        utility.click(myAccountPage.getWalletTabButton());
        try {
            MyAccountWalletPage myAccountWalletPage = new MyAccountWalletPage();
            assertTrue(myAccountWalletPage.getTextOfCentreBlock(utility).contains("NO PROMO CODES AT THE MOMENT") &&
                    myAccountWalletPage.getTextOfCentreBlock(utility).contains("Hey big spender, it looks like you’ve used all your promo codes."));
        } catch (AssertionError e) {
            LOG.error("Not seeing correct text in wallet centre block");
        }

        commonActions.logout();
    }

    @Test()
    public void loginAndPasswordChangeTest() {
        LOG.info(browserDescription + "********** Test login and change password functionality **********");

        AccountForm accountForm = new AccountForm();
        accountForm.setAsPasswordTestUser();

        commonActions.login(accountForm);

        HeaderPage headerPage = new HeaderPage();
        utility.click(headerPage.getControlOpen());
        utility.click(headerPage.getMyBookings());

        MyAccountPage myAccountPage = new MyAccountPage();
        utility.click(myAccountPage.getChangePasswordLink());
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();

        utility.enterText(changePasswordPage.getOldPassword(), "Password5");
        utility.enterText(changePasswordPage.getNewPassword(), "Password5");
        utility.click(changePasswordPage.getOldPassword());
        utility.click(changePasswordPage.getNewPassword());
        assertTrue(utility.getText(changePasswordPage.getNewPasswordCannotBeTheSameMessage()).equals("New password cannot be the same as your current password"), "New password not new validation not showing");

        utility.clearAndEnterText(changePasswordPage.getNewPassword(), "Pass");
        assertTrue(utility.getText(changePasswordPage.getAtLeast6CharactersMessage()).equals("Please enter at least 6 characters."), "Password length validation not showing");

        utility.clearAndEnterText(changePasswordPage.getNewPassword(), "Password4");
        utility.enterText(changePasswordPage.getVerifyPassword(), "Password3");
        utility.click(changePasswordPage.getNewPassword());
        utility.click(changePasswordPage.getVerifyPassword());
        assertTrue(utility.getText(changePasswordPage.getVerifyPasswordDoesNotMatchMessage()).equals("New passwords do not match"), "New password not matching confirmation password validation not showing");

        utility.clearAndEnterText(changePasswordPage.getOldPassword(), "Password6");
        utility.clearAndEnterText(changePasswordPage.getNewPassword(), "Password4");
        utility.clearAndEnterText(changePasswordPage.getVerifyPassword(), "Password4");
        utility.click(changePasswordPage.getSubmitButton());
        assertTrue(utility.getText(changePasswordPage.getOldPasswordIsIncorrentMessage()).equals("Old password is incorrect"), "Incorrect old password validation not showing");

        utility.clearAndEnterText(changePasswordPage.getOldPassword(), "Password5");
        utility.clearAndEnterText(changePasswordPage.getNewPassword(), "Password4");
        utility.clearAndEnterText(changePasswordPage.getVerifyPassword(), "Password4");
        utility.click(changePasswordPage.getSubmitButton());
        assertTrue(utility.getText(changePasswordPage.getChangeSuccessText()).equals("Your password was successfully changed"), "Password not successfully changed");
        utility.click(changePasswordPage.getCloseButton());

        utility.click(myAccountPage.getChangePasswordLink());
        utility.clearAndEnterText(changePasswordPage.getOldPassword(), "Password4");
        utility.clearAndEnterText(changePasswordPage.getNewPassword(), "Password5");
        utility.clearAndEnterText(changePasswordPage.getVerifyPassword(), "Password5");
        utility.click(changePasswordPage.getSubmitButton());
        assertTrue(utility.getText(changePasswordPage.getChangeSuccessText()).equals("Your password was successfully changed"), "Password not successfully changed");
        utility.click(changePasswordPage.getCloseButton());

        commonActions.logout();
    }

    @Test
    public void loginAndEditProfileTest() {
        LOG.info(browserDescription + "********** Test login and edit profile functionality **********");

        AccountForm accountForm = new AccountForm();
        accountForm.setAsEditProfileTestUser();

        commonActions.login(accountForm);
        HeaderPage headerPage = new HeaderPage();

        utility.click(headerPage.getControlOpen());
        utility.click(headerPage.getMyBookings());

        MyAccountPage myAccountPage = new MyAccountPage();
        utility.click(myAccountPage.getEditMyProfileButton());
        utility.clearAndEnterText(myAccountPage.getEditProfileFirstName(), "changedFirstName");
        utility.clearAndEnterText(myAccountPage.getEditProfileLastName(), "changedLastName");
        utility.click(myAccountPage.getEditProfileCancelButton());
        assertTrue(myAccountPage.getTextOfNameText(utility).equals(accountForm.getFirstName() + " " + accountForm.getLastName()), "Failed to match name text on profile with expected text");
        assertTrue(myAccountPage.getTextOfGenderText(utility, accountForm).equals(accountForm.getGender().substring(0, 1).toUpperCase() + accountForm.getGender().substring(1)), "Failed to match gender text on profile with expected text");

        utility.click(myAccountPage.getEditMyProfileButton());
        utility.clearAndEnterText(myAccountPage.getEditProfileFirstName(), "changedFirstName");
        utility.clearAndEnterText(myAccountPage.getEditProfileLastName(), "changedLastName");
        utility.click(myAccountPage.getEditProfileSaveButton());
        assertTrue(myAccountPage.getTextOfNameText(utility).equals("changedFirstName changedLastName"), "Failed to match name text on profile with expected text");
        assertTrue(myAccountPage.getTextOfGenderText(utility, accountForm).equals("Male"), "Failed to match gender text on profile with expected text");

        utility.click(myAccountPage.getEditMyProfileButton());
        utility.clearAndEnterText(myAccountPage.getEditProfileFirstName(), accountForm.getFirstName());
        utility.clearAndEnterText(myAccountPage.getEditProfileLastName(), accountForm.getLastName());
        utility.click(myAccountPage.getEditProfileSaveButton());
        assertTrue(myAccountPage.getTextOfNameText(utility).equals(accountForm.getFirstName() + " " + accountForm.getLastName()), "Failed to match name text on profile with expected text");
        assertTrue(myAccountPage.getTextOfGenderText(utility, accountForm).equals(accountForm.getGender().substring(0, 1).toUpperCase() + accountForm.getGender().substring(1)), "Failed to match gender text on profile with expected text");

        commonActions.logout();
    }
}