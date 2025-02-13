package com.app.dto;




import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class BeneficiaryDto {
		private Long beneficiaryId;
		@NotBlank
		private String beneficiaryName;
		@NotBlank
		@Email
		private String beneficiaryEmail;
		@NotBlank
		private String beneficiaryAddress;
		@NotBlank
		private String projectAssociated;
		@JsonProperty(access = Access.AUTO)
		private Long eventId;
}



