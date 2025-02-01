package com.spring_security.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
@Configuration
*/
/*@EnableWebMvc*/
public class CorsConfigurationClass /*implements WebMvcConfigurer*/ {

    // Configuração do CORs para arquitetura MVC! Quando usamos o SpringSecurity, a implementação é diferente.

    /*
    * 1. Configuração do CORS no Spring MVC (usando WebMvcConfigurer e CorsRegistry).
    * 2. Configuração do CORS no Spring Security (usando CorsConfigurationSource).
    *
    * */
/*
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/user/**")
                .allowedOrigins("")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true).maxAge(3600);
    }*/
}
