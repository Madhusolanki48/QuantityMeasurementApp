package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityWeightTest {

	// UC-9 : Weight Equality Tests

	@Test
	void testEquality_KilogramToKilogram_SameValue() {
		QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
		QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

		assertTrue(w1.equals(w2));
	}

	@Test
	void testEquality_KilogramToKilogram_DifferentValue() {
		QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
		QuantityWeight w2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);

		assertFalse(w1.equals(w2));
	}

	@Test
	void testEquality_KilogramToGram_EquivalentValue() {
		QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
		QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

		assertTrue(w1.equals(w2));
	}

	@Test
	void testEquality_GramToKilogram_EquivalentValue() {
		QuantityWeight w1 = new QuantityWeight(1000.0, WeightUnit.GRAM);
		QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

		assertTrue(w1.equals(w2));
	}

	@Test
	void testEquality_NullComparison() {
		QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

		assertFalse(w1.equals(null));
	}

	@Test
	void testEquality_SameReference() {
		QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

		assertTrue(w1.equals(w1));
	}

	// UC-9 : Conversion Tests

	@Test
	void testConversion_KilogramToGram() {
		QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

		QuantityWeight result = w.convertTo(WeightUnit.GRAM);

		assertEquals(1000.0, result.getValue(), 1e-6);
	}

	@Test
	void testConversion_PoundToKilogram() {
		QuantityWeight w = new QuantityWeight(2.20462, WeightUnit.POUND);

		QuantityWeight result = w.convertTo(WeightUnit.KILOGRAM);

		assertEquals(1.0, result.getValue(), 1e-3);
	}

	// UC-9 : Addition Tests

	@Test
	void testAddition_SameUnit_KilogramPlusKilogram() {
		QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
		QuantityWeight w2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);

		QuantityWeight result = w1.add(w2);

		assertEquals(3.0, result.getValue(), 1e-6);
	}

	@Test
	void testAddition_CrossUnit_KilogramPlusGram() {
		QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
		QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

		QuantityWeight result = w1.add(w2);

		assertEquals(2.0, result.getValue(), 1e-6);
	}

	@Test
	void testAddition_ExplicitTargetUnit() {
		QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
		QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

		QuantityWeight result = w1.add(w2, WeightUnit.GRAM);

		assertEquals(2000.0, result.getValue(), 1e-6);
	}
}