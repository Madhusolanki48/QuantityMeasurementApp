package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@PostMapping("/login")
	public Map<String, String> login(@RequestParam String email) {

		String token = JwtUtil.generateToken(email);

		return Map.of("token", token);
	}
}