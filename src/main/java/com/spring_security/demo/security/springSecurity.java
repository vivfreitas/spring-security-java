package com.spring_security.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class springSecurity { // Estendendo para a classe para termos melhores personalizações.

    // Implementação do springSecurity com o CORs.
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity ) throws Exception{
        httpSecurity
                .cors(cors -> cors.configurationSource(corsConfigurationClass()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("api/user/loginUser").permitAll()
                        .requestMatchers("api/user/getAll").permitAll()
                        .anyRequest().authenticated()); // Exige que o usuário esteja auth para qualquer outra rota.
        return httpSecurity.build(); // Irá setar as nossas configurações acima sobre o securityFilterChain.
    }

    /* Configuração do CORs */
    @Bean
    public CorsConfigurationSource corsConfigurationClass(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("http://127.0.0.1:5500");
        corsConfiguration.setAllowCredentials(false); // Permite o uso de tokens
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
