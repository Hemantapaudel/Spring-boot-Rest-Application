package com.commom.application;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.commom.application.scope.SingletonObject;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext  applicationContext =SpringApplication.run(Application.class, args);
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		Arrays.stream(beanNames).forEach(str -> System.out.println(str));	
		

		
		SingletonObject singletonObject = applicationContext.getBean(SingletonObject.class);
		
		
		IntStream.range(0, 10).forEach((i)-> singletonObject.print() );
	}
}
