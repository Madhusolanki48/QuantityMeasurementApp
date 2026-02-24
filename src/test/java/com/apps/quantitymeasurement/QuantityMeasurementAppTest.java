package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
	// UC-6 : Addition of Two Length Units
	// Same-unit addition - feet + feet
    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);

        assertEquals(3.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // Same-unit addition - inch + inch
    @Test
    void testAddition_SameUnit_InchPlusInch() {
        QuantityLength q1 = new QuantityLength(6.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(6.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);

        assertEquals(12.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.INCH, result.getUnit());
    }

    // Cross-unit addition (feet + inches → result in feet)
    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);

        assertEquals(2.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // Cross-unit addition (inches + feet → result in inches)
    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);

        assertEquals(24.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.INCH, result.getUnit());
    }

    // Cross-unit addition (yard + feet → result in yards)
    @Test
    void testAddition_CrossUnit_YardPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);

        assertEquals(2.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    // Cross-unit addition (cm + inch → result in cm)
    @Test
    void testAddition_CrossUnit_CentimeterPlusInch() {
        QuantityLength q1 = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);

        QuantityLength result = q1.add(q2);

        assertEquals(5.08, result.getValue(), 1e-2); // within epsilon
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
    }

    // Commutativity check
    @Test
    void testAddition_Commutativity() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength r1 = a.add(b);
        QuantityLength r2 = b.add(a);

        assertTrue(r1.equals(r2));
    }

    // Identity element- adding zero
    @Test
    void testAddition_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCH);

        QuantityLength result = q1.add(q2);

        assertEquals(5.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // Negative values
    @Test
    void testAddition_NegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);

        QuantityLength result = q1.add(q2);

        assertEquals(3.0, result.getValue(), 1e-6);
    }

    // Null operand validation
    @Test
    void testAddition_NullSecondOperand() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }

    // Large values
    @Test
    void testAddition_LargeValues() {
        QuantityLength q1 = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1e6, LengthUnit.FEET);

        QuantityLength result = q1.add(q2);

        assertEquals(2e6, result.getValue(), 1e-6);
    }

    // Small values
    @Test
    void testAddition_SmallValues() {
        QuantityLength q1 = new QuantityLength(0.001, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.002, LengthUnit.FEET);

        QuantityLength result = q1.add(q2);

        assertEquals(0.003, result.getValue(), 1e-6);
    }

}