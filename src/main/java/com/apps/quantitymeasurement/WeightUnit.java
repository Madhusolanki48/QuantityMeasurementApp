package com.apps.quantitymeasurement;
//UC-9 : Weight Unit Enum (base unit = kg)
public enum WeightUnit implements IMeasurable{

	KILOGRAM(1.0),
	GRAM(0.001),          // 1 g = 0.001 kg
	POUND(0.453592);      // 1 lb ≈ 0.453592 kg

	private final double factor;

	WeightUnit(double factor) {
		this.factor = factor;
	}

	//returns conversion factor
	public double getConversionFactor() {
		return factor;
	}

	//convert value to base unit (kilogram)
	public double convertToBaseUnit(double value) {
		return value * factor;
	}

	//convert from base unit to this unit
	public double convertFromBaseUnit(double baseValue) {
		return baseValue / factor;
	}
	@Override
	public String getUnitName() {
	    return name();
	}
}
