package com.serviceops.ecommerce;

import org.aspectj.bridge.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EcommerceApplication.class);
    public static void main(String[] args) {
        LOGGER.debug("Application started");

        SpringApplication.run(EcommerceApplication.class, args);
    }


}
