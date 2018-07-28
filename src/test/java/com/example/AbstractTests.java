package com.example;

import com.example.settings.Settings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

import lombok.Getter;

/**
 * Initialization class for all test classes.
 *
 * @author HyungCheol Kim
 * @see resources/application.yml
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ExtendWith(SpringExtension.class)
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
     * Because of @BeforAll need to static method, using @BeforeEach.
     *
     * @see com.codeborne.selenide.Configuration
     * @see BeforeEach
     */
    @BeforeEach
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
    @AfterEach
    public void setTimeInterval() {
        try {
            TimeUnit.SECONDS.sleep(Long.valueOf(settings.getTimeInterval()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Disabled
    void ignoredTestMethod() {
        //avoid for java.lang.Exception: No runnable methods
    }
}
