package com.apps.quantitymeasurement.measurement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apps.quantitymeasurement.common.dto.ConversionHistoryRequest;
import com.apps.quantitymeasurement.common.dto.QuantityMeasurementDTO;
import com.apps.quantitymeasurement.common.dto.QuantityRequestDTO;
import com.apps.quantitymeasurement.common.model.Quantity;
import com.apps.quantitymeasurement.common.util.QuantityConverter;
import com.apps.quantitymeasurement.measurement.client.UserServiceClient;
import com.apps.quantitymeasurement.measurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.measurement.repository.QuantityMeasurementRepository;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

	private final QuantityMeasurementRepository repository;
	private final UserServiceClient userServiceClient;

	public QuantityMeasurementServiceImpl(QuantityMeasurementRepository repository, UserServiceClient userServiceClient) {
		this.repository = repository;
		this.userServiceClient = userServiceClient;
	}

	@Override
	public QuantityMeasurementDTO add(QuantityRequestDTO input) {
		try {
			Quantity q1 = (Quantity) QuantityConverter.toEntity(input.getFirst());
			Quantity q2 = (Quantity) QuantityConverter.toEntity(input.getSecond());

			Quantity result = q1.add(q2, q1.getUnit());
			repository.save(new QuantityMeasurementEntity("ADD", q1.getValue(), q2.getValue(), result.getValue()));
			saveUserHistory(input, "ADD", q1, q2, result.getValue(), false, null);
			return QuantityMeasurementDTO.success("ADD", result.getValue());
		} catch (Exception e) {
			repository.save(new QuantityMeasurementEntity("ADD", e.getMessage()));
			saveUserHistoryFromDtos(input, "ADD", null, true, e.getMessage());
			return QuantityMeasurementDTO.failure("ADD", e.getMessage());
		}
	}

	@Override
	public QuantityMeasurementDTO subtract(QuantityRequestDTO input) {
		try {
			Quantity q1 = (Quantity) QuantityConverter.toEntity(input.getFirst());
			Quantity q2 = (Quantity) QuantityConverter.toEntity(input.getSecond());

			Quantity result = q1.subtract(q2, q1.getUnit());
			repository.save(new QuantityMeasurementEntity("SUBTRACT", q1.getValue(), q2.getValue(), result.getValue()));
			saveUserHistory(input, "SUBTRACT", q1, q2, result.getValue(), false, null);
			return QuantityMeasurementDTO.success("SUBTRACT", result.getValue());
		} catch (Exception e) {
			saveUserHistoryFromDtos(input, "SUBTRACT", null, true, e.getMessage());
			return QuantityMeasurementDTO.failure("SUBTRACT", e.getMessage());
		}
	}

	@Override
	public Double divide(QuantityRequestDTO input) {
		Quantity q1 = (Quantity) QuantityConverter.toEntity(input.getFirst());
		Quantity q2 = (Quantity) QuantityConverter.toEntity(input.getSecond());
		double result = q1.divide(q2);
		saveUserHistory(input, "DIVIDE", q1, q2, result, false, null);
		return result;
	}

	@Override
	public QuantityMeasurementDTO convert(QuantityRequestDTO input) {
		Quantity q1 = (Quantity) QuantityConverter.toEntity(input.getFirst());
		Quantity q2 = (Quantity) QuantityConverter.toEntity(input.getSecond());

		Quantity result = q1.convertTo(q2.getUnit());
		saveUserHistory(input, "CONVERT", q1, q2, result.getValue(), false, null);
		return QuantityMeasurementDTO.success("CONVERT", result.getValue());
	}

	@Override
	public QuantityMeasurementDTO compare(QuantityRequestDTO input) {
		Quantity q1 = (Quantity) QuantityConverter.toEntity(input.getFirst());
		Quantity q2 = (Quantity) QuantityConverter.toEntity(input.getSecond());
		boolean equal = q1.equals(q2);
		saveUserHistory(input, "COMPARE", q1, q2, equal ? 1.0 : 0.0, false, null);
		return QuantityMeasurementDTO.success("COMPARE", equal ? 1.0 : 0.0);
	}

	@Override
	public List<?> getHistory() {
		return repository.findAll();
	}

	@Override
	public List<?> getByOperation(String operation) {
		return repository.findByOperation(operation);
	}

	private void saveUserHistory(QuantityRequestDTO request, String operation, Quantity first, Quantity second,
			Double result, boolean error, String errorMessage) {
		if (request == null || request.getUserId() == null) {
			return;
		}

		ConversionHistoryRequest historyRequest = new ConversionHistoryRequest();
		historyRequest.setUserId(request.getUserId());
		historyRequest.setOperation(operation);
		historyRequest.setMeasurementType(first.getUnit().getClass().getSimpleName());
		historyRequest.setFirstValue(first.getValue());
		historyRequest.setFirstUnit(first.getUnit().getUnitName());
		historyRequest.setSecondValue(second != null ? second.getValue() : null);
		historyRequest.setSecondUnit(second != null ? second.getUnit().getUnitName() : null);
		historyRequest.setResult(result);
		historyRequest.setError(error);
		historyRequest.setErrorMessage(errorMessage);
		historyRequest.setTimestamp(LocalDateTime.now());

		try {
			userServiceClient.saveHistory(request.getUserId(), historyRequest);
		} catch (Exception ignored) {
			// history is best-effort; conversion should still succeed
		}
	}

	private void saveUserHistoryFromDtos(QuantityRequestDTO request, String operation, Double result, boolean error,
			String errorMessage) {
		if (request == null || request.getUserId() == null || request.getFirst() == null) {
			return;
		}

		ConversionHistoryRequest historyRequest = new ConversionHistoryRequest();
		historyRequest.setUserId(request.getUserId());
		historyRequest.setOperation(operation);
		historyRequest.setMeasurementType(request.getFirst().getMeasurementType());
		historyRequest.setFirstValue(request.getFirst().getValue());
		historyRequest.setFirstUnit(request.getFirst().getUnit());
		if (request.getSecond() != null) {
			historyRequest.setSecondValue(request.getSecond().getValue());
			historyRequest.setSecondUnit(request.getSecond().getUnit());
		}
		historyRequest.setResult(result);
		historyRequest.setError(error);
		historyRequest.setErrorMessage(errorMessage);
		historyRequest.setTimestamp(LocalDateTime.now());

		try {
			userServiceClient.saveHistory(request.getUserId(), historyRequest);
		} catch (Exception ignored) {
		}
	}
}
