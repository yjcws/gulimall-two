package com.example.product.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement        //开启使用
@MapperScan("com.example.product.dao")
public class MyBatisConfig {

    //引入分页插件


}
