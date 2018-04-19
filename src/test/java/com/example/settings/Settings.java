package com.example.settings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
@Component
public class Settings {
    /**
     * When test failed, schreenshot and html file saved in this folder.
     */
    @Value("${setting.screenshot-folder}")
    private String screenshotFolder;

    /**
     * If you use HeadlessChrome then set true.
     */
    @Value("${setting.isHeadless}")
    private String isHeadless;

    /**
     * Set time interval for each test class ended.
     */
    @Value("${setting.timeInterval}")
    private String timeInterval;

    @Value("${setting.browser}")
    private String browser;

    /**
     * Set time out of each test case.
     * If there is no timeout setting then 4 secondes(4000) is used.
     */
    @Value("${setting.timeOut}")
    private String timeOut;
}
