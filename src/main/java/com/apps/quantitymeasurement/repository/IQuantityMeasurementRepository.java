package com.apps.quantitymeasurement.repository;
import com.apps.quantitymeasurement.entity.Quantity;

import java.util.List;
import java.util.Set;

public interface IQuantityMeasurementRepository {
	void save(String type, String operation, double value1, String unit1, double value2, String unit2, double result,
			String resultUnit);
	Set<Quantity<?>> findAll();
	List<String> findAllHistory();
	
}