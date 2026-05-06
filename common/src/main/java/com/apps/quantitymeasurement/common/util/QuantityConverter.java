package com.apps.quantitymeasurement.common.util;

import com.apps.quantitymeasurement.common.dto.QuantityDTO;
import com.apps.quantitymeasurement.common.model.Quantity;
import com.apps.quantitymeasurement.common.units.LengthUnit;
import com.apps.quantitymeasurement.common.units.TemperatureUnit;
import com.apps.quantitymeasurement.common.units.VolumeUnit;
import com.apps.quantitymeasurement.common.units.WeightUnit;

public final class QuantityConverter {

	private QuantityConverter() {
	}

	public static Quantity<?> toEntity(QuantityDTO dto) {
		if (dto == null) {
			throw new IllegalArgumentException("Quantity is required");
		}

		String unit = dto.getUnit();

		try {
			if (dto.getMeasurementType().equalsIgnoreCase("LengthUnit")) {
				return new Quantity<>(dto.getValue(), LengthUnit.valueOf(unit));
			}
			if (dto.getMeasurementType().equalsIgnoreCase("WeightUnit")) {
				return new Quantity<>(dto.getValue(), WeightUnit.valueOf(unit));
			}
			if (dto.getMeasurementType().equalsIgnoreCase("VolumeUnit")) {
				return new Quantity<>(dto.getValue(), VolumeUnit.valueOf(unit));
			}
			if (dto.getMeasurementType().equalsIgnoreCase("TemperatureUnit")) {
				return new Quantity<>(dto.getValue(), TemperatureUnit.valueOf(unit));
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException("Invalid unit or measurement type");
		}

		throw new IllegalArgumentException("Unsupported measurement type");
	}

	public static QuantityDTO toDTO(Quantity<?> quantity) {
		QuantityDTO dto = new QuantityDTO();
		dto.setValue(quantity.getValue());
		dto.setUnit(quantity.getUnit().getUnitName());
		dto.setMeasurementType(quantity.getUnit().getClass().getSimpleName());
		return dto;
	}
}
