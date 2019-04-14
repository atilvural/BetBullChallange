package com.betbull.challange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.betbull")
@ComponentScan("com.betbull")
public class ChallangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallangeApplication.class, args);
    }

}
