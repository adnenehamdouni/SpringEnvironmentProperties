package com.qugenx.properties.config;

import com.qugenx.properties.resource.UserResource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


public class TestUserResourceConfig {

    // The following bean is required to inject @Value with properties from @PropertySource
    @Bean
    public UserResource getUserResource() {
        return new UserResource();
    }
}
