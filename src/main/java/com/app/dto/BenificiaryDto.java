package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class BenificiaryDto {

	@NotEmpty(message="please provide first name")
	private String firstName;
	@NotEmpty(message="please provide middle name")
	private String middleName;
	@NotEmpty(message="please provide last name")
	private String lastName;
	@NotEmpty(message="please provide mother name")
	private String motherName;
	
	private LocalDate dob;
	@NotEmpty(message="please provide address")
	private String address;
	
	private long mobNo;
	@NotEmpty(message="please provide BLood Group")
	private String blood;
	
	private float weight;
	

	private String gender;
	
	private long userId;
}
