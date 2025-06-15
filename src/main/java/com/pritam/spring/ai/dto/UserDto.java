package com.pritam.spring.ai.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDto {

	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private Date dateOfBirth;
	private Long userTypeId;
	
}
