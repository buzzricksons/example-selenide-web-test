package com.example;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractTests {
    private static boolean initialized = false;

    @Value("${setting.browser}")
    String browser;

    @Value("${setting.screenshot-folder}")
    String screenshotFolder;

    @Before
    public void initialize() {
        if (initialized) {
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        //System is com.codeborne.selenide.Configuration.class
        System.setProperty("selenide.browser", browser);
        System.setProperty("selenide.reportsFolder", screenshotFolder + now.format(formatter));

        this.initialized = true;
    }
}
