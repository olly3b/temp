package com.wahanda.pages.wahanda;

import com.wahanda.utility.Element;
import com.wahanda.utility.Locator;

/**
 * Created by oliver on 23/10/2014.
 */
public class AccountHeaderPage {
    private Element signUpButton = new Element("sign up button", Locator.CSS, "#header-login > div > div.sign-up > a");
    private Element emailTextBox = new Element("email text box", Locator.CSS, "#header-login > div > form > div:nth-child(1) > div.txt-input > input");
    private Element passwordTextBox = new Element("password text box", Locator.CSS, "#header-login > div > form > div:nth-child(2) > div > input");
    private Element loginButton = new Element("login button", Locator.CSS, "#header-login > div > form > div.button.main-button.a-login");

    public Element getSignUpButton() {
        return signUpButton;
    }

    public Element getEmailTextBox() {
        return emailTextBox;
    }

    public Element getPasswordTextBox() {
        return passwordTextBox;
    }

    public Element getLoginButton() {
        return loginButton;
    }
}
