package com.jsp.Employee_Management.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

}