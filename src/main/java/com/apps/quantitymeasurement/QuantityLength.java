package com.apps.quantitymeasurement;
//UC-3 : Generic QuantityLength for DRY principle
// generic quantity class representing length with unit
public class QuantityLength {
    //attributes
    private final double value;
    private final LengthUnit unit;
    //constructor
    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }
    //getter method
    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    //converts this quantity to base unit i.e. feet
    private double toBaseUnit() {
        return unit.toFeet(value);
    }

    @Override
    public boolean equals(Object obj) {
        //reflexive check
        if (this == obj) return true;

        //null safety
        if (obj == null) return false;

        //type safety
        if (getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;

        //compare after conversion to common base unit
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBaseUnit());
    }

	// UC-5 : Unit-to-Unit Conversion
	// method to convert a numeric value from source unit to target unit
	public static double convert(double value, LengthUnit source, LengthUnit target) {

		// validate numeric value
		if (!Double.isFinite(value)) {
			throw new IllegalArgumentException("Value must be finite");
		}

		// validate units
		if (source == null || target == null) {
			throw new IllegalArgumentException("Units cannot be null");
		}

		// normalize to base unit feet
		double valueInFeet = source.toFeet(value);

		// convert from base unit to target unit
		return valueInFeet / target.toFeet(1.0);
	}

	// instance method to convert this quantity to target unit
	public double convertTo(LengthUnit targetUnit) {
		return convert(this.value, this.unit, targetUnit);
	}
}