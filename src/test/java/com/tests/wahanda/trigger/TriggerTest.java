package com.tests.wahanda.trigger;

import com.common.pages.wahanda.HomePage;
import com.common.utility.AbstractTest;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

/**
 * Created by oliver on 24/10/2014.
 */
public class TriggerTest extends AbstractTest {

    private final Logger LOG = Logger.getLogger(TriggerTest.class);

    @Test
    public void checkForNewVersion() {

        File file = new File("src/test/java/com/tests/wahanda/trigger/version.txt");

        String oldVersion = "";
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            oldVersion = input.readLine();
            input.close();
            LOG.info("Reading last version from file: version=" + oldVersion);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HomePage homePage = new HomePage();
        homePage.open();

        String newVersion = homePage.getVersionText();
        LOG.info("Current version displayed as: version=" + newVersion);
        try {
            assertFalse(oldVersion.equals(newVersion));
            LOG.info("New version detected");
            try {
                BufferedWriter output = new BufferedWriter(new FileWriter(file));
                output.write(newVersion);
                output.close();
                LOG.info("File updated");
            } catch (IOException i) {
                i.printStackTrace();
            }
        } catch(AssertionError e) {
            LOG.info("No new version detected");
            fail();
        }
    }
}
