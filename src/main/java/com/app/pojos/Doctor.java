package com.app.pojos;

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
@Table(name="doctors")
public class Doctor extends BaseEntity{
	
	@Column(name="first_name")
	@NotEmpty(message="please provide first name")
	private String firstName;
	@Column(name="last_name")
	@NotEmpty(message="please provide Last name")
	private String lastName;
	@NotEmpty(message="please provide email")
	private String email;
	@NotEmpty(message="please provide qualification")
	private String qualification;
}
