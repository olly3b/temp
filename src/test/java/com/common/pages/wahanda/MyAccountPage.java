package com.common.pages.wahanda;

import com.common.forms.AccountForm;
import com.common.utility.Element;
import com.common.utility.Locator;
import com.common.utility.TestUtility;

/**
 * Created by oliver on 23/10/2014.
 */
public class MyAccountPage {

    private Element bookingsTabButton = new Element("bookings tab button", Locator.CSS, "#site-container > div > div.sticky-wrapper > div > div > ul > li:nth-child(1) > a");
    private Element walletTabButton = new Element("wallet tab button", Locator.CSS, "#site-container > div > div.sticky-wrapper > div > div > ul > li:nth-child(2) > a");
    private Element editMyProfileButton = new Element("edit my profile button", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div.section.profile > div.profile-details > div.button.other-button.edit-profile > span");
    private Element changePasswordLink = new Element("change password link", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div:nth-child(4) > span.change-password-link.link-with-icon > span.text");
    private Element checkHowOthersSeeYourProfileLink = new Element("how others see your profile link", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div.not-profile > div.section > a > span.text");

    private Element profilePicture = new Element("profile picture", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div.section.profile > div.profile-image > img");
    private Element nameText = new Element("first name text", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div.section.profile > div.profile-details > span");
    private Element femaleGenderText = new Element("female gender text", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div.section.profile > div.profile-details > div.gender.female");
    private Element maleGenderText = new Element("male gender text", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div.section.profile > div.profile-details > div.gender.male");
    private Element emailText = new Element("email text", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div:nth-child(4) > strong");
    private Element profileText = new Element("profile text", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div.not-profile > div.section > span.profile-name > strong");

    private Element editProfileFirstName = new Element("edit profile first name", Locator.NAME, "first-name");
    private Element editProfileLastName = new Element("edit profile last name", Locator.NAME, "last-name");
    private Element editProfileGenderSelecter = new Element("edit profile gender selecter", Locator.ID, "ui-selectmenu-d78ec15b-button");
    private Element editProfileGenderFemaleOption = new Element("edit profile gender female option", Locator.CSS, "#ui-selectmenu-12a1516b-menu > li:nth-child(1) > a");
    private Element editProfileGenderMaleOption = new Element("edit profile gender male option", Locator.CSS, "#ui-selectmenu-item-975");
    private Element editProfileGenderUndisclosedOption = new Element("edit profile gender undisclosed option", Locator.CSS, "#ui-selectmenu-12a1516b-menu > li.ui-corner-bottom > a");
    private Element editProfileSaveButton = new Element("edit profile save button", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div.section-aside.profile-form > div.profile-details > form > span.button.main-button.save");
    private Element editProfileCancelButton = new Element("edit profile cancel button", Locator.CSS, "#site-container > div > div.wrapper.main-content > div.section-aside.left.account-summary > div.section-aside.profile-form > div.profile-details > form > span.button.other-button.cancel");

    public String getTextOfNameText(TestUtility utility) {
        return utility.getText(nameText);
    }

    public String getTextOfEmailText(TestUtility utility) {
        return utility.getText(emailText);
    }

    public String getTextOfProfileText(TestUtility utility) {
        return utility.getText(profileText);
    }

    public String getTextOfGenderText(TestUtility utility, AccountForm accountForm) {
        if (accountForm.getGender().equals("male")) {
            return utility.getText(maleGenderText);
        } else {
            return utility.getText(femaleGenderText);
        }
    }

    public Element getEditMyProfileButton() {
        return editMyProfileButton;
    }

    public Element getNameText() {
        return nameText;
    }

    public Element getFemaleGenderText() {
        return femaleGenderText;
    }

    public Element getMaleGenderText() {
        return maleGenderText;
    }

    public Element getEmailText() {
        return emailText;
    }

    public Element getProfileText() {
        return profileText;
    }

    public Element getBookingsTabButton() {
        return bookingsTabButton;
    }

    public Element getWalletTabButton() {
        return walletTabButton;
    }

    public Element getProfilePicture() {
        return profilePicture;
    }

    public Element getCheckHowOthersSeeYourProfileLink() {
        return checkHowOthersSeeYourProfileLink;
    }

    public Element getChangePasswordLink() {
        return changePasswordLink;
    }

    public Element getEditProfileFirstName() {
        return editProfileFirstName;
    }

    public Element getEditProfileLastName() {
        return editProfileLastName;
    }

    public Element getEditProfileGenderSelecter() {
        return editProfileGenderSelecter;
    }

    public Element getEditProfileGenderFemaleOption() {
        return editProfileGenderFemaleOption;
    }

    public Element getEditProfileGenderMaleOption() {
        return editProfileGenderMaleOption;
    }

    public Element getEditProfileGenderUndisclosedOption() {
        return editProfileGenderUndisclosedOption;
    }

    public Element getEditProfileSaveButton() {
        return editProfileSaveButton;
    }

    public Element getEditProfileCancelButton() {
        return editProfileCancelButton;
    }
}
