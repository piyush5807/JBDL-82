package com.example.demo_security.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Value("${library.max-books.allowed}")
    Integer maxBooksAllowed;


    @GetMapping("/test")
    public String getName(@RequestParam("name") String name){
        logger.debug("request received - name - {}", name);

        logger.info("max books allowed - {}", maxBooksAllowed);
        return "User#" + name;
    }

    /**
     * Git - master / main branch - for production env
     *     - staging - for staging env
     */
}
