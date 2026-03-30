package com.apps.quantitymeasurement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	private OAuthSuccessHandler oAuthSuccessHandler;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
        .csrf(csrf -> csrf.disable())
        .headers(headers -> headers.frameOptions(frame -> frame.disable()))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/**, \"/h2-console/**").permitAll()
            .requestMatchers("/api/**").permitAll()
            .anyRequest().permitAll()
        )
        .oauth2Login(oauth -> oauth
            .successHandler(oAuthSuccessHandler)
        );

    http.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}