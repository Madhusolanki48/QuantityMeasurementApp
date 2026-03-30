package com.apps.quantitymeasurement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDTO {

//	    @NotNull(message = "Value is required")
	private Double value;
//    	@NotBlank(message = "Unit is required")
	private String unit;
//    	@NotBlank(message = "Measurement type is required")
	private String measurementType;

	// No-args constructor
	public QuantityDTO() {
	}

	// All-args constructor
	public QuantityDTO(Double value, String unit, String measurementType) {
		this.value = value;
		this.unit = unit;
		this.measurementType = measurementType;
	}

	// Getters and Setters
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}
}