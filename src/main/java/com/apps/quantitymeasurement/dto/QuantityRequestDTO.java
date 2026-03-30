package com.apps.quantitymeasurement.dto;

//import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuantityRequestDTO {

//	@NotNull
//	@Valid
	private QuantityDTO first;

//	@NotNull
//	@Valid
	private QuantityDTO second;

	// No-args constructor
	public QuantityRequestDTO() {
	}

	// All-args constructor
	public QuantityRequestDTO(QuantityDTO first, QuantityDTO second) {
		this.first = first;
		this.second = second;
	}

	// Getters and Setters
	public QuantityDTO getFirst() {
		return first;
	}

	public void setFirst(QuantityDTO first) {
		this.first = first;
	}

	public QuantityDTO getSecond() {
		return second;
	}

	public void setSecond(QuantityDTO second) {
		this.second = second;
	}
}