package com.api.backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ModelMapperConfig {
	
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
