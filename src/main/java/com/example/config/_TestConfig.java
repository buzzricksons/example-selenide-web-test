package com.example.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
public class _TestConfig {

    @Value("{environment.servers}")
    private String servers;
    @Value("{environment.name}")
    private String name;
}
