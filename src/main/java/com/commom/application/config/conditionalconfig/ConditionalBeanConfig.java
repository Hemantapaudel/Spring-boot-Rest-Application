package com.commom.application.config.conditionalconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalBeanConfig {
	
	@Bean
	@Conditional(MagicExistsCondition.class)
	public CondtionalBeanClass magicBean() {
		return new CondtionalBeanClass();
	}

}
