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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BookingRepository;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Booking;

@CrossOrigin("*")
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@GetMapping
	public List<Booking> getAllBooking(){
		return bookingRepository.findAll();
	}
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping
	public Booking createBooking(@RequestBody Booking booking) {
		return bookingRepository.save(booking);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable long id){
		Booking booking= bookingRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Booking not exist with id "+id));
		return ResponseEntity.ok(booking);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteBookingById(@PathVariable long id){
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Booking not exist with id "+id));
		bookingRepository.delete(booking);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
