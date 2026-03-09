package com.apps.quantitymeasurement;
//UC-9 : Weight Unit Enum (base unit = kg)
public enum WeightUnit {

	KILOGRAM(1.0),
	GRAM(0.001),          // 1 g = 0.001 kg
	POUND(0.453592);      // 1 lb ≈ 0.453592 kg

	private final double toKilogramFactor;

	WeightUnit(double toKilogramFactor) {
		this.toKilogramFactor = toKilogramFactor;
	}

	//returns conversion factor
	public double getConversionFactor() {
		return toKilogramFactor;
	}

	//convert value to base unit (kilogram)
	public double convertToBaseUnit(double value) {
		return value * toKilogramFactor;
	}

	//convert from base unit to this unit
	public double convertFromBaseUnit(double baseValue) {
		return baseValue / toKilogramFactor;
	}
}
