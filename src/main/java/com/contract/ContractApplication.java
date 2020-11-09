package com.contract;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.contract.mapper")
public class ContractApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractApplication.class, args);
    }

}
