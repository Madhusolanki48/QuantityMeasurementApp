package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
	// UC-6 : Addition of Two Length Units
	public static String demonstrateLengthAddition(Length length1, Length length2) {
		Length result=length1.add(length2);
		return String.format("Adding: %s + %s = %s",length1,length2,result);
	}
	
	public static String demonstrateLengthEquality(Length length1, Length length2) {
		return String.format("Comparing: %s and %s => %s",length1,length2,length1.equals(length2));
	}
	
	public static String demonstrateLengthConversion(Length length, Length.LengthUnit toUnit) {
		Length converted=length.convertTo(toUnit);
		return String.format("Converting : %s -> %s",length , converted);
	}

	public static void main(String[] args) {
		System.out.println("--------  Welcome to Quantity Measurement App  --------");
		System.out.println("-------------------------------------------------------");
		// UC-6 : Addition of Two Length Units
		Length l1 = new Length(1.0, Length.LengthUnit.FEET);
		Length l2 = new Length(12.0, Length.LengthUnit.INCH);
		Length l3 = new Length(2.0, Length.LengthUnit.YARDS);
		Length l4 = new Length(24.0, Length.LengthUnit.INCH);
		Length l5 = new Length(100.0, Length.LengthUnit.CENTIMETERS);
		Length l6 = new Length(1.0, Length.LengthUnit.FEET);
		Length l7 = new Length(3.0, Length.LengthUnit.FEET);
		Length l8 = new Length(36.0, Length.LengthUnit.INCH);
		Length l9 = new Length(5.0, Length.LengthUnit.FEET);
		System.out.println(demonstrateLengthAddition(l1, l2));
		System.out.println("-------------------------------------------------------");
		System.out.println(demonstrateLengthAddition(l3, l4));
		System.out.println("-------------------------------------------------------");
		System.out.println(demonstrateLengthAddition(l5, l6));
		System.out.println("-------------------------------------------------------");
		System.out.println(demonstrateLengthEquality(l7, l8));
		System.out.println("-------------------------------------------------------");
		System.out.println(demonstrateLengthConversion(l9, Length.LengthUnit.CENTIMETERS));
		System.out.println("-------------------------------------------------------");
	}
}