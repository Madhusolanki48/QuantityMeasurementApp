package com.apps.quantitymeasurement.measurement.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.apps.quantitymeasurement.common.dto.ConversionHistoryRequest;
import com.apps.quantitymeasurement.common.dto.ConversionHistoryResponse;

@FeignClient(name = "user-service")
public interface UserServiceClient {

	@PostMapping("/api/v1/users/{userId}/history")
	ConversionHistoryResponse saveHistory(@PathVariable("userId") Long userId, @RequestBody ConversionHistoryRequest request);

	@GetMapping("/api/v1/users/{userId}/history")
	List<ConversionHistoryResponse> getHistory(@PathVariable("userId") Long userId);
}
