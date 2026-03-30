package com.apps.quantitymeasurement.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

	public static QuantityMeasurementDTO success(String op, Double result) {
		return new QuantityMeasurementDTO(op, result, "SUCCESS", false);
	}

	public static QuantityMeasurementDTO failure(String op, String msg) {
		return new QuantityMeasurementDTO(op, null, "FAILURE", true);
	}

	// getters & setters
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}