package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
	//------------------  UC-1  ---------------------
	//class representing a length measurement in feet
	public static class Feet {
		//attribute
		private final double value;

		//constructor
		public Feet(double value) {
			this.value = value;
		}
        //getter method
		public double getValue() {
			return value;
		}

		@Override
		public boolean equals(Object obj) {
			//reflexive check: same object reference
			if (this == obj)
				return true;

			if (obj == null)
				return false;
			//ensure both objects are of the same type
			if (getClass() != obj.getClass())
				return false;

			Feet other = (Feet) obj;
            //floating-point comparison
			return Double.compare(this.value, other.value) == 0;
		}
		@Override
		public int hashCode() {
		    return Double.hashCode(value);
		}
	}

	// ------------------ UC-2 ---------------------
	// class represents a length measurement in inches
	public static class Inches {
		// stores the measurement value in inches
		private final double value;

		public Inches(double value) {
			this.value = value;
		}

		// returns the inch value
		public double getValue() {
			return value;
		}

		@Override
		public boolean equals(Object obj) {
			// reflexive check: same object reference
			if (this == obj)
				return true;

			// null safety
			if (obj == null)
				return false;

			// ensure both objects are of the same type
			if (getClass() != obj.getClass())
				return false;

			// safe casting after type check
			Inches other = (Inches) obj;

			// precise floating-point comparison
			return Double.compare(this.value, other.value) == 0;
		}

		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}
	}

	// compares two feet values using Feet class
	public static boolean compareFeet(double v1, double v2) {
		Feet f1 = new Feet(v1);
		Feet f2 = new Feet(v2);
		return f1.equals(f2);
	}

	// compares two inch values using Inches class
	public static boolean compareInches(double v1, double v2) {
		Inches i1 = new Inches(v1);
		Inches i2 = new Inches(v2);
		return i1.equals(i2);
	}

	//main method 
	public static void main(String[] args) {
		System.out.println("--------  Welcome to Quantity Measurement App  --------");
		System.out.println("-------------------------------------------------------");
        //test values 
        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);
        boolean feetResult = compareFeet(1.0, 1.0);
        boolean inchResult = compareInches(1.0, 1.0);

        System.out.println("Feet comparison result: " + feetResult);
        System.out.println("Inches comparison result: " + inchResult);
    }
}