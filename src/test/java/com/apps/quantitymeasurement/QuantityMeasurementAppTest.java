package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
	// UC-8 : Refactored Unit Conversion & Validation Tests

	// verifies LengthUnit.FEET constant and conversion factor
	@Test
	void testLengthUnitEnum_FeetConstant() {
		assertEquals(1.0, LengthUnit.FEET.getConversionFactor(), 1e-6);
	}

	// verifies LengthUnit.INCH constant and conversion factor
	@Test
	void testLengthUnitEnum_InchesConstant() {
		assertEquals(1.0 / 12.0, LengthUnit.INCH.getConversionFactor(), 1e-6);
	}

	// verifies LengthUnit.YARDS constant and conversion factor
	@Test
	void testLengthUnitEnum_YardsConstant() {
		assertEquals(3.0, LengthUnit.YARDS.getConversionFactor(), 1e-6);
	}

	// verifies LengthUnit.CENTIMETERS constant and conversion factor
	@Test
	void testLengthUnitEnum_CentimetersConstant() {
		assertEquals(0.0328084, LengthUnit.CENTIMETERS.getConversionFactor(), 1e-6);
	}

	// verifies conversion to base unit when already in base unit
	@Test
	void testConvertToBaseUnit_FeetToFeet() {
		assertEquals(5.0, LengthUnit.FEET.convertToBaseUnit(5.0), 1e-6);
	}

	// verifies conversion from inches to feet
	@Test
	void testConvertToBaseUnit_InchesToFeet() {
		assertEquals(1.0, LengthUnit.INCH.convertToBaseUnit(12.0), 1e-6);
	}

	// verifies conversion from yards to feet
	@Test
	void testConvertToBaseUnit_YardsToFeet() {
		assertEquals(3.0, LengthUnit.YARDS.convertToBaseUnit(1.0), 1e-6);
	}

	// verifies conversion from centimeters to feet
	@Test
	void testConvertToBaseUnit_CentimetersToFeet() {
		assertEquals(1.0, LengthUnit.CENTIMETERS.convertToBaseUnit(30.48), 1e-2);
	}

	// verifies conversion from base unit feet to feet
	@Test
	void testConvertFromBaseUnit_FeetToFeet() {
		assertEquals(2.0, LengthUnit.FEET.convertFromBaseUnit(2.0), 1e-6);
	}

	// verifies conversion from feet to inches
	@Test
	void testConvertFromBaseUnit_FeetToInches() {
		assertEquals(12.0, LengthUnit.INCH.convertFromBaseUnit(1.0), 1e-6);
	}

	// verifies conversion from feet to yards
	@Test
	void testConvertFromBaseUnit_FeetToYards() {
		assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(3.0), 1e-6);
	}

	// verifies conversion from feet to centimeters
	@Test
	void testConvertFromBaseUnit_FeetToCentimeters() {
		assertEquals(30.48, LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0), 1e-2);
	}

	// verifies equality after refactored unit conversion
	@Test
	void testQuantityLengthRefactored_Equality() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

		assertTrue(q1.equals(q2));
	}

	// verifies convertTo() method using unit conversion
	@Test
	void testQuantityLengthRefactored_ConvertTo() {
		QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);

		double result = q.convertTo(LengthUnit.INCH);

		assertEquals(12.0, result, 1e-6);
	}

	// verifies add() using unit conversion
	@Test
	void testQuantityLengthRefactored_Add() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

		QuantityLength result = q1.add(q2, LengthUnit.FEET);

		assertEquals(2.0, result.getValue(), 1e-6);
	}

	// verifies add() with explicit target unit
	@Test
	void testQuantityLengthRefactored_AddWithTargetUnit() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

		QuantityLength result = q1.add(q2, LengthUnit.YARDS);

		assertEquals(0.667, result.getValue(), 1e-2);
	}

	// verifies null unit validation
	@Test
	void testQuantityLengthRefactored_NullUnit() {
		assertThrows(IllegalArgumentException.class, () -> new QuantityLength(1.0, null));
	}

	// verifies invalid value validation
	@Test
	void testQuantityLengthRefactored_InvalidValue() {
		assertThrows(IllegalArgumentException.class, () -> new QuantityLength(Double.NaN, LengthUnit.FEET));
	}
}