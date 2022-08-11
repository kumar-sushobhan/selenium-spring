package com.sushobhan.springbootselenium.configuration;

import com.sushobhan.springbootselenium.annotations.LazyConfiguration;
import com.sushobhan.springbootselenium.annotations.BrowserScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@Profile("grid")
@LazyConfiguration
public class RemoteWebDriverConfig {
    @Value("${selenium.grid.url}")
    private URL url;

    @BrowserScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new RemoteWebDriver(this.url, firefoxOptions);
    }

    @BrowserScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver remoteEdgeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        return new RemoteWebDriver(this.url, edgeOptions);
    }

    @BrowserScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver remoteChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        return new RemoteWebDriver(this.url, chromeOptions);
    }
}
