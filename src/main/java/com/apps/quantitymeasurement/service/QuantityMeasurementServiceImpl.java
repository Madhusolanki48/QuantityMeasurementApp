package com.apps.quantitymeasurement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.quantitymeasurement.dto.*;
import com.apps.quantitymeasurement.entity.Quantity;
import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.repository.QuantityMeasurementRepository;
import com.apps.quantitymeasurement.utils.QuantityConverter;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {
	@Autowired
	private QuantityMeasurementRepository repository;

	@Override
	public QuantityMeasurementDTO add(QuantityRequestDTO input) {
		try {
			Quantity q1 = QuantityConverter.toEntity(input.getFirst());
			Quantity q2 = QuantityConverter.toEntity(input.getSecond());

			Quantity result = q1.add(q2, q1.getUnit());

			repository.save(new QuantityMeasurementEntity("ADD", q1.getValue(), q2.getValue(), result.getValue()));

			return QuantityMeasurementDTO.success("ADD", result.getValue());

		} catch (Exception e) {
			repository.save(new QuantityMeasurementEntity("ADD", e.getMessage()));
			return QuantityMeasurementDTO.failure("ADD", e.getMessage());
		}
	}

	@Override
	public QuantityMeasurementDTO subtract(QuantityRequestDTO input) {
		try {
			Quantity q1 = QuantityConverter.toEntity(input.getFirst());
			Quantity q2 = QuantityConverter.toEntity(input.getSecond());

			Quantity result = q1.subtract(q2, q1.getUnit());

			repository.save(new QuantityMeasurementEntity("SUBTRACT", q1.getValue(), q2.getValue(), result.getValue()));

			return QuantityMeasurementDTO.success("SUBTRACT", result.getValue());

		} catch (Exception e) {
			return QuantityMeasurementDTO.failure("SUBTRACT", e.getMessage());
		}
	}

	@Override
	public Double divide(QuantityRequestDTO input) {
		Quantity q1 = QuantityConverter.toEntity(input.getFirst());
		Quantity q2 = QuantityConverter.toEntity(input.getSecond());
		return q1.divide(q2);
	}

	@Override
	public QuantityMeasurementDTO convert(QuantityRequestDTO input) {
		Quantity q1 = QuantityConverter.toEntity(input.getFirst());
		Quantity q2 = QuantityConverter.toEntity(input.getSecond());

		Quantity result = q1.convertTo(q2.getUnit());

		return QuantityMeasurementDTO.success("CONVERT", result.getValue());
	}

	@Override
	public QuantityMeasurementDTO compare(QuantityRequestDTO input) {
		Quantity q1 = QuantityConverter.toEntity(input.getFirst());
		Quantity q2 = QuantityConverter.toEntity(input.getSecond());

		boolean equal = q1.equals(q2);

		return QuantityMeasurementDTO.success("COMPARE", equal ? 1.0 : 0.0);
	}

	@Override
	public java.util.List<?> getHistory() {
		return repository.findAll();
	}

	@Override
	public java.util.List<?> getByOperation(String operation) {
		return repository.findByOperation(operation);
	}
}