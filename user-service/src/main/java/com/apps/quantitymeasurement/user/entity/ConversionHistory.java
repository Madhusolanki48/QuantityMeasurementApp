package com.apps.quantitymeasurement.user.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "conversion_history")
@Data
@NoArgsConstructor
public class ConversionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
