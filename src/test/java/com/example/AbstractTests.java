package com.example;

import com.example.settings.Settings;
import lombok.Getter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * Initialization class for all test classes.
 *
 * @author HyungCheol Kim
 * @see resources/application.yml
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractTests {
    /**
     * If setting value existed, Selenide setting executed.
     *
     */
    private final BiConsumer<String, String> initSetting = (k, v) -> Optional.of(v)
            .filter(value -> !value.isEmpty())
            .ifPresent(value -> System.setProperty(String.format("selenide.%s", k), value));

    /**
     * Singleton.
     */
    private static boolean notInitialized = true;

    @Getter
    @Autowired
    private Settings settings;

    /**
     * Initialize before test. This method executed only once.
     *
     * @see com.codeborne.selenide.Configuration
     */
    @Before
    public void initialize() {
        Optional.of(notInitialized)
                .filter(Boolean::booleanValue)
                .ifPresent((b) -> {
                    initSetting.accept("reportsFolder", settings.getScreenshotFolder() + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
                    initSetting.accept("headless", settings.getIsHeadless());
                    initSetting.accept("browser", settings.getBrowser());
                    initSetting.accept("timeout", settings.getTimeOut());
                    this.notInitialized = false;
                });
    }

    /**
     * Set time interval at every test ended.
     */
    @After
    public void setTimeInterval() {
        try {
            TimeUnit.SECONDS.sleep(Long.valueOf(settings.getTimeInterval()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ignoredTestMethod() {
        //avoid for java.lang.Exception: No runnable methods
    }
}
