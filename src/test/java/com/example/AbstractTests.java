package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Initialization class for all test classes.
 *
 * @author HyungCheol Kim
 * @see resources/application.yml
 *
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractTests {
    private static boolean initialized = false;

    @Autowired
    private Settings settings;

    /**
     * Initialize before test. This method executed only once.
     *
     * @see com.codeborne.selenide.Configuration
     */
    @Before
    public void initialize() {
        if (initialized) {
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        System.setProperty("selenide.browser", settings.getBrowser());
        System.setProperty("selenide.reportsFolder", settings.getScreenshotFolder() + now.format(formatter));
//        System.setProperty("selenide.isHeadless", isHeadless);//Not supported in Selenide 4.7.1

        this.initialized = true;
    }
    @Test
    public void ignoredTestMethod() {
        //avoid for java.lang.Exception: No runnable methods
    }
}
