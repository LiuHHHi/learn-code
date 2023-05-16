package com.yunzainfo.code1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Lemon
 * @date 2022/6/6 13:54
 */
@Configuration
public class WebMvcConfigurerConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 精确匹配
                .allowedOrigins("http://localhost:63342", "http://localhost:4200");
    }
}
