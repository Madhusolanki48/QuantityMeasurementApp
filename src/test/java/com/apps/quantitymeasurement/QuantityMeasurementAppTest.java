package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
	// UC-10 : Generic Quantity with IMeasurable Interface

	// verifies LengthUnit implements IMeasurable
	@Test
	void testIMeasurableInterface_LengthUnitImplementation() {
		assertTrue(LengthUnit.FEET instanceof IMeasurable);
	}

	// verifies WeightUnit implements IMeasurable
	@Test
	void testIMeasurableInterface_WeightUnitImplementation() {
		assertTrue(WeightUnit.KILOGRAM instanceof IMeasurable);
	}

	// verifies equality for length quantities
	@Test
	void testGenericQuantity_LengthOperations_Equality() {
		Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
		Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);

		assertTrue(q1.equals(q2));
	}

	// verifies equality for weight quantities
	@Test
	void testGenericQuantity_WeightOperations_Equality() {
		Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
		Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

		assertTrue(w1.equals(w2));
	}

	// verifies conversion for length
	@Test
	void testGenericQuantity_LengthOperations_Conversion() {
		Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);

		Quantity<LengthUnit> result = q.convertTo(LengthUnit.INCH);

		assertEquals(12.0, result.getValue(), 1e-6);
	}

	// verifies conversion for weight
	@Test
	void testGenericQuantity_WeightOperations_Conversion() {
		Quantity<WeightUnit> q = new Quantity<>(1.0, WeightUnit.KILOGRAM);

		Quantity<WeightUnit> result = q.convertTo(WeightUnit.GRAM);

		assertEquals(1000.0, result.getValue(), 1e-6);
	}

	// verifies addition for length
	@Test
	void testGenericQuantity_LengthOperations_Addition() {
		Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
		Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);

		Quantity<LengthUnit> result = q1.add(q2, LengthUnit.FEET);

		assertEquals(2.0, result.getValue(), 1e-6);
	}

	// verifies addition for weight
	@Test
	void testGenericQuantity_WeightOperations_Addition() {
		Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
		Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

		Quantity<WeightUnit> result = w1.add(w2, WeightUnit.KILOGRAM);

		assertEquals(2.0, result.getValue(), 1e-6);
	}

	// verifies cross-category comparison prevention
	@Test
	void testCrossCategoryPrevention_LengthVsWeight() {
		Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
		Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

		assertFalse(length.equals(weight));
	}
}