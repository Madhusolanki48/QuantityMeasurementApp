package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.dto.QuantityRequestDTO;
import com.apps.quantitymeasurement.dto.QuantityMeasurementDTO;
import org.springframework.web.bind.annotation.*;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/measurements")
public class QuantityMeasurementController {
	@GetMapping("/")
	public String home() {
		return "Login Successful!";
	}

	private final IQuantityMeasurementService service;

	public QuantityMeasurementController(IQuantityMeasurementService service) {
		this.service = service;
	}

	@PostMapping("/add")
	public QuantityMeasurementDTO add(@Valid @RequestBody QuantityRequestDTO request) {
		return service.add(request);
	}

	@PostMapping("/subtract")
	public QuantityMeasurementDTO subtract(@Valid @RequestBody QuantityRequestDTO request) {
		return service.subtract(request);
	}

	@PostMapping("/divide")
	public Double divide(@Valid @RequestBody QuantityRequestDTO request) {
		return service.divide(request);
	}

	@PostMapping("/convert")
	public QuantityMeasurementDTO convert(@Valid @RequestBody QuantityRequestDTO request) {
		return service.convert(request);
	}

	@PostMapping("/compare")
	public QuantityMeasurementDTO compare(@Valid @RequestBody QuantityRequestDTO request) {
		return service.compare(request);
	}

	@GetMapping("/history")
	public List<?> getAllHistory() {
		return service.getHistory();
	}

	@GetMapping("/history/operation/{operation}")
	public List<?> getByOperation(@PathVariable String operation) {
		return service.getByOperation(operation.toUpperCase());
	}
}