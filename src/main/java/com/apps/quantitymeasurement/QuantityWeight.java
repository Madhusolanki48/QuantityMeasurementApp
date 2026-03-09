package com.apps.quantitymeasurement;
//UC-9 : QuantityWeight class for weight measurements
public class QuantityWeight {

	private final double value;
	private final WeightUnit unit;

	//constructor
	public QuantityWeight(double value, WeightUnit unit) {

		if (unit == null)
			throw new IllegalArgumentException("Unit cannot be null");

		if (!Double.isFinite(value))
			throw new IllegalArgumentException("Invalid value");

		this.value = value;
		this.unit = unit;
	}

	public double getValue() {
		return value;
	}

	public WeightUnit getUnit() {
		return unit;
	}

	//convert to base unit 
	private double toBaseUnit() {
		return unit.convertToBaseUnit(value);
	}

	//equals comparison
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		QuantityWeight other = (QuantityWeight) obj;

		return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
	}

	@Override
	public int hashCode() {
		return Double.hashCode(toBaseUnit());
	}

	//convert to target unit
	public QuantityWeight convertTo(WeightUnit targetUnit) {

		if (targetUnit == null)
			throw new IllegalArgumentException("Target unit cannot be null");

		double baseValue = unit.convertToBaseUnit(value);
		double converted = targetUnit.convertFromBaseUnit(baseValue);

		return new QuantityWeight(converted, targetUnit);
	}

	//addition (default result in first unit)
	public QuantityWeight add(QuantityWeight other) {

		if (other == null)
			throw new IllegalArgumentException("Other weight cannot be null");

		double baseSum = this.toBaseUnit() + other.toBaseUnit();

		double result = unit.convertFromBaseUnit(baseSum);

		return new QuantityWeight(result, unit);
	}

	//addition with explicit target unit
	public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {

		if (other == null || targetUnit == null)
			throw new IllegalArgumentException("Invalid input");

		double baseSum = this.toBaseUnit() + other.toBaseUnit();

		double result = targetUnit.convertFromBaseUnit(baseSum);

		return new QuantityWeight(result, targetUnit);
	}
}