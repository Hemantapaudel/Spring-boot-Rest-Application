package com.commom.application.consume;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class RestConsumer {
	/*
     * Add HTTP Authorization header, using Basic-Authentication to send user-credentials.
     */
    private static HttpHeaders getHeaders(){
        String plainCredentials="bill:abc123";
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
        System.out.println("base64Credentials = "+base64Credentials);

        
        
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
	
	
	public static void main(String[] args) {
		
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/restapi/getaccount?account=123456";
		
		System.out.println(restTemplate.exchange(uri, HttpMethod.GET, request, Object.class));
		
	}
}
