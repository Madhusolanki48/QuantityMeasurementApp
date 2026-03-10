package com.apps.quantitymeasurement;

// UC-10 : Interface for all measurable units
public interface IMeasurable {
    double getConversionFactor();
    double convertToBaseUnit(double value);
    double convertFromBaseUnit(double baseValue);
    String getUnitName();
    
	// UC-14 : Functional Interface to indicate arithmetic support
	@FunctionalInterface
	interface SupportsArithmetic {
		boolean isSupported();
	}

	// default lambda expression - arithmetic supported by default
	SupportsArithmetic supportsArithmetic = () -> true;

	// default method to check arithmetic support
	default boolean supportsArithmetic() {
		return supportsArithmetic.isSupported();
	}

	// default validation method for operations
	default void validateOperationSupport(String operation) {
		// default: all operations allowed
	}
}