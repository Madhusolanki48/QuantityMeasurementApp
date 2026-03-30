package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.dto.*;
import java.util.List;

public interface IQuantityMeasurementService {
	QuantityMeasurementDTO add(QuantityRequestDTO input);

	QuantityMeasurementDTO subtract(QuantityRequestDTO input);

	Double divide(QuantityRequestDTO input);

	QuantityMeasurementDTO convert(QuantityRequestDTO input);

	QuantityMeasurementDTO compare(QuantityRequestDTO input);

	List<?> getHistory();

	List<?> getByOperation(String operation);
}