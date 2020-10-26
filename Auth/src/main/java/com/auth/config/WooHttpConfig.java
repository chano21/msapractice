package com.auth.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WooHttpConfig {
	@Bean
	public RestTemplate resttemplate() {
		HttpComponentsClientHttpRequestFactory factory =new HttpComponentsClientHttpRequestFactory();
		HttpClient client = HttpClientBuilder.create().setMaxConnTotal(50).setMaxConnPerRoute(20).build();
		
		factory.setHttpClient(client);
		RestTemplate resttemplate = new RestTemplate(factory);
		return resttemplate;
	}
}
