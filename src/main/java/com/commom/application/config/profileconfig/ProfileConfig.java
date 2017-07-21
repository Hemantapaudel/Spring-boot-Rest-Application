package com.commom.application.config.profileconfig;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 
 * We can create bean base on spring.profiles.active like dev,qa,production etc
 *
 * We can enable spring profile active from code or vm option
 * 
 * 1. VM OPTION ARGS 
 * 
 * -Dspring.profiles.active=dev
 * 
 * 2. USING JAVA CODE
 * System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "live")
 * 
 */
@Configuration
public class ProfileConfig {

	@Bean
	@Profile("dev")
	public CacheManager concurrentMapCacheManager() {
		System.out.println("Cache manager is concurrentMapCacheManager");
		return new ConcurrentMapCacheManager("movieFindCache");
	}

	@Bean
	@Profile("live")
	public CacheManager echchache() {
		System.out.println("Cache manager is echchache");
		return new ConcurrentMapCacheManager("movieFindCache");
	}

}