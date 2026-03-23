package com.apps.quantitymeasurement.app;

import com.apps.quantitymeasurement.controller.QuantityMeasurementController;
import com.apps.quantitymeasurement.entity.Quantity;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;
import com.apps.quantitymeasurement.service.QuantityMeasurementServiceImpl;
import com.apps.quantitymeasurement.units.LengthUnit;
import com.apps.quantitymeasurement.units.TemperatureUnit;
import com.apps.quantitymeasurement.units.VolumeUnit;
import com.apps.quantitymeasurement.units.WeightUnit;
import com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.apps.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;

public class QuantityMeasurementApp {
	// main method
	public static void main(String[] args) {
		System.out.println("-------- Welcome to Quantity Measurement App ------- ");
		System.out.println("----------------------------------------------------");
		IQuantityMeasurementRepository repository = new QuantityMeasurementDatabaseRepository();
		IQuantityMeasurementService service = new QuantityMeasurementServiceImpl(repository);
		QuantityMeasurementController controller = new QuantityMeasurementController(service, repository);

		// ---------------- Length ---------------
		System.out.println("\n---------------- Length Measurement ----------------");

		Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
		Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCH);

		System.out.println("\n[LENGTH]");
		System.out.println("----------------------------------------------------");
		System.out.printf("Comparison   : %s == %s -> %s%n", feet, inches,
				controller.checkEquality(feet, inches) ? "TRUE" : "FALSE");
		System.out.printf("Conversion   : %s -> %s%n", feet, controller.convert(feet, LengthUnit.INCH));

		System.out.printf("Add (New)    : %s + %s -> %s%n", feet, inches,
				controller.add(feet, inches, LengthUnit.FEET));

		System.out.printf("Add (duplicate): %s + %s -> %s%n", feet, inches,
				controller.add(feet, inches, LengthUnit.FEET));

		System.out.printf("Subtract (New)  : %s - %s -> %s%n", feet, inches,
				controller.subtract(feet, inches, LengthUnit.FEET));
		System.out.printf("Subtract (duplicate): %s - %s -> %s%n", feet, inches,
				controller.subtract(feet, inches, LengthUnit.FEET));

		System.out.printf("Division     : %s / %s -> %.1f%n", feet, inches, controller.divide(feet, inches));

		// --------------- Weight ---------------
		System.out.println("\n--------------- Weight Measurement ----------------");

		Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
		Quantity<WeightUnit> gram = new Quantity<>(1000.0, WeightUnit.GRAM);
		System.out.println("\n[WEIGHT]");
		System.out.println("----------------------------------------------------");

		System.out.printf("Comparison   : %s == %s -> %s%n", kg, gram,
				controller.checkEquality(kg, gram) ? "TRUE" : "FALSE");

		System.out.printf("Conversion   : %s -> %s%n", kg, controller.convert(kg, WeightUnit.GRAM));

		System.out.printf("Add (New)    : %s + %s -> %s%n", kg, gram, controller.add(kg, gram, WeightUnit.KILOGRAM));
		System.out.printf("Add (duplicate): %s + %s -> %s%n", kg, gram, controller.add(kg, gram, WeightUnit.KILOGRAM));

		System.out.printf("Subtract (New) : %s - %s -> %s%n", kg, gram,
				controller.subtract(kg, gram, WeightUnit.KILOGRAM));
		System.out.printf("Subtract (duplicate): %s - %s -> %s%n", kg, gram,
				controller.subtract(kg, gram, WeightUnit.KILOGRAM));

		System.out.printf("Division     : %s / %s -> %.1f%n", kg, gram, controller.divide(kg, gram));

		// --------------- Volume --------------
		System.out.println("\n----------------- Volume Measurement ---------------");

		Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
		Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

		System.out.println("\n[VOLUME]");
		System.out.println("----------------------------------------------------");

		System.out.printf("Comparison   : %s == %s -> %s%n", litre, ml,
				controller.checkEquality(litre, ml) ? "TRUE" : "FALSE");

		System.out.printf("Conversion   : %s -> %s%n", litre, controller.convert(litre, VolumeUnit.MILLILITRE));

		System.out.printf("Add (New)     : %s + %s -> %s%n", litre, ml, controller.add(litre, ml, VolumeUnit.LITRE));

		System.out.printf("Add (duplicate): %s + %s -> %s%n", litre, ml, controller.add(litre, ml, VolumeUnit.LITRE));

		System.out.printf("Subtract (New)  : %s - %s -> %s%n", litre, ml,
				controller.subtract(litre, ml, VolumeUnit.LITRE));
		System.out.printf("Subtract (duplicate): %s - %s -> %s%n", litre, ml,
				controller.subtract(litre, ml, VolumeUnit.LITRE));

		System.out.printf("Division     : %s / %s -> %.1f%n", litre, ml, controller.divide(litre, ml));

		// -------------- Temperature --------------
		System.out.println("\n-------------- Temperature Measurement --------------");

		Quantity<TemperatureUnit> c = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
		Quantity<TemperatureUnit> f = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

		System.out.println("\n[TEMPERATURE]");
		System.out.println("------------------------------------------------------");

		System.out.printf("Comparison   : %s == %s -> %s%n", c, f, controller.checkEquality(c, f) ? "TRUE" : "FALSE");

		System.out.printf("Conversion   : %s -> %s%n", c, controller.convert(c, TemperatureUnit.FAHRENHEIT));

		try {
			controller.add(c, f);
		} catch (Exception e) {
			System.out.printf("Add (invalid) : %s + %s -> Not Allowed%n", c, f);
		}

		System.out.println("\n[HISTORY]");
		System.out.println("------------------------------------------------------");

		int i = 1;
		for (String h : controller.getHistory()) {
			System.out.println(i++ + ". " + h);
		}

	}
}