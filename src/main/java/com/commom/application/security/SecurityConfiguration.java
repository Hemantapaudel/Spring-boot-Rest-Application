package com.commom.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	     private static String REALM="MY_TEST_REALM";
	     
	     @Value("${admin.username}")
	     private String userName;
	     
	     @Value("${admin.password}")
	     private String password;
	 
	     @Autowired
	     CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;
	 
	    @Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	    	System.out.println("userna name :"+userName +" pwd = "+password);
	        auth.inMemoryAuthentication().withUser(userName).password(password).roles("ADMIN");
	        auth.inMemoryAuthentication().withUser("tom").password("abc123").roles("USER");
	    }
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.csrf().disable()
	    	.authorizeRequests()
	    	.antMatchers("/getaccount/**").hasAnyRole("ADMIN","USER")
	    	.and().httpBasic().realmName(REALM).authenticationEntryPoint(customBasicAuthenticationEntryPoint)
	    	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    }
	    
	    /* To allow Pre-flight [OPTIONS] request from browser */
	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	    }
	     
}
