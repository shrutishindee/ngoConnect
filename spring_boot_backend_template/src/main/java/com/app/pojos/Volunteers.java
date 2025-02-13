//package com.app.pojos;
//import java.time.LocalDate;
//import java.util.Set;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
//import jakarta.persistence.Entity;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
//public class Volunteers {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long volunteer_id;
//	
//	@Column(nullable = false)
//	private LocalDate joined_date;
//	@Email
//	@Column(nullable = false, unique = true)
//	private String volunteer_email;
//	
//	@Enumerated(EnumType.STRING)
//	@Column(nullable = false)
//	private VolunteerAvailability volunteer_availability;
//	
//	@NotBlank(message = "Name is required")
//	@Size(min = 2, message = "Name should contain atleast 2 characters")
//	private String volunteer_name;
//	
//	@NotBlank(message = "Contact number is required")
//    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
//	private String contact_number;
//	
//	@Enumerated(EnumType.STRING)
//	@Column(nullable = false)
//	private VolunteerSkills skills;
//	
//	//Event --> Volunteers ManyToMany
//	@ManyToMany(mappedBy = "volunteers")
//	private Set<Event> events;
//	
//	
//	
//}
