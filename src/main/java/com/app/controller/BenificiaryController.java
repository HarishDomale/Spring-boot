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

import com.app.dao.BenificiaryRepository;
import com.app.dao.UserRepository;
import com.app.dto.BenificiaryDto;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Benificiary;
import com.app.pojos.User;

@CrossOrigin("*")
@RestController
@RequestMapping("/benificiary")
//@PreAuthorize("hasRole('ADMIN')")
public class BenificiaryController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BenificiaryRepository benificiaryRepository;
	
	@GetMapping
	public List<Benificiary> getAllBenificiary(){
		return benificiaryRepository.findAll();
	}
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping
	public Benificiary createBenificiary(@RequestBody BenificiaryDto benificiary) {
		System.out.println("benificiary "+benificiary.getUserId());
		User u=userRepository.findById(benificiary.getUserId())
				.orElseThrow(()-> new RuntimeException());
		
				
				u.getRoles();
		Benificiary benif=new Benificiary(
				benificiary.getFirstName(),
				benificiary.getMiddleName(),
				benificiary.getLastName(),
				benificiary.getMotherName(),
				benificiary.getDob(),
				benificiary.getAddress(),
				benificiary.getMobNo(),
				benificiary.getBlood(),
				benificiary.getWeight(),
				benificiary.getGender(),u
				);
		
		return benificiaryRepository.save(benif);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Benificiary> getBenificiaryById(@PathVariable long id){
		Benificiary benificiary=benificiaryRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Benificiary not exist with id "+id));
		return ResponseEntity.ok(benificiary);
	}
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping("{id}")
	public ResponseEntity<Benificiary> updateBenificiary(@PathVariable long id,@RequestBody Benificiary benificiary){
	Benificiary updateBenificiary = benificiaryRepository.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Benificiary not exist with id "+id));
	updateBenificiary.setFirstName(benificiary.getFirstName());
	updateBenificiary.setMiddleName(benificiary.getMiddleName());
	updateBenificiary.setLastName(benificiary.getLastName());
	updateBenificiary.setMotherName(benificiary.getMotherName());
	updateBenificiary.setDob(benificiary.getDob());
	updateBenificiary.setAddress(benificiary.getAddress());
	updateBenificiary.setMobNo(benificiary.getMobNo());
	updateBenificiary.setBlood(benificiary.getBlood());
	updateBenificiary.setWeight(benificiary.getWeight());
	updateBenificiary.setGender(benificiary.getGender());
	
	
	benificiaryRepository.save(updateBenificiary);
	return ResponseEntity.ok(updateBenificiary);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteBeneficiary(@PathVariable long id){
		Benificiary benificiary= benificiaryRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Benificiary not exist with id "+id));
		benificiaryRepository.delete(benificiary);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/count")
	public long getCount() {
		return benificiaryRepository.count();
	}
}
