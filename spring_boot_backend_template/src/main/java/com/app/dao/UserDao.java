package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;
import com.app.pojos.UserRole;

public interface UserDao extends JpaRepository<User, Long> {
	 Optional<User> findByEmail(String email);
	 Optional<User> findByEmailAndRole(String email, UserRole role);
	 Optional<User> findById(Long id);
}
