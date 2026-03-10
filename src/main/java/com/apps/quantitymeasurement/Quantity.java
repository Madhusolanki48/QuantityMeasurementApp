package com.apps.quantitymeasurement;

// UC-10 : Generic Quantity Class
public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

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

    public U getUnit() {
        return unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

	// UC-13 : Arithmetic operation enum
	private enum ArithmeticOperation {
		ADD, SUBTRACT, DIVIDE
	}
	// UC-13 : centralized validation helper
	private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean checkTargetUnit) {

		if (other == null)
			throw new IllegalArgumentException("Other quantity cannot be null");

		if (unit.getClass() != other.unit.getClass())
			throw new IllegalArgumentException("Cross-category operation not allowed");

		if (!Double.isFinite(this.value) || !Double.isFinite(other.value))
			throw new IllegalArgumentException("Invalid numeric value");

		if (checkTargetUnit && targetUnit == null)
			throw new IllegalArgumentException("Target unit cannot be null");
	}
	// UC-13 : core arithmetic helper
	private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation operation) {

		double base1 = this.toBaseUnit();
		double base2 = other.toBaseUnit();

		switch (operation) {

		case ADD:
			return base1 + base2;

		case SUBTRACT:
			return base1 - base2;

		case DIVIDE:
			if (base2 == 0)
				throw new ArithmeticException("Division by zero");
			return base1 / base2;

		default:
			throw new IllegalArgumentException("Unsupported operation");
		}
	}

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (unit.getClass() != other.unit.getClass())
            return false;

        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    public Quantity<U> convertTo(U targetUnit) {

        double base = unit.convertToBaseUnit(value);
        double result = targetUnit.convertFromBaseUnit(base);

        return new Quantity<>(result, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
    	unit.validateOperationSupport("addition");
    	validateArithmeticOperands(other, null, false);

        double sum = performBaseArithmetic(other, ArithmeticOperation.ADD);

        double result = unit.convertFromBaseUnit(sum);

    	return new Quantity<>(result, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

    	validateArithmeticOperands(other, targetUnit, true);

    	double sum = performBaseArithmetic(other, ArithmeticOperation.ADD);

    	double result = targetUnit.convertFromBaseUnit(sum);

    	return new Quantity<>(result, targetUnit);
    }
    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
    // UC-12 : Subtraction of Two Quantities
    // subtract another quantity and return result in this unit
    public Quantity<U> subtract(Quantity<U> other) {
    	unit.validateOperationSupport("subtraction");
    	validateArithmeticOperands(other, null, false);
    	double resultBase = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);

        double result = unit.convertFromBaseUnit(resultBase);

        // round to two decimal places
        result = Math.round(result * 100.0) / 100.0;

        return new Quantity<>(result, unit);
    }

    // subtract with explicit target unit
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
    	unit.validateOperationSupport("subtraction");
    	validateArithmeticOperands(other, targetUnit, true);

    	double resultBase = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);

        double result = targetUnit.convertFromBaseUnit(resultBase);

        result = Math.round(result * 100.0) / 100.0;

        return new Quantity<>(result, targetUnit);
    }

	// UC-12 : Division operation
	public double divide(Quantity<U> other) {
		unit.validateOperationSupport("division");
		validateArithmeticOperands(other, null, false);

		return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
	}
}
