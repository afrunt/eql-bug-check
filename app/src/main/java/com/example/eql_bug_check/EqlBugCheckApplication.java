package com.example.eql_bug_check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.example.eql_bug_check.repository"})
@SpringBootApplication(scanBasePackages = {"com.example"})
public class EqlBugCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(EqlBugCheckApplication.class, args);
    }

}
