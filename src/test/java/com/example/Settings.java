package com.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
@Component
public class Settings {
    @Value("${setting.screenshot-folder}")
    private String screenshotFolder;

    @Value("${setting.isHeadless}")
    private String isHeadless;

    @Value("${setting.timeInterval}")
    private String timeInterval;

    @Value("${search.googlePage}")
    private String googlePage;

    @Value("${search.yahooPage}")
    private String yahooPage;

    @Value("${search.naverPage}")
    private String naverPage;

    @Value("${setting.browser}")
    private String browser;

    @Value("${ajax.examplePage1}")
    private String ajaxExamplePage1;
}
