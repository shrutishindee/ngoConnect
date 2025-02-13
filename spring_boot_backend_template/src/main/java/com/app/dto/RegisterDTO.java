package com.app.dto;


import com.app.pojos.UserRole;
import com.app.pojos.VolunteerAvailability;
import com.app.pojos.VolunteerSkills;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RegisterDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    private String password;

    private String contactNumber;
    
    @NotNull(message = "Role is required")
    private UserRole role;

    private VolunteerAvailability volunteerAvailability;
    
    private VolunteerSkills volunteerSkills;

}