package com.example.demo_beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// singleton scope
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    DemoConfiguration demoConfiguration;

//    @Autowired
//    ObjectMapper obj;

    @GetMapping("/object-mapper")
    public String getObjectMapper(){
//        logger.info("Inside get object mapper..., obj - {}", demoConfiguration.getMapper());
        return "bye!!";
    }
}
// com.fasterxml.jackson.databind.ObjectMapper@437e951d
// com.fasterxml.jackson.databind.ObjectMapper@437e951d
// com.fasterxml.jackson.databind.ObjectMapper@437e951d
