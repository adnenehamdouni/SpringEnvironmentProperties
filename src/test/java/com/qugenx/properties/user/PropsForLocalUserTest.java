package com.qugenx.properties.user;

import com.qugenx.properties.config.TestPropertyEnvSourceConfig;
import com.qugenx.properties.config.TestPropertySourceConfig;
import com.qugenx.properties.config.TestUserResourceConfig;
import com.qugenx.properties.resource.UserResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
//@ComponentScan(basePackages = {"com.qugenx.properties"})
//@PropertySource({"classpath:environment-configuration.properties"})
@Import({TestPropertyEnvSourceConfig.class, TestUserResourceConfig.class})
public class PropsForLocalUserTest {

    @Autowired
    private UserResource userResource;


    @Value("${filter.mode}")
    private String filterMode;

    @Value("${application.filter.name:}")
    private String filterModeName;

    @Before
    public void setUp() {
        assertThat(filterMode).isNotNull();
        //assertThat(filterModeName).isNotNull();
        assertThat(userResource).isNotNull();
    }

    @Test
    //@Ignore
    public void testFilterModeOldWay(){
        assertThat(filterMode).isNotNull();
        assertThat(filterMode).contains("local");
    }

    @Test
    //@Ignore
    public void testFilterModeNameOldWay(){
        assertThat(filterModeName).isNotNull();
        assertThat(filterModeName).contains("local Filter");
    }

}
