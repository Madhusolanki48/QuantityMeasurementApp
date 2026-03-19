package com.apps.quantitymeasurement.repository;
import com.apps.quantitymeasurement.entity.Quantity;
import java.util.Set;

public interface IQuantityMeasurementRepository {
	void save(Quantity<?> quantity);
	Set<Quantity<?>> findAll();
}