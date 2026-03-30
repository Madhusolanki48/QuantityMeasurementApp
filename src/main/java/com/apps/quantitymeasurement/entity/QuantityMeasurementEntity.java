package com.apps.quantitymeasurement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quantity_logs")
@Data
@NoArgsConstructor
public class QuantityMeasurementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String operation;
	private double operand1;
	private double operand2;
	private double result;
	private boolean error;
	private String errorMessage;

	public QuantityMeasurementEntity(String operation, double v1, double v2, double result) {

		this.operation = operation;
		this.operand1 = v1;
		this.operand2 = v2;
		this.result = result;
		this.error = false;
	}

	public QuantityMeasurementEntity(String op, String errorMessage) {
		this.operation = op;
		this.error = true;
		this.errorMessage = errorMessage;
	}
}