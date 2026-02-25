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

	// verifies 1 yard equals 36 inches
	@Test
	void testEquals36Inches() {
		Length yard = new Length(1.0, Length.LengthUnit.YARDS);
		Length inch = new Length(36.0, Length.LengthUnit.INCH);
		assertTrue(yard.equals(inch));
	}

	// verifies 1 cm equals 0.393701 inches
	@Test
	void centimeterEquals39Point3701Inches() {
		Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
		Length inch = new Length(0.393701, Length.LengthUnit.INCH);
		assertTrue(cm.equals(inch));
	}

	// verifies 3 feet equals 1 yard
	@Test
	void threeFeetEqualsOneYard() {
		Length feet = new Length(3, Length.LengthUnit.FEET);
		Length yard = new Length(1, Length.LengthUnit.YARDS);
		assertTrue(feet.equals(yard));
	}
	// verifies 30.48 centimeters equals 1 foot (using conversion factors)
	@Test
	public void thirtyPoint48CmEqualsOneFoot() {
		double cmInInches = 30.48 * Length.LengthUnit.CENTIMETERS.getConversionFactor();
		double footInInches = 1.0 * Length.LengthUnit.FEET.getConversionFactor();
		assertEquals(cmInInches, footInInches, 0.001);
	}

	// verifies yard is not equal to 12 inches
	@Test
	void yardNotEqualToInches() {
		Length yard = new Length(1.0, Length.LengthUnit.YARDS);
		Length inch = new Length(12.0, Length.LengthUnit.INCH);
		assertFalse(yard.equals(inch));
	}
	// verifies reference equality (same object comparison)
	@Test
	public void referenceEqualitySameObject() {
		Length length = new Length(1.0, Length.LengthUnit.FEET);
		assertEquals(length, length);
	}
	// verifies equals method returns false when compared with null
	@Test
	public void equalsReturnsFalseForNull() {
		Length length = new Length(1.0, Length.LengthUnit.FEET);
		assertNotEquals(length, null);
	}

	// verifies reflexive, symmetric, and transitive properties of equals
	@Test
	void reflexiveSymmetricAndTransitiveProperty() {
		Length yard = new Length(1.0, Length.LengthUnit.YARDS);
		Length feet = new Length(3.0, Length.LengthUnit.FEET);
		Length inch = new Length(36.0, Length.LengthUnit.INCH);
		assertTrue(yard.equals(feet));
		assertTrue(feet.equals(inch));
		assertTrue(yard.equals(inch));
	}
	// verifies different values of same unit are not equal
	@Test
	public void differentValuesSameUnitNotEqual() {
		Length l1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
		Length l2 = new Length(2.0, Length.LengthUnit.CENTIMETERS);
		assertNotEquals(l1, l2);
	}
	// verifies cross-unit equality using demonstrateLengthComparison method
	@Test
	public void crossUnitEqualityDemonstrateMethod() {
		assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 3.0,
				Length.LengthUnit.FEET));
	}

}