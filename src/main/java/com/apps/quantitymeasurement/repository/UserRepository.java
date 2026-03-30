package com.apps.quantitymeasurement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apps.quantitymeasurement.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}