package com.sushobhan.springbootselenium.page;

import com.sushobhan.springbootselenium.annotations.LazyAutowired;
import com.sushobhan.springbootselenium.annotations.Page;
import com.sushobhan.springbootselenium.annotations.TakeScreenshot;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

@Page
public class PersonalisedPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[@data-filterable-for='dashboard-repos-filter-left']")
    private WebElement myRepo;
    @FindBy(how = How.XPATH, using = "//*[contains(@data-hydro-click,'REPOSITORIES')]")
    private List<WebElement> allRepos;

    @FindBy(how = How.XPATH, using = "//*[@class='Header-link' and @aria-haspopup='menu']")
    private List<WebElement> menuOptionsUserName;

    @FindBy(how = How.XPATH, using = "//a[@role='menuitem' and text()='Settings']")
    private WebElement settingsLink;

    @LazyAutowired
    LoginPage loginPage;

    @LazyAutowired
    HomePage homePage;

    public String getTitle() {
        return this.driver.getTitle();
    }

    public void loggedInToPersonalizedPage() {
        homePage.goToHomePage();
        homePage.goToLoginPage();
        loginPage.login("sushobhanworld@gmail.com", "amigoscode@1");
    }

    public void clickOnFirstRepo() {
        allRepos.get(2).click();
    }

    @TakeScreenshot
    @SneakyThrows
    public void navigateToPersonalAccountPage() {
        this.menuOptionsUserName.get(1).click();
        Thread.sleep(3000);
        this.settingsLink.click();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.myRepo.isDisplayed());
    }
}
