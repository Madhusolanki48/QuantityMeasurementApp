package com.apps.quantitymeasurement.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAll(Exception ex) {
		return ResponseEntity.badRequest().body(Map.of("error", true, "message", ex.getMessage()));
	}
}