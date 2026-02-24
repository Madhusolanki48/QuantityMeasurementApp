package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
	// UC-7 : Addition with Explicit Target Unit
	// result explicitly in FEET
	@Test
	void testAddition_ExplicitTargetUnit_Feet() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

		QuantityLength result = q1.add(q2, LengthUnit.FEET);

		assertEquals(2.0, result.getValue(), 1e-6);
		assertEquals(LengthUnit.FEET, result.getUnit());
	}

	// result explicitly in INCH
	@Test
	void testAddition_ExplicitTargetUnit_Inches() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

		QuantityLength result = q1.add(q2, LengthUnit.INCH);

		assertEquals(24.0, result.getValue(), 1e-6);
		assertEquals(LengthUnit.INCH, result.getUnit());
	}

	// result explicitly in YARDS
	@Test
	void testAddition_ExplicitTargetUnit_Yards() {
		QuantityLength q1 = new QuantityLength(3.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);

		QuantityLength result = q1.add(q2, LengthUnit.YARDS);

		assertEquals(2.0, result.getValue(), 1e-6);
		assertEquals(LengthUnit.YARDS, result.getUnit());
	}

	// result explicitly in CENTIMETERS
	@Test
	void testAddition_ExplicitTargetUnit_Centimeters() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
		QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);

		QuantityLength result = q1.add(q2, LengthUnit.CENTIMETERS);

		assertEquals(5.08, result.getValue(), 1e-2);
		assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
	}

	// null target unit should throw exception
	@Test
	void testAddition_ExplicitTargetUnit_NullTargetUnit() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

		assertThrows(IllegalArgumentException.class, () -> q1.add(q2, (LengthUnit) null));
	}

	// null second operand should throw exception
	@Test
	void testAddition_ExplicitTargetUnit_NullSecondOperand() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);

		assertThrows(IllegalArgumentException.class, () -> q1.add(null, LengthUnit.FEET));
	}

}