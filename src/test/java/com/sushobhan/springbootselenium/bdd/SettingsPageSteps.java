package com.sushobhan.springbootselenium.bdd;

import com.sushobhan.springbootselenium.annotations.LazyAutowired;
import com.sushobhan.springbootselenium.page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SettingsPageSteps {
    @LazyAutowired
    PersonalisedPage personalisedPage;
    @LazyAutowired
    PersonalAccountPage personalAccountPage;
    @LazyAutowired
    PersonalAccountComponentPage personalAccountComponentPage;
    @LazyAutowired
    PersonalBilling personalBilling;
    @LazyAutowired
    EmailSettings emailSettings;

    @And("I navigate to Settings page from username section")
    public void iNavigateToSettingsPageFromUsernameSection() {
        personalisedPage.navigateToPersonalAccountPage();
        Assert.assertTrue(this.personalAccountPage.isAt());
    }

    @Then("I click on Billings and Plans section")
    public void iClickOnBillingsAndPlansSection() {
        this.personalAccountPage.navigateToPersonalBilling();
        this.personalBilling.isAt();
    }

    @Then("I am on the personal billing page")
    public void iAmOnThePersonalBillingPage() {
        Assert.assertEquals(this.personalBilling.getTitleBillingPage(), "Billing");
    }

    @Then("I click on Emails section")
    public void iClickOnEmailsSection() {
        this.personalAccountPage.navigateToEmailSettings();
        this.emailSettings.isAt();
    }

    @Then("I am on the Email Settings page")
    public void iAmOnTheEmailSettingsPage() {
        Assert.assertEquals(this.emailSettings.getTitleEmailsPage(), "Email settings");
    }
}
