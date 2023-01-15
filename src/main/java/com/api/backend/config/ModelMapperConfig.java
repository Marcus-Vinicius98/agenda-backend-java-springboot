package com.api.backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ModelMapperConfig {

    @Bean
    ModelMapper mapper() {
        return new ModelMapper();
    }

}
