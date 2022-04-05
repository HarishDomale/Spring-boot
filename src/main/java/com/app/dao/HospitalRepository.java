package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Hospitals;
public interface HospitalRepository extends JpaRepository<Hospitals, Long>{

	
}
