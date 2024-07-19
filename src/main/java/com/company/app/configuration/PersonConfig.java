package com.company.app.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {
	
	@Bean
	   public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}
