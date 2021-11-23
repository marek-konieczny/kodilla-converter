package com.example.kodillaconverter.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

@Configuration
public class ConverterConfiguration {

    @Bean
    public HttpMessageConverter<Object> customSlashConverter() {
        return new MyCustomSlashConverter();
    }

    @Bean
    public HttpMessageConverter<Object> carConverter() {
        return new CarConverter();
    }
}
