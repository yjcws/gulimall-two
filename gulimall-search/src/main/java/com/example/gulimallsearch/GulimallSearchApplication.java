package com.example.gulimallsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GulimallSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallSearchApplication.class, args);
    }

}
