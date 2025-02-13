package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDTO;
import com.app.dto.LoginResponseDTO;
import com.app.dto.RegisterDTO;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.security.CustomUserDetails;
import com.app.security.JwtUtils;
import com.app.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authMgr;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    
	// Single Register Endpoint (For all roles: Admin, Donor, Hospital)
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid RegisterDTO registrationDTO) {
        // Convert the role from string to UserRole enum
        UserRole role;
        try {
        	role = registrationDTO.getRole();  // if registrationDTO.getRole() is already of type UserRole
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
        registrationDTO.setRole(role);
        User user = userService.registerUser(registrationDTO);
        return ResponseEntity.ok(user);
    }


    // Login Endpoint (Authenticate and generate JWT token)
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginDTO request) {

        // 1. Create a token with email and password
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        // 2. Authenticate using AuthenticationManager
        Authentication verifiedToken = authMgr.authenticate(token);

        // 3. If authentication is successful, generate JWT token
        String jwt = jwtUtils.generateJwtToken(verifiedToken);

        // 4. Retrieve logged-in user details
        CustomUserDetails userDetails = (CustomUserDetails) verifiedToken.getPrincipal();
        User user = userDetails.getUser();

        // Prepare the response DTO
        LoginResponseDTO responseDTO = new LoginResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getVolunteerAvailability(),
                user.getVolunteerSkills(),
                jwt
        );

        // Return the response with the JWT token
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    // Get all users (Only Admin can do this)
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by ID (For Admin to manage a specific user)
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete user (Only Admin can delete users)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
