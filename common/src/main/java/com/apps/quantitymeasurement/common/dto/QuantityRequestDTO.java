package com.apps.quantitymeasurement.common.dto;

import lombok.Data;

@Data
public class QuantityRequestDTO {

	private QuantityDTO first;
	private QuantityDTO second;
	private Long userId;

	public QuantityRequestDTO() {
	}

	public QuantityRequestDTO(QuantityDTO first, QuantityDTO second, Long userId) {
		this.first = first;
		this.second = second;
		this.userId = userId;
	}
}
