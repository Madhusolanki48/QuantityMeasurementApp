package com.apps.quantitymeasurement.measurement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps.quantitymeasurement.measurement.entity.QuantityMeasurementEntity;

@Repository
public interface QuantityMeasurementRepository extends JpaRepository<QuantityMeasurementEntity, Long> {

	List<QuantityMeasurementEntity> findByOperation(String operation);
}
