package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseDto {
	private String mesg;
	private LocalDateTime updatedOn;
	public ApiResponseDto(String mesg) 
	{
		
		this.mesg = mesg;
		this.updatedOn = LocalDateTime.now();
	}

}
