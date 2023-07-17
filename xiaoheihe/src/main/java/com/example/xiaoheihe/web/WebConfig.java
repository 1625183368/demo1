package com.example.xiaoheihe.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("Content-Type","X-Request-With","Access-Control-Request-Method","Access-Control-Request-Headers","token")
                .allowedMethods("*")
                .allowedOrigins("*")
                /*注意当这个配置为真是我们不能将允许源设置为*而是将源路径设置为*即可*/
                .allowCredentials(true);
    }
}
