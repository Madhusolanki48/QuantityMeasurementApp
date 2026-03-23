package com.apps.quantitymeasurement.controller;

import java.util.*;
import com.apps.quantitymeasurement.entity.Quantity;
import com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;
import com.apps.quantitymeasurement.units.IMeasurable;

public class QuantityMeasurementController {
	private final IQuantityMeasurementService service;
	private final IQuantityMeasurementRepository  repository;

	public QuantityMeasurementController(IQuantityMeasurementService service,
			IQuantityMeasurementRepository  repository) {
		this.service = service;
		this.repository = repository;
	}

	public boolean checkEquality(Quantity<?> q1, Quantity<?> q2) {
		return q1.equals(q2);
	}

	public <U extends IMeasurable> Quantity<U> convert(Quantity<U> quantity, U targetUnit) {
		return quantity.convertTo(targetUnit);
	}

	public <U extends IMeasurable> Quantity<U> add(Quantity<U> q1, Quantity<U> q2) {
		return service.add(q1, q2);
	}

	public <U extends IMeasurable> Quantity<U> add(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
		Quantity<U> result = service.add(q1, q2);
		return result.convertTo(targetUnit);
	}

	public <U extends IMeasurable> Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2) {
		return service.subtract(q1, q2);
	}

	public <U extends IMeasurable> Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
		Quantity<U> result = service.subtract(q1, q2);
		return result.convertTo(targetUnit);
	}

	public <U extends IMeasurable> double divide(Quantity<U> q1, Quantity<U> q2) {
		return service.divide(q1, q2);
	}

	public java.util.List<String> getHistory() {
	    return repository.findAllHistory();
	}
}