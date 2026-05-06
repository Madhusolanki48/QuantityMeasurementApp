package com.apps.quantitymeasurement.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apps.quantitymeasurement.user.entity.ConversionHistory;

public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, Long> {

	List<ConversionHistory> findByUserIdOrderByTimestampDesc(Long userId);

	void deleteByUserId(Long userId);
}
