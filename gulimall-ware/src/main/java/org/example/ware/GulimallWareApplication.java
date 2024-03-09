package org.example.ware;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启事务功能
//@EnableTransactionManagement
//@EnableRabbit
@EnableFeignClients
@EnableDiscoveryClient
//@SpringBootApplication(exclude = GlobalTransactionAutoConfiguration.class)
@SpringBootApplication

public class GulimallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallWareApplication.class, args);
    }

}
