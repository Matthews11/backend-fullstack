package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Patient;


public interface IPatientService {
	
	 
	
	Patient save(Patient patient);
	Patient update(Integer id,Patient patient);
	List<Patient> findAll();
	Patient findById(Integer id);
	void delete(Integer id);

}
