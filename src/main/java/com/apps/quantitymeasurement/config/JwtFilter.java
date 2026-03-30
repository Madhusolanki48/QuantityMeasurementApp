package com.apps.quantitymeasurement.config;

import com.apps.quantitymeasurement.utils.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.Collections;

public class JwtFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String authHeader = req.getHeader("Authorization");

		if (authHeader != null && authHeader.startsWith("Bearer ")) {

			String token = authHeader.substring(7);

			try {
				String email = JwtUtil.validateToken(token);

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email,
						null, Collections.emptyList());

				SecurityContextHolder.getContext().setAuthentication(authentication);

			} catch (Exception e) {
				System.out.println("Invalid JWT");
			}
		}

		chain.doFilter(request, response);
	}
}