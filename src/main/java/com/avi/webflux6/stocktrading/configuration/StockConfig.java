package com.avi.webflux6.stocktrading.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;
import io.netty.handler.codec.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class StockConfig {
	@Bean
	public RestTemplate restTempateBean() {
		return new RestTemplate();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		return http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(
				auth->auth
				.requestMatchers("/stocks/*")
				.permitAll()
				.anyRequest()
				.authenticated()
				).build();
	}
}
