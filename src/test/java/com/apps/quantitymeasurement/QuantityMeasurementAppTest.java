package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest {
    // -------------------------  UC-1 Feet Tests ------------------------
    //verifies that two Feet objects with the same value are equal
    @Test
    void testEquality_SameValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        assertTrue(f1.equals(f2), "1.0 ft should equal 1.0 ft");
    }

    //verifies that Feet objects with different values are not equal
    @Test
    void testEquality_DifferentValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);
        assertFalse(f1.equals(f2), "1.0 ft should not equal 2.0 ft");
    }

    //ensures comparison with null returns false
    @Test
    void testEquality_NullComparison() {
        Feet f1 = new Feet(1.0);
        assertFalse(f1.equals(null), "Feet should not equal null");
    }

    //validates reflexive property: object must equal itself
    @Test
    void testEquality_SameReference() {
        Feet f1 = new Feet(1.0);
        assertTrue(f1.equals(f1), "Object must equal itself");
    }

    //ensures Feet is not equal to an object of different type
    @Test
    void testEquality_NonNumericInput() {
        Feet f1 = new Feet(1.0);
        Object obj = new Object();
        assertFalse(f1.equals(obj), "Feet should not equal different object type");
    }
	// -------------------------- UC-2 Inches Tests ---------------------

	@Test
	void testInchesEquality_SameValue() {
		Inches i1 = new Inches(1.0);
		Inches i2 = new Inches(1.0);
		assertTrue(i1.equals(i2), "1.0 inch should equal 1.0 inch");
	}
	@Test
	void testInchesEquality_DifferentValue() {
		Inches i1 = new Inches(1.0);
		Inches i2 = new Inches(2.0);
		assertFalse(i1.equals(i2), "1.0 inch should not equal 2.0 inch");
	}

	@Test
	void testInchesEquality_NullComparison() {
		Inches i1 = new Inches(1.0);
		assertFalse(i1.equals(null), "Inches should not equal null");
	}
	@Test
	void testInchesEquality_SameReference() {
		Inches i1 = new Inches(1.0);
		assertFalse(i1.equals(i1), "Object must equal itself");
	}
	@Test
	void testInchesEquality_DifferentClass() {
		Inches i1 = new Inches(1.0);
		assertFalse(i1.equals(new Object()), "Inches should not equal different type");
	}
}