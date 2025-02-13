package com.app.dto;


import java.time.LocalDate;

import com.app.pojos.Project_Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

//import jakarta.persistence.Access;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProjectDTO {
	

	
	private Long projectId;
	
	@NotBlank
	
	private String projectDescription;
	
	@NotBlank
	
	private String projectName;
	
	@Enumerated(EnumType.STRING)
	
	private Project_Status projectStatus;
	
	
	private LocalDate startDate;
	
	
	private LocalDate endDate;
	@JsonProperty(access = Access.AUTO)
	private Long adminId;
	
	
	
	
	

	
	
	

}



