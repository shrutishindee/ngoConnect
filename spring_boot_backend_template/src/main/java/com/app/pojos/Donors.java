//package com.app.pojos;
//
//import java.time.LocalDate;
//import java.util.Set;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
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
//public class Donors {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long donor_id;
//	
//	@NotBlank
//	@Column(nullable = false)
//	private String name;
//	@Column(nullable = false)
//	@Email
//	private String email;
//	@Column(nullable = false)
//	private Double amount_donated;
//	@Column(nullable = false)
//	private LocalDate donation_date;
//	@Column(nullable = false)
//	@NotBlank(message = "Contact number is required")
//    @Pattern(regexp = "\\d{10}",  message = "Contact number must be 10 digits")
//	private String contact_number;	
//	
//	// Project --> Donor many to many
//	@ManyToMany(mappedBy = "donors")
//	private Set<Project> projects;
//	
//}
