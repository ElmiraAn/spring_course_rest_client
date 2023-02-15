package com.elmiraantipina.spring.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.elmiraantipina.spring.rest")
public class MyConfig {

    @Bean
    //данный бин(это вспомогательный класс RestTemplate, который уже существует) нужен для осуществления HTTP-request-ов
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}
