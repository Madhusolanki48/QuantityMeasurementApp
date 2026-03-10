package com.apps.quantitymeasurement;

// UC-14 : Temperature Units (base unit = Celsius)
public enum TemperatureUnit implements IMeasurable {

    CELSIUS,
    FAHRENHEIT;

    // temperature does NOT support arithmetic
    SupportsArithmetic supportsArithmetic = () -> false;

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
            "Temperature does not support " + operation + " operation");
    }

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    // convert to base unit (Celsius)
    @Override
    public double convertToBaseUnit(double value) {
        if (this == CELSIUS)
            return value;

        // Fahrenheit → Celsius
        return (value - 32) * 5 / 9;
    }

    // convert from base unit (Celsius)
    @Override
    public double convertFromBaseUnit(double baseValue) {
        if (this == CELSIUS)
            return baseValue;

        // Celsius → Fahrenheit
        return (baseValue * 9 / 5) + 32;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}