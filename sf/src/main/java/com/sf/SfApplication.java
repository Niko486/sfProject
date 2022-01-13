package com.sf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.sf.mapper")
public class SfApplication {
    public static void main(String[] args) {
        SpringApplication.run(SfApplication.class, args);
    }
}
