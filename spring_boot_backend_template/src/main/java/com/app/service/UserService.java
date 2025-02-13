package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.LoginDTO;
import com.app.dto.RegisterDTO;
import com.app.pojos.User;

public interface UserService {

	List<User> getAllUsers();

	Optional<User> getUserById(Long id);

	void deleteUser(Long id);

	User getUserByEmail(String email);

	User registerUser(RegisterDTO registrationDTO);

	User loginUser(LoginDTO loginDTO);

}
