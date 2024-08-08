package com.mitocode.controller;


import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.model.Patient;
import com.mitocode.service.IPatientService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

 
	private final IPatientService service;
	
	@GetMapping("")
	public ResponseEntity<List<Patient>> findAll(){
		List<Patient> list=  service.findAll();
		return new ResponseEntity<> (list,HttpStatus.OK) ;
	}
	 
	@GetMapping("/{id}")
	public ResponseEntity<Patient> findById(@PathVariable Integer id){
		Patient obj = service.findById(id);
		
		return new ResponseEntity<> (obj,HttpStatus.OK) ;
	}
	
	@PostMapping("")
	public ResponseEntity<Patient> save(@RequestBody Patient patient) {
		Patient obj = service.save(patient);
		  URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient()).toUri();

		  return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Patient>  update(@PathVariable Integer id,@RequestBody Patient patient) {
		patient.setIdPatient(id);
		Patient obj= service.save(patient);
		return new ResponseEntity<> (obj,HttpStatus.OK) ;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
	 
		service.delete(id);
		return ResponseEntity.noContent().build() ;
		
	}
}
