package com.apps.quantitymeasurement;
//UC-3 : Generic QuantityLength for DRY principle
//defines supported length units and their conversion to feet
public enum LengthUnit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    //UC-4 : Extended Unit Support - Yards & Centimeters
   	YARDS(3.0),                    // 1 yard = 3 feet
    CENTIMETERS(0.0328084);       // 1 cm = 0.0328084 feet

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    //method to convert given value to feet
    public double toFeet(double value) {
        return value * toFeetFactor;
    }
}