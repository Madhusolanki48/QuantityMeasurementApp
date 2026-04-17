package com.apps.quantitymeasurement.measurement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.quantitymeasurement.common.dto.QuantityMeasurementDTO;
import com.apps.quantitymeasurement.common.dto.QuantityRequestDTO;
import com.apps.quantitymeasurement.measurement.service.IQuantityMeasurementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/measurements")
public class QuantityMeasurementController {

	private final IQuantityMeasurementService service;

	public QuantityMeasurementController(IQuantityMeasurementService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String home() {
		return "Measurement service is running";
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
