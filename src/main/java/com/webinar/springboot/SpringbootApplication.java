package com.webinar.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.webinar.springboot.repository")
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        System.out.println("Application Started");
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
