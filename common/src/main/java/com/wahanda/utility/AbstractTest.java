package com.wahanda.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.URL;

public abstract class AbstractTest {
    public static WebDriver driver;
    public static String browserDescription;
    public static TestUtility utility;

    private final Logger LOG = Logger.getLogger(AbstractTest.class);

    public CommonActions commonActions = new CommonActions();

    public static int EXPLICIT_TIMEOUT = 30;

    @Parameters({"hubHost", "hubPort", "browserId", "version"})
    @BeforeClass
    public void setUp(final String hubHost, final int hubPort, final String browserId, final String version) throws Exception {

        DesiredCapabilities browser = new DesiredCapabilityFactory().create(Browser.lookupBrowserBy(browserId));
        browser.setVersion(version);

        if (browserId.equals(Browser.FIREFOX.getId())) {
            FirefoxProfile firefoxprofile = new FirefoxProfile();
            firefoxprofile.setAssumeUntrustedCertificateIssuer(false);

            browser.setCapability(FirefoxDriver.PROFILE, firefoxprofile);
        } else {
            browser.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        }

        if (browserId.equals(Browser.SAFARI.getId())) {
            SafariOptions options = new SafariOptions();
            options.setDataDir(new File("/Applications"));
            options.setUseCleanSession(true);
            browser.setCapability(SafariOptions.CAPABILITY, options);
        }

        driver = new RemoteWebDriver(new URL("http://" + hubHost + ":" + hubPort + "/wd/hub"), browser);
        browserDescription = browserId + " " + version + ": ";
        utility = new TestUtility();
    }

    @AfterClass
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
