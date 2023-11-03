package com.example.yunpan.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AppConfig {
    @Value("${spring.mail.username:}")
    private String sendUserName;
    @Value("${admin.emails:}")
    private String adminEmail;
}
