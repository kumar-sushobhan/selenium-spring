package com.sushobhan.springbootselenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public class LogUtil {
    public static LogEntries getLogs(WebDriver driver){
        return driver.manage().logs().get(LogType.DRIVER);
    }
}
