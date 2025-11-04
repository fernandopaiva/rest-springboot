package com.ferpateste.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {
    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String testLog(){
        logger.info("INFO LOGGER");
        logger.warn("WARN LOGGER");
        logger.debug("DEBUG LOGGER");
        logger.error("ERROR LOGGER");
        return "Log generated right :)";
    }
}
