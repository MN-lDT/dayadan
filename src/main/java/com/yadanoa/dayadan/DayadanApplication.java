package com.yadanoa.dayadan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.yadanoa.dayadan.mapper")
@SpringBootApplication
public class DayadanApplication {

    public static void main(String[] args) {
        SpringApplication.run(DayadanApplication.class, args);
    }

}
