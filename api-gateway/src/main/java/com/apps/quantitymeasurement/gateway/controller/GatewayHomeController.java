package com.apps.quantitymeasurement.gateway.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayHomeController {

	@GetMapping("/")
	public Map<String, Object> home() {
		return Map.of(
				"service", "api-gateway",
				"status", "running",
				"routes", new String[] { "/api/v1/measurements/**", "/api/v1/users/**" });
	}
}
