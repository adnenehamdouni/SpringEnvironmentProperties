package com.qugenx.properties.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan(basePackages = {"com.qugenx.properties"})
@PropertySource({"classpath:/environment-configuration.properties"})
public class BusinessConfig {

}
