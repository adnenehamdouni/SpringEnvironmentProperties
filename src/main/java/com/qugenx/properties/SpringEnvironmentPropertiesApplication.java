package com.qugenx.properties;

import com.qugenx.properties.resource.PropsModelResource;
import com.qugenx.properties.resource.ConfigPropertiesResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringEnvironmentPropertiesApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(SpringEnvironmentPropertiesApplication.class);

    @Autowired
    private PropsModelResource propsModelResource;

    @Autowired
    ConfigPropertiesResource configProp;

    public static void main(String[] args) {
        SpringApplication.run(SpringEnvironmentPropertiesApplication.class, args);
    }

    @PostConstruct
    private void init(){
        LOG.info("Spring Boot init - AppName: " + propsModelResource.getAppUrl());
    }


    @Override
    public void run(String... args) throws Exception {
        LOG.info("EXECUTING : command line runner from configProp => buildVersion by env " +
                        "= {} and buildVersion by props = {} with appName = {} using application.properties",
                configProp.getConfigValue("build.version"),
                configProp.getBuildVersion(),
                configProp.getAppName());

        LOG.info("EXECUTING : command line runner propsModelResource appUrl = {} using testing.properties",
                propsModelResource.getAppUrl());

    }
}
