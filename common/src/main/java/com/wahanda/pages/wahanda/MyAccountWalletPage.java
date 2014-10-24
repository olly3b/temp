package com.wahanda.pages.wahanda;

import com.wahanda.utility.Element;
import com.wahanda.utility.Locator;
import com.wahanda.utility.TestUtility;

/**
 * Created by oliver on 23/10/2014.
 */
public class MyAccountWalletPage {

    private Element centreBlock = new Element("wallet centre block", Locator.CSS, "#wallet > div > div");

    public String getTextOfCentreBlock(TestUtility utility) {
        return utility.getText(centreBlock);
    }

    public Element getCentreBlock() {
        return centreBlock;
    }
}
