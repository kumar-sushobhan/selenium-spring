package com.sushobhan.springbootselenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Objects;

public class ElementContainsText implements ExpectedCondition<Boolean> {
    private final String textToFind;
    private final By by;

    public ElementContainsText(String textToFind, By by) {
        this.textToFind = textToFind;
        this.by = by;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        WebElement element = Objects.requireNonNull(driver).findElement(by);
        //Check that the element contains given text?
        return element.getText().contains(this.textToFind);
    }

    //This is for log message. I override it because when test fails, it will give us a meaningful message.
    @Override
    public String toString() {
        return ": \"Does " + this.by + " contain " + this.textToFind + "?\"";
    }
}
