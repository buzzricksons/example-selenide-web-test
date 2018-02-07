package com.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Settings {
    @Value("${default.googlePage}")
    private String googlePage;

    @Value("${default.yahooPage}")
    private String yahooPage;

    @Value("${setting.browser}")
    private String browser;

    @Value("${setting.screenshot-folder}")
    private String screenshotFolder;

    @Value("${setting.isHeadless}")
    private String isHeadless;
}
