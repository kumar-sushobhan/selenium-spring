package com.sushobhan.springbootselenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:feature",
        glue = "com.sushobhan.springbootselenium",
        plugin = {
                "pretty",
                "html:target/cucumber/report.html"
        },
        monochrome = true
        //tags = "@Settings"
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
