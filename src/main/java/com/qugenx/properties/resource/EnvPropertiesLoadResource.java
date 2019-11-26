package com.qugenx.properties.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@PropertySource("classpath:application.properties")
public class EnvPropertiesLoadResource {

    @Value("${application.filter.name:}")
    //@Value("${application.filter.name}")
    private String filterModeName;

    public String getFilterModeName() {
        return filterModeName;
    }

    @Override
    public String toString() {
        return "EnvPropertiesLoadResource{" +
                "filterModeName='" + filterModeName + '\'' +
                '}';
    }
}
