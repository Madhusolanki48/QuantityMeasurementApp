package com.apps.quantitymeasurement.common.dto;

import lombok.Data;

@Data
public class QuantityMeasurementDTO {

	private String operation;
	private Double result;
	private String message;
	private boolean error;

	public QuantityMeasurementDTO() {
	}

	public QuantityMeasurementDTO(String operation, Double result, String message, boolean error) {
		this.operation = operation;
		this.result = result;
		this.message = message;
		this.error = error;
	}

	public static QuantityMeasurementDTO success(String operation, Double result) {
		return new QuantityMeasurementDTO(operation, result, "SUCCESS", false);
	}

	public static QuantityMeasurementDTO failure(String operation, String message) {
		return new QuantityMeasurementDTO(operation, null, message, true);
	}
}
