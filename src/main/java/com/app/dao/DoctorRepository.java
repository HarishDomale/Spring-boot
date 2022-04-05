package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
}
