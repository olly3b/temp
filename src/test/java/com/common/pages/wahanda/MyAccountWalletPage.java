package com.common.pages.wahanda;

import com.common.utility.Element;
import com.common.utility.Locator;
import com.common.utility.TestUtility;

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
