package com.apps.quantitymeasurement.common.dto;

import lombok.Data;

@Data
public class QuantityDTO {

	private Double value;
	private String unit;
	private String measurementType;

	public QuantityDTO() {
	}

	public QuantityDTO(Double value, String unit, String measurementType) {
		this.value = value;
		this.unit = unit;
		this.measurementType = measurementType;
	}
}
