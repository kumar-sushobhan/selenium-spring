package com.sushobhan.springbootselenium.aop;

import com.sushobhan.springbootselenium.annotations.TakeScreenshot;
import com.sushobhan.springbootselenium.utils.ScreenshotUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {
    @Autowired
    private ScreenshotUtil screenshotUtil;

    @After("@annotation(takeScreenshot)")
    public void after(JoinPoint joinPoint, TakeScreenshot takeScreenshot) throws IOException {
        this.screenshotUtil.takeScreenShot(joinPoint.getSignature().getName());
    }
}
