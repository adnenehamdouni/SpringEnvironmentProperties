package com.qugenx.properties.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ConfigPropertiesResource {

    @Value("${app.name}")
    private String appName;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment env;

    public String getConfigValue(String configKey){
        return env.getProperty(configKey);
    }

    public String getAppName() {
        return appName;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    @Override
    public String toString() {
        return "ConfigPropertiesResource{" +
                "appName='" + appName + '\'' +
                ", buildVersion='" + buildVersion + '\'' +
                ", env=" + env +
                '}';
    }
}
