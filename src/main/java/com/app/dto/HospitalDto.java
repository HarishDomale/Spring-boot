package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class HospitalDto {

//	@Column(name="hospital_name",nullable = false )//nullable=not null
	@NotEmpty(message="please provide Hospital Name")
	private String hospitalName;
	
//	@Column(name="user_name",nullable = false )
	@NotEmpty(message="please provide User Name")
	private String userName;
	
	//@Column(name="email",nullable = false )
	@NotEmpty(message="please provide Email-ID")
	private String email;
	
	//@Column(name="phone",nullable = false )
	@NotEmpty(message="please provide Phone Number")
	private String phone;
	
//	@Column(name="user_name") if @column is not specified then automatically takes var name as col name
	private String website;//so here col name will be website
	
	//@Column(name="address",nullable = false )
	@NotEmpty(message="please provide Address")
	private String address;
	
	private long userId;
}
