package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
	//main method 
	public static void main(String[] args) {
		System.out.println("--------  Welcome to Quantity Measurement App  --------");
		System.out.println("-------------------------------------------------------");
		//UC-3 : Generic QuantityLength for DRY principle
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q4 = new QuantityLength(1.0, LengthUnit.INCH);
        
        //UC-5 : Unit-to-Unit Conversion
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        double inches = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
        
        //UC-7
        QuantityLength r = q1.add(q2, LengthUnit.YARDS);

        System.out.println("Feet comparison result: " + q1.equals(q2));
        System.out.println("Inches comparison result: " + q3.equals(q4));
        System.out.println("1 foot in inches = " + inches);
        System.out.println("1 yard in feet = " + yard.convertTo(LengthUnit.FEET));
        System.out.println("Explicit target (yards): " + r.getValue());
        
		//UC-9 : Weight measurement
		QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
		QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

		System.out.println("Weight equality: " + w1.equals(w2));

		QuantityWeight converted = w1.convertTo(WeightUnit.GRAM);
		System.out.println("1 kg in grams = " + converted.getValue());

		QuantityWeight sum = w1.add(w2);
		System.out.println("Weight addition result = " + sum.getValue() + " " + sum.getUnit());
    }
}