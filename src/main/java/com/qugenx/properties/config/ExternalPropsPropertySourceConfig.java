package com.qugenx.properties.config;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

@Configuration
@PropertySource("classpath:testing.properties")
public class ExternalPropsPropertySourceConfig {


    //Spring 3.X config
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
        final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        return pspc;
    }

    //Old Way
    /*@Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() throws IOException {
        final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(ArrayUtils.addAll(
                //new PathMatchingResourcePatternResolver().getResources("classpath*:application.properties"),
                new PathMatchingResourcePatternResolver().getResources("classpath:business-test.properties")
                )
        );

        return ppc;
    }*/


}
