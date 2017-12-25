package com.example;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
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
@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractTests {
    private static boolean initialized = false;

    @Value("${setting.browser}")
    String browser;

    @Value("${setting.screenshot-folder}")
    String screenshotFolder;

    @Value("${setting.headless}")
    String headless;

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

        System.setProperty("selenide.browser", browser);
        System.setProperty("selenide.reportsFolder", screenshotFolder + now.format(formatter));
        System.setProperty("selenide.headless", headless);

        this.initialized = true;
    }
}
