package com.wahanda.pages.wahanda;

import com.wahanda.forms.AccountForm;
import com.wahanda.utility.Element;
import com.wahanda.utility.Locator;
import com.wahanda.utility.TestUtility;

/**
 * Created by oliver on 23/10/2014.
 */
public class CreateProfilePage {
    private Element emailTextBox = new Element("email text box", Locator.ID, "email-address");
    private Element passwordTextBox = new Element("password text box", Locator.ID, "password");
    private Element firstNameTextBox = new Element("first name text box", Locator.ID, "first-name");
    private Element lastNameTextBox = new Element("last name text box", Locator.ID, "last-name");
    private Element profileNameTextBox = new Element("profile name text box", Locator.ID, "display-name");
    private Element postcodeTextBox = new Element("postcode text box", Locator.ID, "postal-ref");
    private Element genderMaleRadio = new Element("male radio", Locator.ID, "genderMale");
    private Element genderFemaleRadio = new Element("female radio", Locator.ID, "genderFemale");
    private Element newsletterRadio = new Element("newsletter radio", Locator.ID, "newsletter");
    private Element termsAndConditionsLink = new Element("terms and conditions link", Locator.CSS, "#register-form > div.fields > div.actions > div.small-12.medium-8.large-8.columns > p > a");
    private Element joinWahandaButton = new Element("join wahanda button", Locator.CSS, "#register-form > div.fields > div.actions > div.small-12.medium-4.large-4.columns > button > span.primary-text");

    public void fillAccountDetails(TestUtility utility, AccountForm accountForm) {
        utility.enterText(emailTextBox, accountForm.getEmail());
        utility.enterText(passwordTextBox, accountForm.getPassword());
        utility.enterText(firstNameTextBox, accountForm.getFirstName());
        utility.enterText(lastNameTextBox, accountForm.getLastName());
        utility.enterText(profileNameTextBox, accountForm.getProfileName());
        utility.enterText(postcodeTextBox, accountForm.getPostcode());
        if (accountForm.getGender().equals("male")) {
            utility.jsClick(genderMaleRadio);
        } else {
            utility.jsClick(genderFemaleRadio);
        }
    }

    public Element getPasswordTextBox() {
        return passwordTextBox;
    }

    public Element getFirstNameTextBox() {
        return firstNameTextBox;
    }

    public Element getLastNameTextBox() {
        return lastNameTextBox;
    }

    public Element getProfileNameTextBox() {
        return profileNameTextBox;
    }

    public Element getPostcodeTextBox() {
        return postcodeTextBox;
    }

    public Element getGenderMaleRadio() {
        return genderMaleRadio;
    }

    public Element getGenderFemaleRadio() {
        return genderFemaleRadio;
    }

    public Element getNewsletterRadio() {
        return newsletterRadio;
    }

    public Element getTermsAndConditionsLink() {
        return termsAndConditionsLink;
    }

    public Element getJoinWahandaButton() {
        return joinWahandaButton;
    }

    public Element getEmailTextBox() {
        return emailTextBox;
    }
}
