package com.sushobhan.springbootselenium.page;

import com.sushobhan.springbootselenium.annotations.PageFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@PageFragment
public class PersonalAccountComponentPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Billing and plans')]")
    private WebElement billingAndPlans;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Emails')]")
    private WebElement email;

    public void clickOnBillingPlanOption() {
        this.billingAndPlans.click();
    }

    public void clickOnEmailOption() {
        this.email.click();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.billingAndPlans.isDisplayed());
    }
}
