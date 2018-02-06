package com.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Settings {
    @Value("${default.page1}")
    private String page1;

    @Value("${default.page2}")
    private String page2;

    @Value("${setting.browser}")
    private String browser;

    @Value("${setting.screenshot-folder}")
    private String screenshotFolder;

    @Value("${setting.isHeadless}")
    private String isHeadless;
}
