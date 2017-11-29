package com.example.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class TestConfig {

    @Value("{environment.servers}")
    private String servers;
    @Value("{environment.name}")
    private String name;
}
