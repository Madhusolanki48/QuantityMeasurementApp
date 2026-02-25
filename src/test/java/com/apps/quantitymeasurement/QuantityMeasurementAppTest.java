package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
	// UC-6 : Addition of Two Length Units
	 @Test
	    void testAddition_SameUnit_FeetPlusFeet() {
	        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
	        Length l2 = new Length(2.0, Length.LengthUnit.FEET);
	        Length result = l1.add(l2);
	        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
	    }

	    @Test
	    void testAddition_SameUnit_InchPlusInch() {
	        Length l1 = new Length(6.0, Length.LengthUnit.INCH);
	        Length l2 = new Length(6.0, Length.LengthUnit.INCH);
	        Length result = l1.add(l2);
	        assertEquals(new Length(12.0, Length.LengthUnit.INCH), result);
	    }

	    @Test
	    void testAddition_CrossUnit_FeetPlusInches() {
	        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
	        Length l2 = new Length(12.0, Length.LengthUnit.INCH);
	        Length result = l1.add(l2);
	        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
	    }

	    @Test
	    void testAddition_CrossUnit_InchPlusFeet() {
	        Length l1 = new Length(12.0, Length.LengthUnit.INCH);
	        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
	        Length result = l1.add(l2);
	        assertEquals(new Length(24.0, Length.LengthUnit.INCH), result);
	    }

	    @Test
	    void testAddition_CrossUnit_YardPlusFeet() {
	        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
	        Length l2 = new Length(3.0, Length.LengthUnit.FEET);
	        Length result = l1.add(l2);
	        assertEquals(new Length(2.0, Length.LengthUnit.YARDS), result);
	    }

	    @Test
	    void testAddition_CrossUnit_CentimeterPlusInch() {
	        Length l1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
	        Length l2 = new Length(1.0, Length.LengthUnit.INCH);
	        Length result = l1.add(l2);
	        assertEquals(5.08, result.getValue(), 0.01);
	        assertEquals(Length.LengthUnit.CENTIMETERS, result.convertTo(Length.LengthUnit.CENTIMETERS).convertTo(Length.LengthUnit.CENTIMETERS).unit);
	    }

	    @Test
	    void testAddition_Commutativity() {
	        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
	        Length l2 = new Length(12.0, Length.LengthUnit.INCH);
	        assertEquals(l1.add(l2), l2.add(l1));
	    }

	    @Test
	    void testAddition_WithZero() {
	        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
	        Length l2 = new Length(0.0, Length.LengthUnit.INCH);
	        Length result = l1.add(l2);
	        assertEquals(new Length(5.0, Length.LengthUnit.FEET), result);
	    }

	    @Test
	    void testAddition_NegativeValues() {
	        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
	        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);
	        Length result = l1.add(l2);
	        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
	    }

	    @Test
	    void testAddition_NullSecondOperand() {
	        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
	        assertThrows(IllegalArgumentException.class, () -> l1.add(null));
	    }

	    @Test
	    void testAddition_LargeValues() {
	        Length l1 = new Length(1e6, Length.LengthUnit.FEET);
	        Length l2 = new Length(1e6, Length.LengthUnit.FEET);
	        Length result = l1.add(l2);
	        assertEquals(new Length(2e6, Length.LengthUnit.FEET), result);
	    }

	    @Test
	    void testAddition_SmallValues() {
	        Length l1 = new Length(0.001, Length.LengthUnit.FEET);
	        Length l2 = new Length(0.002, Length.LengthUnit.FEET);
	        Length result = l1.add(l2);
	        assertEquals(0.003, result.getValue(), 0.001);
	}
}