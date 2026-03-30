package com.apps.quantitymeasurement.utils;

import com.apps.quantitymeasurement.dto.QuantityDTO;

import com.apps.quantitymeasurement.entity.Quantity;
import com.apps.quantitymeasurement.units.*;

public class QuantityConverter {

	public static Quantity<?> toEntity(QuantityDTO dto) {

		String unit = dto.getUnit();

		try {
			// LENGTH
			if (dto.getMeasurementType().equalsIgnoreCase("LengthUnit")) {
				return new Quantity<>(dto.getValue(), LengthUnit.valueOf(unit));
			}

			// WEIGHT
			if (dto.getMeasurementType().equalsIgnoreCase("WeightUnit")) {
				return new Quantity<>(dto.getValue(), WeightUnit.valueOf(unit));
			}

			// VOLUME
			if (dto.getMeasurementType().equalsIgnoreCase("VolumeUnit")) {
				return new Quantity<>(dto.getValue(), VolumeUnit.valueOf(unit));
			}

			// TEMPERATURE
			if (dto.getMeasurementType().equalsIgnoreCase("TemperatureUnit")) {
				return new Quantity<>(dto.getValue(), TemperatureUnit.valueOf(unit));
			}

		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid unit or measurement type");
		}

		throw new IllegalArgumentException("Unsupported measurement type");
	}

	// OPTIONAL (if needed)
	public static QuantityDTO toDTO(Quantity<?> q) {
		QuantityDTO dto = new QuantityDTO();
		dto.setValue(q.getValue());
		dto.setUnit(q.getUnit().getUnitName());
		dto.setMeasurementType(q.getUnit().getClass().getSimpleName());
		return dto;
	}
}