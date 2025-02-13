package com.app.dto;


import java.time.LocalDate;

import com.app.pojos.Project;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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




public class EventDTO {
	
	
	
		private Long eventId;
		
		@NotBlank(message = "Event Location required")
		private String eventLocation;
		
		@NotBlank(message = "Event Name required")
		private String eventName;
		
		private String eventDescription;
		
		@NotNull(message = "Event Date required")
		private LocalDate eventDate;
		
		@NotNull
		private int volunteersNeeded;
		
		@JsonProperty(access = Access.AUTO)
		private Long projectId;
		
		
	}



