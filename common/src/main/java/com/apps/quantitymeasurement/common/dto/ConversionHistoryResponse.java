package com.apps.quantitymeasurement.common.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ConversionHistoryResponse {

	private Long id;
	private Long userId;
	private String operation;
	private String measurementType;
	private Double firstValue;
	private String firstUnit;
	private Double secondValue;
	private String secondUnit;
	private Double result;
	private boolean error;
	private String errorMessage;
	private LocalDateTime timestamp;
}
