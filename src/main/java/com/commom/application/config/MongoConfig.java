package com.commom.application.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {

	
	@Value("${spring.data.mongodb.database}")
	private String database;
	
	@Value("${spring.data.mongodb.port}")
	private int port;
	
	@Value("${spring.data.mongodb.host}")
	private String host;
	
	 @Bean
	 public MongoDbFactory mongoDbFactory() throws Exception {
		 System.out.println("host : "+host + " port = "+port +" database :"+database);
		return new SimpleMongoDbFactory(new MongoClient(host,port), database);
	}

	public @Bean
	MongoTemplate mongoTemplate(@Qualifier("mongoDbFactory") MongoDbFactory mongoDbFactory)
			throws Exception {
		return new MongoTemplate(mongoDbFactory);
	}
}
