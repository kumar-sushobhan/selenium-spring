package com.sushobhan.springbootselenium.page;

import com.sushobhan.springbootselenium.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Page
public class PersonalBilling extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Personal billing')]")
    private WebElement billingText;

    public String getTitleBillingPage() {
        return this.driver.getTitle();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.billingText.isDisplayed());
    }
}
