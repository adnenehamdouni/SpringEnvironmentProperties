package com.qugenx.properties.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ActiveProfileResource {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    public String getActiveProfile() {
        return activeProfile;
    }

    @Override
    public String toString() {
        return "ActiveProfileResource{" +
                "activeProfile='" + activeProfile + '\'' +
                '}';
    }
}
