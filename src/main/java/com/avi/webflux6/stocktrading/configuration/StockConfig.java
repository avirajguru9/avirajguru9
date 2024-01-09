package com.avi.webflux6.stocktrading.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
				.requestMatchers("**")
				.permitAll()
				.anyRequest()
				.authenticated()
				).httpBasic(withDefaults()).build();
	}
}
