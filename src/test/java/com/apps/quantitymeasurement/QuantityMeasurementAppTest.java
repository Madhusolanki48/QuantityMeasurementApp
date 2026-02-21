package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
    ////UC-3 : Generic QuantityLength for DRY principle
    //verifies that Quantity in feet with the same value are equal
    @Test
    void testEquality_FeetToFeet_SameValue() {
    	QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2), "1.0 ft should equal 1.0 ft");
    }
    //verifies that Quantity in inches with same value are equal
    @Test
    void testEquality_InchToInch_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "1.0 inch should equal 1.0 inch");
    }

    //verifies cross-unit equality (1 ft = 12 inch)
    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "1 ft should equal 12 inches");
    }

    //verifies symmetry of cross-unit comparison
    @Test
    void testEquality_InchToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2), "12 inches should equal 1 ft");
    }

    //verifies different feet values are not equal
    @Test
    void testEquality_FeetToFeet_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2), "1 ft should not equal 2 ft");
    }

    //ensures comparison with null returns false
    @Test
    void testEquality_NullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(null), "Quantity should not equal null");
    }

	// validates reflexive property: object must equal itself
	@Test
	void testEquality_SameReference() {
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		assertTrue(q1.equals(q1), "Object must equal itself");
	}

	// verifies null unit is rejected
	@Test
	void testEquality_NullUnit() {
		assertThrows(IllegalArgumentException.class, () -> new QuantityLength(1.0, null));
	}
	
}