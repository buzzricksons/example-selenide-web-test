package com.example.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "search")
public class SearchSettings {
    private String googlePage;
    private String yahooPage;
    private String naverPage;
}
