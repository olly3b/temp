package com.wahanda.pages.wahanda;

import com.wahanda.utility.Element;
import com.wahanda.utility.Locator;

/**
 * Created by oliver on 23/10/2014.
 */
public class ChangePasswordPage {
    private Element oldPassword = new Element("old password text box", Locator.ID, "old-password");
    private Element newPassword = new Element("new password text box", Locator.ID, "new-password");
    private Element verifyPassword = new Element("verify password text box", Locator.ID, "new-password2");
    private Element submitButton = new Element("password submit button", Locator.CSS, "#change-password-form > div.actions.columns > button");
    private Element passwordReminderLink = new Element("password reminder link", Locator.CSS, "#contextual-change-password-forgot-password > a > span.text");

    private Element oldPasswordIsIncorrentMessage = new Element("old password is incorrect message", Locator.CSS, "#change-password-form > div.actions.columns > div > span");
    private Element atLeast6CharactersMessage = new Element("at least 6 characters message", Locator.CSS, "#change-password-form > div:nth-child(3) > div > div > span");
    private Element newPasswordCannotBeTheSameMessage = new Element("new password cannot be the same message", Locator.CSS, "#change-password-form > div:nth-child(3) > div > div > span");
    private Element verifyPasswordDoesNotMatchMessage = new Element("verify password does not match", Locator.CSS, "#change-password-form > div:nth-child(4) > div > div > span");

    private Element changeSuccessText = new Element("change success text", Locator.CSS, "#change-password-popup > div > div > p");
    private Element closeButton = new Element("close button", Locator.CSS, "body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.wahanda-popup > div.ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix > a");

    public Element getVerifyPasswordDoesNotMatchMessage() {
        return verifyPasswordDoesNotMatchMessage;
    }

    public Element getChangeSuccessText() {
        return changeSuccessText;
    }

    public Element getCloseButton() {
        return closeButton;
    }

    public Element getNewPasswordCannotBeTheSameMessage() {
        return newPasswordCannotBeTheSameMessage;
    }

    public Element getAtLeast6CharactersMessage() {
        return atLeast6CharactersMessage;
    }

    public Element getOldPasswordIsIncorrentMessage() {
        return oldPasswordIsIncorrentMessage;
    }

    public Element getPasswordReminderLink() {
        return passwordReminderLink;
    }

    public Element getSubmitButton() {
        return submitButton;
    }

    public Element getOldPassword() {
        return oldPassword;
    }

    public Element getNewPassword() {
        return newPassword;
    }

    public Element getVerifyPassword() {
        return verifyPassword;
    }


}
