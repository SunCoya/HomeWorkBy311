package com.example.yunpan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/yunpan/mapper")
public class YunpanApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunpanApplication.class, args);
    }

}
