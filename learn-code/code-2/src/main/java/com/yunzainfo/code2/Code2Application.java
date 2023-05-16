package com.yunzainfo.code2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Code2Application {
    public static void main(String[] args) {
        SpringApplication.run(Code2Application.class, args);
    }
}
