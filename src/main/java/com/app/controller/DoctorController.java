package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.DoctorRepository;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Doctor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/doctors")
//@PreAuthorize("hasRole('ADMIN')")
public class DoctorController {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@GetMapping
	public List<Doctor> getAllDoctor(){
		return doctorRepository.findAll();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable long id){
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Doctor not exist with id: "+id));
		return ResponseEntity.ok(doctor);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable long id, @RequestBody Doctor doctorDetails){
		Doctor updateDoctor=doctorRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Doctor not exist with id "+id));
	
		updateDoctor.setFirstName(doctorDetails.getFirstName());
		updateDoctor.setLastName(doctorDetails.getLastName());
		updateDoctor.setEmail(doctorDetails.getEmail());
		updateDoctor.setQualification(doctorDetails.getQualification());
		
		doctorRepository.save(updateDoctor);
		return ResponseEntity.ok(updateDoctor);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable long id){
		Doctor doctor=doctorRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Doctor not exist with id "+id));
		
		doctorRepository.delete(doctor);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
