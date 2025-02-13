//package com.app.pojos;
//
//import java.util.List;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
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
//public class Admins {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long admin_id;
//	@NotBlank
//	@Column(nullable = false)
//	private String admin_name;
//	@NotBlank
//	@Column(nullable = false)
//	private String admin_password;
//	@NotBlank
//	@Column(nullable = false)
//	@Email
//	private String admin_email;
//	@NotBlank(message = "Contact number is required")
//    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
//	private String admin_contact_number;
//	
//	@OneToMany(mappedBy = "admins")
//	@JsonManagedReference
//	private List<Project> projects; // This should reference 'User' now instead of 'Admin'
//
//	
//}
