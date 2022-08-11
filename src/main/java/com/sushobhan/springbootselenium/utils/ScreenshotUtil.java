package com.sushobhan.springbootselenium.utils;

import com.sushobhan.springbootselenium.annotations.LazyComponent;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.nio.file.Path;

@LazyComponent
public class ScreenshotUtil {
    @Autowired
    private ApplicationContext applicationContext;

    @Value("${screenshot.path}")
    private Path path;

    @SneakyThrows
    public void takeScreenShot(String testName) {
        File sourceFile = this.applicationContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, this.path.resolve(testName + ".png").toFile());
    }

    public byte[] getScreenshot() {
        return this.applicationContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}
