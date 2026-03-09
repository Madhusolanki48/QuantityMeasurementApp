package com.apps.quantitymeasurement;

// UC-10 : Interface for all measurable units
public interface IMeasurable {
    double getConversionFactor();
    double convertToBaseUnit(double value);
    double convertFromBaseUnit(double baseValue);
    String getUnitName();
}