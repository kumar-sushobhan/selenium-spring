package com.sushobhan.springbootselenium.bdd;

import com.sushobhan.springbootselenium.annotations.LazyAutowired;
import com.sushobhan.springbootselenium.page.HomePage;
import com.sushobhan.springbootselenium.page.LoginPage;
import com.sushobhan.springbootselenium.page.MyRepositoriesPage;
import com.sushobhan.springbootselenium.page.PersonalisedPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginCredentialsSteps {
    @LazyAutowired
    private HomePage homePage;
    @LazyAutowired
    private LoginPage loginPage;
    @LazyAutowired
    private PersonalisedPage personalisedPage;
    @LazyAutowired
    private MyRepositoriesPage myRepositoriesPage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        this.homePage.goToHomePage();
        Assert.assertTrue(this.homePage.isAt());
    }

    @Then("I click on SignIn button on Homepage")
    public void iClickOnSignInButtonOnHomepage() {
        this.homePage.goToLoginPage();
    }

    @And("I enter username as {string}, password as {string} and click on SignIn button")
    public void iEnterUsernameAsPasswordAsAndClickOnSignInButton(String username, String password) {
        this.loginPage.login(username, password);
    }

    @Then("I am on the personalized page")
    public void iAmOnThePersonalizedPage() {
        Assert.assertTrue(this.personalisedPage.isAt());
        Assert.assertEquals("GitHub", this.personalisedPage.getTitle());
    }

    @Given("I am logged in and on the personalized page")
    public void iAmLoggedInAndOnThePersonalizedPage() {

        personalisedPage.loggedInToPersonalizedPage();
        Assert.assertTrue(this.personalisedPage.isAt());
    }

    @Then("I click on the first repository")
    public void iClickOnTheFirstRepository() {
        this.personalisedPage.clickOnFirstRepo();
    }

    @And("I print the title of the page")
    public void iPrintTheTitleOfThePage() {
        Assert.assertTrue(this.myRepositoriesPage.isAt());
        System.out.println("Title : " + this.myRepositoriesPage.printPageTitle());
    }
}
