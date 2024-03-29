package com.serviceops.ecommerce;

import org.aspectj.bridge.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = HazelcastAutoConfiguration.class)
@EnableCaching
public class EcommerceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EcommerceApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }


}
