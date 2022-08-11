package com.sushobhan.springbootselenium.page;

import com.sushobhan.springbootselenium.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Page
public class EmailSettings extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Add email')]")
    private WebElement addEmailAddress;

    public String getTitleEmailsPage() {
        return this.driver.getTitle();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.addEmailAddress.isDisplayed());
    }
}
