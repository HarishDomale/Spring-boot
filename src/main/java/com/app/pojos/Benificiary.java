package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="benificiary")
public class Benificiary extends BaseEntity{
	
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
	@NotEmpty(message="please provide gender")
	private String gender;
	
	@Column(name="users_id",unique = true)
	private long usersId;
}
