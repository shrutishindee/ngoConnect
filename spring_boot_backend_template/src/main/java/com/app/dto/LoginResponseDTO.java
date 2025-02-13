package com.app.dto;

import com.app.pojos.UserRole;
import com.app.pojos.VolunteerAvailability;
import com.app.pojos.VolunteerSkills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class LoginResponseDTO {
	private Long id;
    private String name;
    private String email;
    private UserRole role;
    private VolunteerAvailability volunteerAvailability;
    private VolunteerSkills volunteerSkills;
    private String jwtToken;

}
