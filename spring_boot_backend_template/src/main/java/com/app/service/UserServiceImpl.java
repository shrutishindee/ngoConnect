package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dto.LoginDTO;
import com.app.dto.RegisterDTO;
import com.app.pojos.User;
import com.app.pojos.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(RegisterDTO registrationDTO) {
        // Ensure the role is valid (no need to parse a string now, as it is already an enum)
        UserRole role = registrationDTO.getRole(); // This is now a UserRole enum

        // Create a new user and set fields
        User newUser = new User();
        newUser.setName(registrationDTO.getName());
        newUser.setEmail(registrationDTO.getEmail());
        
        // Hash the password before saving
        String encodedPassword = passwordEncoder.encode(registrationDTO.getPassword());
        newUser.setPassword(encodedPassword);

        newUser.setRole(role);

        // If the role is Volunteer, make skills and availability mandatory
        if (role == UserRole.ROLE_VOLUNTEER) {
            if (registrationDTO.getVolunteerAvailability() == null) {
                throw new RuntimeException("Volunteer Availability is required for Volunteer role.");
            }
            newUser.setVolunteerAvailability(registrationDTO.getVolunteerAvailability());

            if (registrationDTO.getVolunteerSkills() == null) {
                throw new RuntimeException("At least one volunteer Skill is required");
            }
            newUser.setVolunteerSkills(registrationDTO.getVolunteerSkills());
        }

        return userDao.save(newUser);
    }

    //  Login user (Role is determined dynamically)
    @Override
    public User loginUser(LoginDTO loginDTO) {
        Optional<User> userOpt = userDao.findByEmail(loginDTO.getEmail());
        if (userOpt.isEmpty() || !passwordEncoder.matches(loginDTO.getPassword(), userOpt.get().getPassword())) {
            throw new RuntimeException("Invalid email or password.");
        }

        return userOpt.get(); // ✅ Return the logged-in user with role
    }

    // Get all users
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    // Get user by ID
    @Override
    public Optional<User> getUserById(Long id) {
        return userDao.findById(id);
    }

    // Delete user
    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
    
    
    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }
}
