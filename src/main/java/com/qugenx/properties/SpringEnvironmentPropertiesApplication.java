package com.qugenx.properties;

import com.qugenx.properties.resource.EnvPropertiesLoadResource;
import com.qugenx.properties.resource.PropsModelResource;
import com.qugenx.properties.resource.ConfigPropertiesResource;
import com.qugenx.properties.resource.UserResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;

@SpringBootApplication
/**
 * As of Spring Boot 2.2, Spring finds and registers @ConfigurationProperties
 * classes via classpath scanning. Therefore, there is no need to annotate such
 * classes with @Component (and other meta-annotations like @Configuration) or
 * even use the @EnableConfigurationProperties
 *
 * Also, we can use the @ConfigurationPropertiesScan annotation to scan custom
 * locations for configuration property classes
 */
@EnableConfigurationProperties(ConfigProperties.class)
//@ConfigurationPropertiesScan("com.baeldung.properties")
public class SpringEnvironmentPropertiesApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(SpringEnvironmentPropertiesApplication.class);

    @Autowired
    private PropsModelResource propsModelResource;

    @Autowired
    ConfigPropertiesResource configProp;

    @Autowired
    private UserResource userResource;

    @Autowired
    private EnvPropertiesLoadResource envPropertiesLoadResource;

    public static void main(String[] args) {
        SpringApplication.run(SpringEnvironmentPropertiesApplication.class, args);
    }

    @PostConstruct
    private void init(){
        LOG.info("Spring Boot init - AppName: " + propsModelResource.getAppUrl());

        //Get User Name by Specific Profile (dev, prod, qa...)
        LOG.info("Spring Boot init - userName: " + userResource.getUserName());
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

        LOG.info("EXECUTING : command line runner envPropertiesLoadResource filter Mode Name = {} using testing.properties",
                envPropertiesLoadResource.getFilterModeName());

    }
}
