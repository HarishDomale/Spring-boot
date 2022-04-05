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

import com.app.dao.VaccineRepository;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Hospitals;
import com.app.pojos.Vaccines;
@CrossOrigin("*")
@RestController
@RequestMapping("/vaccine")
//@PreAuthorize("hasRole('ADMIN')")
public class VaccineController {
@Autowired
private VaccineRepository vaccineRepository;

@GetMapping
public List<Vaccines> getAllVaccines()
{
	return vaccineRepository.findAll();
}

@PostMapping
public Vaccines createHospital(@RequestBody Vaccines vaccine)
{
	return vaccineRepository.save(vaccine);
}

@GetMapping("{id}")
public ResponseEntity<Vaccines> getVaccineById(@PathVariable long id)
{
Vaccines vaccine=vaccineRepository.findById(id).
		orElseThrow(() -> new ResourceNotFoundException("Vaccine not exist with id :"+id));
return ResponseEntity.ok(vaccine);
}

@PutMapping("{id}")
public ResponseEntity<Vaccines> updateVaccine(@PathVariable long id,@RequestBody Vaccines vaccineDetails)
{
	Vaccines updateVaccine=vaccineRepository.findById(id).
			orElseThrow(() -> new ResourceNotFoundException("Vaccine not exist with id : "+id));
	
	updateVaccine.setVaccineName(vaccineDetails.getVaccineName());
	updateVaccine.setDescription(vaccineDetails.getDescription());
	updateVaccine.setRoute(vaccineDetails.getRoute());
	updateVaccine.setSite(vaccineDetails.getSite());
	updateVaccine.setWhenToGive(vaccineDetails.getWhenToGive());
	updateVaccine.setMaxAge(vaccineDetails.getMaxAge());
	updateVaccine.setDose(vaccineDetails.getDose());
	updateVaccine.setStock(vaccineDetails.getStock());
	vaccineRepository.save(updateVaccine);
	return ResponseEntity.ok(updateVaccine);
}

//delete method 
@DeleteMapping("{id}")
public ResponseEntity<HttpStatus> deleteVaccine(@PathVariable long id){
	Vaccines vaccine=vaccineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vaccine not exist with id : "+id) );
	vaccineRepository.delete(vaccine);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
	
}
