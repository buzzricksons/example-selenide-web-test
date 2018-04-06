package com.example.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "ajax")
public class AjaxSettings {
    private String ajaxPage;
    private String time;
}
