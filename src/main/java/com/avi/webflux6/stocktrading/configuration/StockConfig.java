package com.avi.webflux6.stocktrading.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;
import io.netty.handler.codec.http.HttpRequest;

@Configuration
public class StockConfig {
	@Bean
	public RestTemplate restTempateBean() {
		return new RestTemplate();
	}
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//all request should be authenticated
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		
		//if not auth then show web page login
		http.httpBasic(withDefaults());
		
		//CSRF Put/post
		
		//http.csrf().disable();
		return http.build();
	}
}
