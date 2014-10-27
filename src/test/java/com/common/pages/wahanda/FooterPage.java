package com.common.pages.wahanda;

import com.common.utility.Element;
import com.common.utility.Locator;

/**
 * Created by oliver.bray on 20/10/2014.
 */
public class FooterPage {

    private Element followUsFaceBook = new Element("footer faceboox link", Locator.CSS, "#footer > div.wrapper > div.nav-group.left.social > a:nth-child(2)");
    private Element followUsTwitter = new Element("footer twitter link", Locator.CSS, "#footer > div.wrapper > div.nav-group.left.social > a:nth-child(3)");
    private Element followUsPinterest = new Element("footer pinterest link", Locator.CSS, "#footer > div.wrapper > div.nav-group.left.social > a:nth-child(4)");
    private Element followUsGooglePlus = new Element("footer google plus link", Locator.CSS, "#footer > div.wrapper > div.nav-group.left.social > a:nth-child(5)");
    private Element followUsInstagram= new Element("footer instagram link", Locator.CSS, "#footer > div.wrapper > div.nav-group.left.social > a:nth-child(6)");
    private Element followUsYouTube = new Element("footer youtube link", Locator.CSS, "#footer > div.wrapper > div.nav-group.left.social > a:nth-child(7)");
    private Element followUsLinkedIn = new Element("footer linked in link", Locator.CSS, "#footer > div.wrapper > div.nav-group.left.social > a:nth-child(8)");

    private Element discoverDownloadOurApp = new Element("footer download app link", Locator.CSS, "#footer > div.wrapper > div:nth-child(2) > div > ul > li:nth-child(1) > a");
    private Element discoverGiftVoucher = new Element("footer gift voucher link", Locator.CSS, "#footer > div.wrapper > div:nth-child(2) > div > ul > li:nth-child(2) > a");
    private Element discoverCommunity = new Element("footer community link", Locator.CSS, "#footer > div.wrapper > div:nth-child(2) > div > ul > li:nth-child(3) > a");
    private Element discoverInspiration = new Element("footer inspiration link", Locator.CSS, "#footer > div.wrapper > div:nth-child(2) > div > ul > li:nth-child(4) > a");
    private Element discoverTreatmentsAtoZ = new Element("footer treatments A to Z link", Locator.CSS, "#footer > div.wrapper > div:nth-child(2) > div > ul > li:nth-child(5) > a");

    private Element servicesVerifyAVoucher = new Element("footer verify a voucher link", Locator.CSS, "#footer > div.wrapper > div:nth-child(4) > div > ul > li:nth-child(1) > a");
    private Element servicesGetYourVenueListed = new Element("footer get your venues listed link", Locator.CSS, "#footer > div.wrapper > div:nth-child(4) > div > ul > li:nth-child(2) > a");
    private Element servicesBusinessBlog = new Element("footer business blog link", Locator.CSS, "#footer > div.wrapper > div:nth-child(4) > div > ul > li:nth-child(3) > a");
    private Element servicesAffiliates = new Element("footer affiliates link", Locator.CSS, "#footer > div.wrapper > div:nth-child(4) > div > ul > li:nth-child(4) > a");
    private Element servicesSignUpToOurNewsLetter = new Element("footer newletter signup link", Locator.CSS, "#footer > div.wrapper > div:nth-child(4) > div > ul > li:nth-child(5) > a");

    private Element companyHelpContactUs = new Element("footer contact us link", Locator.CSS, "#footer > div.wrapper > div:nth-child(3) > div > ul > li:nth-child(1) > a");
    private Element companyAboutUs = new Element("footer about us link", Locator.CSS, "#footer > div.wrapper > div:nth-child(4) > div > ul > li:nth-child(2) > a");
    private Element companyPress = new Element("footer press link", Locator.CSS, "#footer > div.wrapper > div:nth-child(3) > div > ul > li:nth-child(3) > a");
    private Element companyWeAreHiring = new Element("footer we are hiring link", Locator.CSS, "#footer > div.wrapper > div:nth-child(3) > div > ul > li:nth-child(4) > a");
    private Element companyLegal = new Element("footer legal link", Locator.CSS, "#footer > div.wrapper > div:nth-child(3) > div > ul > li:nth-child(5) > a");

    public Element getFollowUsFaceBook() {
        return followUsFaceBook;
    }

    public Element getFollowUsTwitter() {
        return followUsTwitter;
    }

    public Element getFollowUsPinterest() {
        return followUsPinterest;
    }

    public Element getFollowUsGooglePlus() {
        return followUsGooglePlus;
    }

    public Element getFollowUsInstagram() {
        return followUsInstagram;
    }

    public Element getFollowUsYouTube() {
        return followUsYouTube;
    }

    public Element getFollowUsLinkedIn() {
        return followUsLinkedIn;
    }

    public Element getDiscoverDownloadOurApp() {
        return discoverDownloadOurApp;
    }

    public Element getDiscoverGiftVoucher() {
        return discoverGiftVoucher;
    }

    public Element getDiscoverCommunity() {
        return discoverCommunity;
    }

    public Element getDiscoverInspiration() {
        return discoverInspiration;
    }

    public Element getDiscoverTreatmentsAtoZ() {
        return discoverTreatmentsAtoZ;
    }

    public Element getServicesVerifyAVoucher() {
        return servicesVerifyAVoucher;
    }

    public Element getServicesGetYourVenueListed() {
        return servicesGetYourVenueListed;
    }

    public Element getServicesBusinessBlog() {
        return servicesBusinessBlog;
    }

    public Element getServicesAffiliates() {
        return servicesAffiliates;
    }

    public Element getServicesSignUpToOurNewsLetter() {
        return servicesSignUpToOurNewsLetter;
    }

    public Element getCompanyHelpContactUs() {
        return companyHelpContactUs;
    }

    public Element getCompanyAboutUs() {
        return companyAboutUs;
    }

    public Element getCompanyPress() {
        return companyPress;
    }

    public Element getCompanyWeAreHiring() {
        return companyWeAreHiring;
    }

    public Element getCompanyLegal() {
        return companyLegal;
    }
}
