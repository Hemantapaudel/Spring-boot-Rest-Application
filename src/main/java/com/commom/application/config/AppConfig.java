package com.commom.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.commom.application.security.CustomBasicAuthenticationEntryPoint;

@Configuration
public class AppConfig {
	
	@Bean
	CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint(){
		return new CustomBasicAuthenticationEntryPoint();
	} 

}
