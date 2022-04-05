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
import com.app.dao.HospitalRepository;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Hospitals;

@CrossOrigin("*")
@RestController
@RequestMapping("/hospital")
@PreAuthorize("hasRole('ADMIN')")
public class HospitalController {

	@Autowired
	private HospitalRepository hospitalRepository;
	
//	Get all hospitals Rest API
	@GetMapping
	public List<Hospitals> getAllHospitals()
	{
		return hospitalRepository.findAll();
	}
	
//	Add new hospital Rest API
	@PostMapping
	public Hospitals createHospital(@RequestBody Hospitals hospital) 
	{
		return hospitalRepository.save(hospital);
	}
		
//	Get hospital by ID Rest API
	@GetMapping("{id}")
	public ResponseEntity<Hospitals> getHospitalById(@PathVariable long id)
	{
		Hospitals hospital=hospitalRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Hospital not exist with id :"+id));
		return ResponseEntity.ok(hospital);
	}
		
//	Update hospital Rest API
	@PutMapping("{id}")
	public ResponseEntity<Hospitals> updateHospital(@PathVariable long id, @RequestBody Hospitals hospitalDetails)
	{
		Hospitals updateHospital=hospitalRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Hospital not exist with id : "+id));
			
		updateHospital.setHospitalName(hospitalDetails.getHospitalName());
		updateHospital.setUserName(hospitalDetails.getUserName());
		updateHospital.setEmail(hospitalDetails.getEmail());
		updateHospital.setPhone(hospitalDetails.getPhone());
		updateHospital.setAddress(hospitalDetails.getAddress());
		updateHospital.setWebsite(hospitalDetails.getWebsite());
			
		hospitalRepository.save(updateHospital);
		return ResponseEntity.ok(updateHospital);
	}
		
//  delete method 
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteHospital(@PathVariable long id){
		Hospitals hospital=hospitalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital not exist with id : "+id) );
		hospitalRepository.delete(hospital);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
