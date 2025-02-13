package com.app.pojos;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;  // User role (ADMIN, VOLUNTEER, DONOR)

//    @NotBlank(message = "Name is required")
    @Size(min = 2, message = "Name should contain at least 2 characters")
    private String name;

//    @Email
//    @Column(nullable = false, unique = true)
    private String email;

//    @NotBlank(message = "Contact number is required")
//    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    private String contactNumber;

    private LocalDate createdDate = LocalDate.now();  

    private String password;  

    // For volunteer-specific attributes
    private VolunteerAvailability volunteerAvailability;

    private VolunteerSkills volunteerSkills;
    
    // For donor-specific attributes
    private Double amountDonated;
    private LocalDate donationDate;

    @ManyToMany(mappedBy = "volunteers")  // Corrected mappedBy
    private Set<Event> events;

    
}
