package com.apps.quantitymeasurement;

// UC-11 : Volume Unit Enum (base unit = litre)
public enum VolumeUnit implements IMeasurable {

	LITRE(1.0), MILLILITRE(0.001), // 1 mL = 0.001 L
	GALLON(3.78541); // 1 gallon ≈ 3.78541 L

	private final double factor;

	VolumeUnit(double factor) {
		this.factor = factor;
	}

	// returns conversion factor
	public double getConversionFactor() {
		return factor;
	}

	// convert value to base unit
	public double convertToBaseUnit(double value) {
		return value * factor;
	}

	// convert value from base unit to this unit
	public double convertFromBaseUnit(double baseValue) {
		return baseValue / factor;
	}

	@Override
	public String getUnitName() {
		return name();
	}
}