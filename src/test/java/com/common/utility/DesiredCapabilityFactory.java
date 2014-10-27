package com.common.utility;

import com.common.utility.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;

public final class DesiredCapabilityFactory
{
    public DesiredCapabilities create(final Browser browser)
    {
        switch(browser) {
            case FIREFOX:
                return DesiredCapabilities.firefox();
            case GOOGLE_CHROME:
                return DesiredCapabilities.chrome();
            case INTERNET_EXPLORER:
                return DesiredCapabilities.internetExplorer();
            case SAFARI:
                return DesiredCapabilities.safari();
            default:
                throw new IllegalArgumentException("Unknown browser: " + browser);
        }
    }
}