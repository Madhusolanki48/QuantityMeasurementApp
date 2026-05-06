package com.apps.quantitymeasurement.user.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apps.quantitymeasurement.common.dto.ConversionHistoryRequest;
import com.apps.quantitymeasurement.common.dto.ConversionHistoryResponse;
import com.apps.quantitymeasurement.user.entity.ConversionHistory;
import com.apps.quantitymeasurement.user.entity.User;
import com.apps.quantitymeasurement.user.repository.ConversionHistoryRepository;
import com.apps.quantitymeasurement.user.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final ConversionHistoryRepository historyRepository;

	public UserService(UserRepository userRepository, ConversionHistoryRepository historyRepository) {
		this.userRepository = userRepository;
		this.historyRepository = historyRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
	}

	public ConversionHistoryResponse saveHistory(Long userId, ConversionHistoryRequest request) {
		ConversionHistory history = new ConversionHistory();
		history.setUserId(userId);
		history.setOperation(request.getOperation());
		history.setMeasurementType(request.getMeasurementType());
		history.setFirstValue(request.getFirstValue());
		history.setFirstUnit(request.getFirstUnit());
		history.setSecondValue(request.getSecondValue());
		history.setSecondUnit(request.getSecondUnit());
		history.setResult(request.getResult());
		history.setError(request.isError());
		history.setErrorMessage(request.getErrorMessage());
		history.setTimestamp(request.getTimestamp() != null ? request.getTimestamp() : LocalDateTime.now());

		ConversionHistory saved = historyRepository.save(history);
		return toResponse(saved);
	}

	public List<ConversionHistoryResponse> getHistory(Long userId) {
		return historyRepository.findByUserIdOrderByTimestampDesc(userId)
				.stream()
				.map(this::toResponse)
				.toList();
	}

	public void deleteHistoryItem(Long userId, Long historyId) {
		ConversionHistory history = historyRepository.findById(historyId)
				.orElseThrow(() -> new IllegalArgumentException("History not found: " + historyId));

		if (!history.getUserId().equals(userId)) {
			throw new IllegalArgumentException("History does not belong to user: " + userId);
		}

		historyRepository.delete(history);
	}

	public void deleteAllHistory(Long userId) {
		historyRepository.deleteByUserId(userId);
	}

	private ConversionHistoryResponse toResponse(ConversionHistory history) {
		ConversionHistoryResponse response = new ConversionHistoryResponse();
		response.setId(history.getId());
		response.setUserId(history.getUserId());
		response.setOperation(history.getOperation());
		response.setMeasurementType(history.getMeasurementType());
		response.setFirstValue(history.getFirstValue());
		response.setFirstUnit(history.getFirstUnit());
		response.setSecondValue(history.getSecondValue());
		response.setSecondUnit(history.getSecondUnit());
		response.setResult(history.getResult());
		response.setError(history.isError());
		response.setErrorMessage(history.getErrorMessage());
		response.setTimestamp(history.getTimestamp());
		return response;
	}
}
