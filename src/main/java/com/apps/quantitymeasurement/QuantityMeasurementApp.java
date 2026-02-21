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

        System.out.println("Feet comparison result: " + q1.equals(q2));
        System.out.println("Inches comparison result: " + q3.equals(q4));
    }
}