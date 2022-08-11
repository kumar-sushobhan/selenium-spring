package com.sushobhan.springbootselenium.page;

import com.sushobhan.springbootselenium.annotations.LazyAutowired;
import com.sushobhan.springbootselenium.annotations.Page;

@Page
public class PersonalAccountPage extends BasePage {
    @LazyAutowired
    private PersonalAccountComponentPage personalAccountComponentPage;

    public void navigateToPersonalBilling() {
        this.personalAccountComponentPage.clickOnBillingPlanOption();
    }

    public void navigateToEmailSettings() {
        this.personalAccountComponentPage.clickOnEmailOption();
    }

    @Override
    public boolean isAt() {
        return this.personalAccountComponentPage.isAt();
    }
}
