package com.example;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.*;
import java.util.*;

@SpringBootApplication
public class SpringBootApp {
    private static final Logger logger = Logger.getLogger(SpringBootApp.class);

    public static void main(String[] args) {
        logger.info("Starting Spring Boot Application...");
        SpringApplication.run(SpringBootApp.class, args);
    }
}
