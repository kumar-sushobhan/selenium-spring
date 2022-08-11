package com.sushobhan.springbootselenium.utils;

import com.sushobhan.springbootselenium.annotations.LazyComponent;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@LazyComponent
public class WindowSwitchUtil {
    @Autowired
    private ApplicationContext applicationContext;

    public void switchByTitle(final String title) {
        WebDriver driver = this.applicationContext.getBean(WebDriver.class);
        driver.getWindowHandles()
                .stream()
                .map(handle -> driver.switchTo().window(handle).getTitle())
                .filter(t -> t.startsWith(t))
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("There is no such window available.");
                });
    }

    public void switchByIndex(final int index) {
        WebDriver driver = this.applicationContext.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);
    }
}
