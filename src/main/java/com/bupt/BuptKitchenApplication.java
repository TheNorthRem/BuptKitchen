package com.bupt;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.bupt.dao"})
public class BuptKitchenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuptKitchenApplication.class, args);
    }

}
