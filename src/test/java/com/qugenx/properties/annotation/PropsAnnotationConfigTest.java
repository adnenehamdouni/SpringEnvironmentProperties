package com.qugenx.properties.annotation;

import com.qugenx.properties.ConfigProperties;
import com.qugenx.properties.config.TestPropertyEnvSourceConfig;
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

import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
public class PropsAnnotationConfigTest {

    //Sample: https://www.baeldung.com/configuration-properties-in-spring-boot

    @Autowired
    private ConfigProperties configProperties;

    @Before
    public void setUp() {
        assertThat(configProperties).isNotNull();
    }

    @Test
    //@Ignore
    public void testHostName(){
        assertThat(configProperties.getHostName()).isNotNull();
        assertThat(configProperties.getHostName()).contains("hostdev");
    }

    @Test
    //@Ignore
    public void testFrom(){
        assertThat(configProperties.getFrom()).isNotNull();
        assertThat(configProperties.getFrom()).contains("mailerdev@mail.com");
    }

    @Test
    //@Ignore
    public void testPort(){
        assertThat(configProperties.getPort()).isNotNull();
        assertThat(configProperties.getPort()).isEqualTo(9000);
    }


    @Test
    //@Ignore
    public void testDefaultRecipients(){
        assertThat(configProperties.getDefaultRecipients()).isNotNull();
        assertThat(configProperties.getDefaultRecipients().size()).isEqualTo(2);
        assertThat(configProperties.getDefaultRecipients().get(0)).isEqualTo("admin@mail.com");
        assertThat(configProperties.getDefaultRecipients().get(1)).isEqualTo("owner@mail.com");
    }

    @Test
    //@Ignore
    public void testAdditionalHeaders(){
        assertThat(configProperties.getAdditionalHeaders()).isNotNull();
        assertThat(configProperties.getAdditionalHeaders().size()).isEqualTo(4);

        // filter more values
        String values = configProperties.getAdditionalHeaders().entrySet().stream()
                .filter(x -> {
                    if (!x.getValue().contains("fnac") && !x.getValue().contains("true")) {
                        return true;
                    }
                    return false;
                })
                .map(map -> map.getValue())
                .collect(Collectors.joining(","));

        System.out.println("get Values: " + values);
        assertThat(values).isNotNull();
        assertThat(values).isNotEmpty();
        assertThat(values).isEqualTo("amazon");


        String keys = configProperties.getAdditionalHeaders().entrySet().stream()
                .filter(e -> e.getValue().equals("amazon"))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("get keys: " + keys);
        assertThat(keys).isNotNull();
        assertThat(keys).isNotEmpty();
        assertThat(keys).isEqualTo("amz");

    }


}
