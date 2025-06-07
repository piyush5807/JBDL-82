package com.example.demo_beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("prototype")
public class DemoConfiguration {

    private static Logger logger = LoggerFactory.getLogger(DemoConfiguration.class);

    @Bean
    @Scope("prototype")
//    public ObjectMapper getMapper(@Value("${my-app.count.value}") Integer count){ // objectMapper
    public ObjectMapper getMapper(){
        ObjectMapper om  = new ObjectMapper();
        logger.info("Inside getObjectMapper... this - {}", om);
        return om;
    }

    /**
     * DemoConfiguration - Singleton, objectMapper - Singleton
     *              If we call objectMapper via demoConfiguration, same obj on subsequent APIs
     *              If we autowired objectMapper directly in the controller, only 1 objectmapper instance is used
     * DemoConfiguration - Singleton, objectMapper - Prototype:
     *              If we call objectMapper via demoConfiguration, different objs on subsequent APIs
     *              If we autowire objectMapper directly in the controller, only 1 objectmapper instance is used
     * DemoConfiguration - Prototype, objectMapper - Singleton
     *              If we autowire objectMapper directly in the controller, only 1 objectmapper instance is used
     *              If we call objectMapper via demoConfiguration, same obj on subsequent APIs
     * DemoConfiguration - Prototype, objectMapper - Prototype
     *              If we call objectMapper via demoConfiguration, different objs on subsequent APIs
     *              If we autowired objectMapper directly in the controller, only 1 objectmapper instance is used
     */

}
