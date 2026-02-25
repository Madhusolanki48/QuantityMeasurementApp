package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
    ////UC-3 : Generic QuantityLength for DRY principle
    //verifies that Quantity in feet with the same value are equal
    @Test
    void testFeetEquality() {
    	Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }
    //verifies that Quantity in inches with same value are equal
    @Test
    void testInchesEquality() {
        Length inch1 = new Length(1.0, Length.LengthUnit.INCH);
        Length inch2 = new Length(1.0, Length.LengthUnit.INCH);
        assertTrue(inch1.equals(inch2));
    }
    //verifies cross-unit equality (1 ft = 12 inch)
    @Test
    void testFeetInchesComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inch = new Length(12.0, Length.LengthUnit.INCH);
        assertTrue(feet.equals(inch));
    }
    //verifies different feet values are not equal
    @Test
    void testFeetInEquality() {
        Length feet1 = new Length(12.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }
    //verifies different inch values are not equal
    @Test
    void testInchesInEquality() {
        Length inch1 = new Length(1.0, Length.LengthUnit.INCH);
        Length inch2 = new Length(2.0, Length.LengthUnit.INCH);
        assertFalse(inch1.equals(inch2));
    }

    //verifies cross-unit equality (1 ft = 12 inch)
    @Test
    void testCrossUnitInequality() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inch = new Length(11.0, Length.LengthUnit.INCH);
        assertFalse(feet.equals(inch));
    }
    //verifies multiple feet values with same value are equal
    @Test
    public void testMultipleFeetComparison() {
        Length feet1 = new Length(2.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(2.0, Length.LengthUnit.FEET);

        assertEquals(feet1, feet2);
	}
	
	// UC-4 : Extended Unit Support - Yards & Centimeters

	// verifies yard to yard equality
	@Test
	void testEquality_YardToYard_SameValue() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
		QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
		assertTrue(q1.equals(q2));
	}

	// verifies yard to feet conversion
	@Test
	void testEquality_YardToFeet_EquivalentValue() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
		QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
		assertTrue(q1.equals(q2));
	}

	// verifies yard to inches conversion
	@Test
	void testEquality_YardToInches_EquivalentValue() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
		QuantityLength q2 = new QuantityLength(36.0, LengthUnit.INCH);
		assertTrue(q1.equals(q2));
	}

	// verifies centimeters to inches conversion
	@Test
	void testEquality_CentimeterToInch_EquivalentValue() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
		QuantityLength q2 = new QuantityLength(0.393701, LengthUnit.INCH);
		assertTrue(q1.equals(q2));
	}

	// verifies multi-unit transitive property
	@Test
	void testEquality_MultiUnit_TransitiveProperty() {
		QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
		QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
		QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);
		assertTrue(yard.equals(feet));
		assertTrue(feet.equals(inch));
		assertTrue(yard.equals(inch));
	}

}