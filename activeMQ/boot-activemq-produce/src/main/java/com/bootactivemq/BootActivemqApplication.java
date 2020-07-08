package com.bootactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BootActivemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootActivemqApplication.class, args);
    }

}
