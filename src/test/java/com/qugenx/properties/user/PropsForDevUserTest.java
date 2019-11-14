package com.qugenx.properties.user;

import com.qugenx.properties.resource.ActiveProfileResource;
import com.qugenx.properties.resource.ConfigPropertiesResource;
import com.qugenx.properties.resource.PropsModelResource;
import com.qugenx.properties.resource.UserResource;
import org.junit.Before;
import org.junit.Ignore;
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
public class PropsForDevUserTest {

    @Autowired
    private UserResource userResource;

    @Value("${app.user.firstName}")
    private String userName;

    @Before
    public void setUp() {
        assertThat(userName).isNotNull();
        assertThat(userResource).isNotNull();
    }

    @Test
    //@Ignore
    public void testUser(){
        String userNameFromResource = userResource.getUserName();
        assertThat(userName).isNotNull();
        assertThat(userNameFromResource).contains("dev-name");
        assertThat(userName).contains("dev-name");
    }

}
