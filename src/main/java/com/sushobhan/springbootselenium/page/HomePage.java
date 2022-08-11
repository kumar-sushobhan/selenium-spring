package com.sushobhan.springbootselenium.page;

import com.sushobhan.springbootselenium.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;

@Page
public class HomePage extends BasePage {

    @Value("${application.url}")
    private String baseURL;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Sign in')]")
    private WebElement loginLink;

    public void goToHomePage() {
        this.driver.get(baseURL);
        this.driver.manage().window().maximize();
    }

    public void goToLoginPage() {
        clickOnWebElement(loginLink);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.loginLink.isDisplayed());
    }
}
