package com.qugenx.properties.controller;

import com.qugenx.properties.resource.ActiveProfileResource;
import com.qugenx.properties.resource.ConfigPropertiesResource;
import com.qugenx.properties.resource.PropsModelResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"", "/"})
public class EnvironmentController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConfigPropertiesResource configPropertiesResource;

    @Autowired
    private PropsModelResource propsModelResource;

    @Autowired
    private ActiveProfileResource activeProfileResource;


    @GetMapping(value="/version", headers="Accept=application/json")
    public ResponseEntity<ConfigPropertiesResource> getConfigProperties() {
        logger.info("Build version = {}", configPropertiesResource.getBuildVersion() );
        return new ResponseEntity<>(configPropertiesResource, HttpStatus.OK);
    }

    @GetMapping(value="/profile", headers="Accept=application/json")
    public String getActiveProfile() {
        logger.info("Build version = {}", activeProfileResource.getActiveProfile());
        return activeProfileResource.toString();
    }

    @GetMapping(value="/url", headers="Accept=application/json")
    public ResponseEntity<String> getPropsModel() {
        logger.info("Build version = {}", propsModelResource.getAppUrl() );
        return new ResponseEntity<>(propsModelResource.getAppUrl(), HttpStatus.OK);
    }

}
