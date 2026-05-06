package com.apps.quantitymeasurement.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.apps.quantitymeasurement.common.dto.ConversionHistoryRequest;
import com.apps.quantitymeasurement.common.dto.ConversionHistoryResponse;
import com.apps.quantitymeasurement.user.entity.User;
import com.apps.quantitymeasurement.user.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(originPatterns = {
		"http://localhost:*",
		"http://127.0.0.1:*",
		"https://*.onrender.com",
		"https://*.render.com" })
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String home() {
		return "User service is running";
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@Valid @RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/{userId}")
	public User getById(@PathVariable Long userId) {
		return userService.getUser(userId);
	}

	@PostMapping("/{userId}/history")
	@ResponseStatus(HttpStatus.CREATED)
	public ConversionHistoryResponse saveHistory(@PathVariable Long userId,
			@RequestBody ConversionHistoryRequest request) {
		return userService.saveHistory(userId, request);
	}

	@GetMapping("/{userId}/history")
	public List<ConversionHistoryResponse> getHistory(@PathVariable Long userId) {
		return userService.getHistory(userId);
	}

	@DeleteMapping("/{userId}/history/{historyId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteHistoryItem(@PathVariable Long userId, @PathVariable Long historyId) {
		userService.deleteHistoryItem(userId, historyId);
	}

	@DeleteMapping("/{userId}/history")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAllHistory(@PathVariable Long userId) {
		userService.deleteAllHistory(userId);
	}
}
