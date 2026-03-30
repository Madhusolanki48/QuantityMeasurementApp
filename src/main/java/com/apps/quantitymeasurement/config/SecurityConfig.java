package com.apps.quantitymeasurement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Autowired
	private OAuthSuccessHandler oAuthSuccessHandler;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				auth -> auth.requestMatchers("/").permitAll().requestMatchers("/api/v1/measurements/**").permitAll() // allow
																														// all
						.anyRequest().authenticated())
				.oauth2Login(oauth -> oauth.successHandler(oAuthSuccessHandler));

		return http.build();
	}
}