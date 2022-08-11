package com.sushobhan.springbootselenium.page;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
public abstract class BasePage {
    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

   // @Autowired
   // protected JavascriptExecutor javascriptExecutor;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    public abstract boolean isAt();

    public <T> void waitForElement(T elementAttribute) {
        if (elementAttribute
                .getClass()
                .getName()
                .contains("By")) {
            wait.until(ExpectedConditions.presenceOfElementLocated((By) elementAttribute));
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttribute));
        }
    }

    public <T> void waitForElements(T elementAttribute) {
        if (elementAttribute
                .getClass()
                .getName()
                .contains("By")) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) elementAttribute));
        } else {
            wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) elementAttribute));
        }
    }

    // Click method using Java generics
    public <T> void clickOnWebElement(T elementAttribute) {
        waitForElements(elementAttribute);
        if (elementAttribute
                .getClass()
                .getName()
                .contains("By")) {
            this.driver.findElement((By) elementAttribute).click();
        } else {
            ((WebElement) elementAttribute).click();
        }
    }

    public void jsClick(By by) {
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    //Write Text by using JAVA Generics
    public <T> void writeText(T elementAttribute, String text) {
        waitForElement(elementAttribute);
        if (elementAttribute
                .getClass()
                .getName()
                .contains("By")) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) elementAttribute));
            driver.findElement((By) elementAttribute).sendKeys(text);
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttribute));
            ((WebElement) elementAttribute).sendKeys(text);
        }
    }

    //Read Text by using JAVA Generics
    public <T> String readText(T elementAttribute) {
        if (elementAttribute
                .getClass()
                .getName()
                .contains("By")) {
            return driver.findElement((By) elementAttribute).getText();
        } else {
            return ((WebElement) elementAttribute).getText();
        }
    }

    @SneakyThrows
    public <T> String readTextErrorMessage(T elementAttribute) {
        Thread.sleep(2000);
        return driver.findElement((By) elementAttribute).getText();
    }

    //Close popup if exists
    @SneakyThrows
    public void handlePopup(By by) {
        waitForElements(by);
        List<WebElement> popup = driver.findElements(by);
        if (!popup.isEmpty()) {
            popup.get(0).click();
            Thread.sleep(2000);
        }
    }
}
