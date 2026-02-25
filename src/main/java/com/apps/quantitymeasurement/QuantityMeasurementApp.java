package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
	// main method
	public static void main(String[] args) {
		System.out.println("--------  Welcome to Quantity Measurement App  --------");
		System.out.println("-------------------------------------------------------");
		demonstrateFeetEquality();
		demonstrateInchesEquality();
		demonstrateFeetInchesComparison();
	}

	// UC-3 : Generic QuantityLength for DRY principle
	// demonstrate Feet equality
	public static void demonstrateFeetEquality() {
		Length q1 = new Length(1.0, Length.LengthUnit.FEET);
		Length q2 = new Length(1.0, Length.LengthUnit.FEET);

		System.out.print("Feet to Feet Comparison:");
		System.out.println(q1.equals(q2));
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
	}

	// demonstrate Feet and Inches comparison
	public static void demonstrateFeetInchesComparison() {
		Length q1 = new Length(1.0, Length.LengthUnit.FEET);
		Length q2 = new Length(12.0, Length.LengthUnit.INCH);
		System.out.print("Feet to Inches comparison result: ");
		System.out.println(q1.equals(q2));
		System.out.println("-------------------------------------------------------");
		System.out.println();
	} 

	// demonstrate Inches equality
	public static void demonstrateInchesEquality() {
		Length q1 = new Length(1.0, Length.LengthUnit.INCH);
		Length q2 = new Length(1.0, Length.LengthUnit.INCH);
		System.out.print("Inches to Inches comparison result: ");
		System.out.println(q1.equals(q2));
		System.out.println("-------------------------------------------------------");
		System.out.println();

	}
}