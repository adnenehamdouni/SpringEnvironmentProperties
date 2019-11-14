package com.qugenx.properties;

import com.qugenx.properties.config.TestPropertySourceConfig;
import com.qugenx.properties.resource.PropsModelResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.invoke.MethodHandles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@Import({TestPropertySourceConfig.class})
//@TestPropertySource(locations="classpath:application-it.properties")
public class PropsLoadFromTestResourcesTest {

    @Autowired
    private PropsModelResource propsModelResource;

    @Value("${application.url}")
    private String appUrl;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Before
    public void setUp() {
        assertThat(propsModelResource).isNotNull();
    }

    @Test
    public void testAppUrl(){
        String appUrl = propsModelResource.getAppUrl();
        assertThat(appUrl).isNotNull();
        assertThat(appUrl).isEqualTo(appUrl);
    }

}
