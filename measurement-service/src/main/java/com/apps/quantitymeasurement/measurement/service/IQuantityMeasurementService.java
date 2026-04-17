package com.apps.quantitymeasurement.measurement.service;

import java.util.List;

import com.apps.quantitymeasurement.common.dto.QuantityMeasurementDTO;
import com.apps.quantitymeasurement.common.dto.QuantityRequestDTO;

public interface IQuantityMeasurementService {

	QuantityMeasurementDTO add(QuantityRequestDTO input);

	QuantityMeasurementDTO subtract(QuantityRequestDTO input);

	Double divide(QuantityRequestDTO input);

	QuantityMeasurementDTO convert(QuantityRequestDTO input);

	QuantityMeasurementDTO compare(QuantityRequestDTO input);

	List<?> getHistory();

	List<?> getByOperation(String operation);
}
