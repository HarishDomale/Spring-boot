package com.app.pojos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vaccine")
public class Vaccines extends BaseEntity{
	
	
	@Column(name="vaccine_name",nullable = false )//nullable=not null
	@NotEmpty(message="please provide Vaccine Name")
	private String vaccineName;
	
	@Column(name="description",nullable = false )
	@NotEmpty(message="please provide Description")
	private String description;
	
	@Column(name="route",nullable = false )
	@NotEmpty(message="please provide Route")
	private String route;
	
	@Column(name="site" )
	@NotEmpty(message="please provide Site")
	private String site;
	
	@Column(name="when_to_give",nullable = false )
	@NotEmpty(message="please provide When To Give")
	private String whenToGive;
	
	@Column(name="max_age",nullable = false )
	@NotEmpty(message="please provide Max Age")
	private String maxAge;
	
	@Column(name="dose",nullable = false )
	@NotEmpty(message="please provide Dose")
	private String dose;
	
	@Column(name="stock" )
	private int stock;
}
