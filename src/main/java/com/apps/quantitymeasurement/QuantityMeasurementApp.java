package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
	//main method 
	public static void main(String[] args) {
		System.out.println("--------  Welcome to Quantity Measurement App  --------");
		System.out.println("-------------------------------------------------------");
		//UC-3 : Generic QuantityLength for DRY principle
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<LengthUnit> q3 = new Quantity<>(1.0, LengthUnit.INCH);
        Quantity<LengthUnit> q4 = new Quantity<>(1.0, LengthUnit.INCH);
        
        //UC-5 : Unit-to-Unit Conversion
        Quantity<LengthUnit> yard = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> inches = q1.convertTo(LengthUnit.INCH);
        
        //UC-7
        Quantity<LengthUnit> r = q1.add(q2, LengthUnit.YARDS);

        System.out.println("Feet comparison result: " + q1.equals(q2));
        System.out.println("Inches comparison result: " + q3.equals(q4));
        System.out.println("1 foot in inches = " + inches);
        System.out.println("1 yard in feet = " + yard.convertTo(LengthUnit.FEET));
        System.out.println("Explicit target (yards): " + r.getValue());
        
		//UC-9 : Weight measurement
		Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
		Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

		System.out.println("Weight equality: " + w1.equals(w2));

		Quantity<WeightUnit> converted = w1.convertTo(WeightUnit.GRAM);
		System.out.println("1 kg in grams = " + converted.getValue());

		Quantity<WeightUnit> sum = w1.add(w2);
		System.out.println("Weight addition result = " + sum.getValue() + " " + sum.getUnit());
    }
}