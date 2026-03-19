package com.apps.quantitymeasurement.utils;
import com.apps.quantitymeasurement.units.LengthUnit;

public class QuantityConverter {

	public static double convert(double value, LengthUnit from, LengthUnit to) {

		double base = from.convertToBaseUnit(value);
		return base / to.convertToBaseUnit(1);
	}
}