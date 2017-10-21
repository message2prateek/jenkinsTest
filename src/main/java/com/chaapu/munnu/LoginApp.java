package com.chaapu.munnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@ComponentScan("com.chaapu.munnu.web")
public class LoginApp {
    public static void main(String[] args) {
        SpringApplication.run(LoginApp.class, args);
    }

}
