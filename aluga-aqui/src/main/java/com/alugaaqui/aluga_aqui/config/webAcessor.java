package com.alugaaqui.aluga_aqui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class webAcessor implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry cors) {
        cors.addMapping("/**")
            .allowedOriginPatterns("http://localhost:5173") // <- substitui allowedOrigins
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowCredentials(true);
    }
}