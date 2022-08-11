package com.sushobhan.springbootselenium.page;

import com.sushobhan.springbootselenium.annotations.Page;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
@Page
public class LoginPage extends BasePage {
    //********* Web Elements by using Page Factory *********
    @FindBy(how = How.ID, using = "login_field")
    private WebElement userName;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    //********* Web Elements by using By Class *********
    By loginButtonBy = By.name("commit");


    //*********Page Methods*********
    @SneakyThrows
    public void login(String user, String pass) {
        writeText(this.userName, user);
        Thread.sleep(2000);
        writeText(this.password, pass);
        jsClick(loginButtonBy);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.userName.isDisplayed());
    }
}
