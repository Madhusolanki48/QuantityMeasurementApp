package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
    // Equality Tests
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
    
    //Cross unit equality tests
    //verifies cross-unit equality (1 ft = 12 inch)
    @Test
    void testFeetInchesComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inch = new Length(12.0, Length.LengthUnit.INCH);
        assertTrue(feet.equals(inch));
    }
    
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
	
	//Inequality Tests
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

	// verifies yard is not equal to 12 inches
	@Test
	void yardNotEqualToInches() {
		Length yard = new Length(1.0, Length.LengthUnit.YARDS);
		Length inch = new Length(12.0, Length.LengthUnit.INCH);
		assertFalse(yard.equals(inch));
	}
	
	//Equality Contract Tests
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
		assertTrue(yard.equals(yard));   //reflexive
		assertTrue(yard.equals(feet));   //symmetric
		assertTrue(feet.equals(yard));   //symmetric
		//transitive
		assertTrue(yard.equals(feet));  
		assertTrue(feet.equals(inch));
		assertTrue(yard.equals(inch));
	}

	// Conversion Tests (App Layer)
	@Test
	public void convertFeetToInches() {
		Length result = QuantityMeasurementApp.demonstrateLengthConversion(3.0, Length.LengthUnit.FEET,
				Length.LengthUnit.INCH);
		Length expected = new Length(36.0, Length.LengthUnit.INCH);
		assertTrue(result.equals(expected));
	}

	@Test
	public void convertYardsToInchesUsingOverloadedMethod() {
		Length yards = new Length(2.0, Length.LengthUnit.YARDS);
		Length result = QuantityMeasurementApp.demonstrateLengthConversion(yards, Length.LengthUnit.INCHES);
		Length expected = new Length(72.0, Length.LengthUnit.INCH);
		assertTrue(result.equals(expected));
	}

}