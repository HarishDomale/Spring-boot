package com.app.pojos;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="booking")
public class Booking extends BaseEntity{

	private String firstName;
	private String lastName;
	private String email;
	private LocalDate date;
	private String time;
	private String vaccineName;
	private String hospitalName;
	
	
	
	
	
}
