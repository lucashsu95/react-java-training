package com.example.usertodoapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // 允許的路徑
                .allowedOrigins("http://localhost:5173") // 允許的來源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允許的 HTTP 方法
                .allowCredentials(true); // 是否允許帶上憑證
    }
}