package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Vaccines;

public interface VaccineRepository extends JpaRepository<Vaccines, Long> {
//all crud methods
}
