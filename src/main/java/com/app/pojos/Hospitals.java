package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hospital")
public class Hospitals extends BaseEntity{
	
	
	@Column(name="hospital_name",nullable = false )//nullable=not null
	@NotEmpty(message="please provide Hospital Name")
	private String hospitalName;
	
	@Column(name="user_name",nullable = false )
	@NotEmpty(message="please provide User Name")
	private String userName;
	
	@Column(name="email",nullable = false )
	@NotEmpty(message="please provide Email-ID")
	private String email;
	
	@Column(name="phone",nullable = false )
	@NotEmpty(message="please provide Phone Number")
	private String phone;
	
//	@Column(name="user_name") if @column is not specified then automatically takes var name as col name
	private String website;//so here col name will be website
	
	@Column(name="address",nullable = false )
	@NotEmpty(message="please provide Address")
	private String address;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
}
