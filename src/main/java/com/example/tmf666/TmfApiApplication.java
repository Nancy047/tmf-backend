package com.example.tmf666;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class TmfApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmfApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .allowedHeaders("Authorization", "Orgin", "Content-Type")
                        .exposedHeaders("Access-Control-Allow-Orgin", "Access-Control-Allow-Credentials")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }
}
