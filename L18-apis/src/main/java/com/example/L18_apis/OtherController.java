package com.example.L18_apis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class OtherController {

    private Logger logger = LoggerFactory.getLogger(OtherController.class);

    @GetMapping("/generate-random/{end}")
    public Integer generateRandomNumber(@PathVariable(value = "end") int end){

        logger.info("inside generate random function, end - {}", end);
        Random random = new Random();
        return random.nextInt(end);
    }

    @GetMapping("/generate-random/{start}/{end}")
    public Integer generateRandomNumberBwStartAndEnd(@PathVariable(value = "start") int start,
                                        @PathVariable(value = "end") int end){

        logger.info("inside generate random function, start - {}, end - {}", start, end);
        Random random = new Random();
        return random.nextInt(end);
    }

}
