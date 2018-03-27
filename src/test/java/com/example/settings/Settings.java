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
     * ※Not yet supported.
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
}
