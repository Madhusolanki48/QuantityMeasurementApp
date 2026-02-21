package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
	//UC1
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

	//main method 
	public static void main(String[] args) {
		System.out.println("--------  Welcome to Quantity Measurement App  --------");
		System.out.println("-------------------------------------------------------");
        //test values 
        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);
        boolean result = first.equals(second);

        System.out.println("Feet comparison result: " + result);
    }
}