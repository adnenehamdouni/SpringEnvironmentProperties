package com.qugenx.properties.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:testing.properties")
public class PropsModelResource {

    @Value("${application.url}")
    private String appUrl;

    public String getAppUrl() {
        return appUrl;
    }

    @Override
    public String toString() {
        return "PropsModel{" +
                "appUrl='" + appUrl + '\'' +
                '}';
    }
}
