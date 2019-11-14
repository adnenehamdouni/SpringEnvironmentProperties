package com.qugenx.properties;

import com.qugenx.properties.resource.ActiveProfileResource;
import com.qugenx.properties.resource.ConfigPropertiesResource;
import com.qugenx.properties.resource.PropsModelResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
public class PropsConfigurationTest {

    @Autowired
    private ConfigPropertiesResource configPropertiesResource;

    @Autowired
    private PropsModelResource propsModelResource;

    @Autowired
    private ActiveProfileResource activeProfileResource;

    @Value("${app.name}")
    private String appName;

    @Value("${build.version}")
    private String buildVersion;

    @Before
    public void setUp() {
        assertThat(configPropertiesResource).isNotNull();
        assertThat(propsModelResource).isNotNull();
        assertThat(activeProfileResource).isNotNull();
    }

    @Test
    public void testActiveProfile(){
        String activeProfile = activeProfileResource.getActiveProfile();
        assertThat(activeProfile).isNotNull();
        assertThat(activeProfile).contains("dev");
    }

    @Test
    public void testAppUrl(){
        String appUrl = propsModelResource.getAppUrl();
        assertThat(appUrl).isNotNull();
        assertThat(appUrl).isEqualTo("127.0.0.1");
    }

    @Test
    public void testConfigEnvironmentByLoadedProperties(){
        String appNameFromEnv = configPropertiesResource.getConfigValue("app.name");
        String buildVersionFromEnv = configPropertiesResource.getConfigValue("build.version");
        assertThat(appNameFromEnv).isNotNull();
        assertThat(appNameFromEnv).isEqualTo(appName);
        assertThat(buildVersionFromEnv).isNotNull();
        assertThat(buildVersionFromEnv).isEqualTo(buildVersion);
    }
}
