package com.qugenx.properties.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class UserResource {

    @Value("${app.user.firstName}")
    private String userName;

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "UserResource{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
