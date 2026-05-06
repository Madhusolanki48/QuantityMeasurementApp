package com.apps.quantitymeasurement.common.model;

import com.apps.quantitymeasurement.common.units.IMeasurable;

public class Quantity<U extends IMeasurable> {

	private final double value;
	private final U unit;

	public Quantity(double value, U unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit cannot be null");
		}
		this.value = value;
		this.unit = unit;
	}

	public double getValue() {
		return value;
	}

	public U getUnit() {
		return unit;
	}

	public Quantity<U> convertTo(U targetUnit) {
		double base = unit.convertToBaseUnit(value);
		double converted = targetUnit.convertFromBaseUnit(base);
		return new Quantity<>(round(converted), targetUnit);
	}

	public Quantity<U> add(Quantity<U> other, U targetUnit) {
		validate(other, "addition");
		double sum = base(this) + base(other);
		return new Quantity<>(round(targetUnit.convertFromBaseUnit(sum)), targetUnit);
	}

	public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
		validate(other, "subtraction");
		double diff = base(this) - base(other);
		return new Quantity<>(round(targetUnit.convertFromBaseUnit(diff)), targetUnit);
	}

	public double divide(Quantity<U> other) {
		validate(other, "division");
		return base(this) / base(other);
	}

	private void validate(Quantity<U> other, String operation) {
		if (other == null) {
			throw new IllegalArgumentException("Null operand");
		}
		unit.validateOperationSupport(operation);
		other.unit.validateOperationSupport(operation);
	}

	private double base(Quantity<U> quantity) {
		return quantity.unit.convertToBaseUnit(quantity.value);
	}

	private double round(double value) {
		return Math.round(value * 100.0) / 100.0;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Quantity<?> other)) {
			return false;
		}
		return Double.compare(base(this), other.unit.convertToBaseUnit(other.getValue())) == 0;
	}

	@Override
	public String toString() {
		return value + " " + unit.getUnitName();
	}
}
