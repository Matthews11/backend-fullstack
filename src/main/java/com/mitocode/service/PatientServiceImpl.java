package com.mitocode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.model.Patient;
import com.mitocode.repo.IPatientRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService{


	private final IPatientRepo repo;
	
	@Override
	public Patient save(Patient patient) {
		// TODO Auto-generated method stub
		return repo.save(patient);
	}

	@Override
	public Patient update(Integer id, Patient patient) {
		// TODO Auto-generated method stub
		return repo.save(patient);
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Patient findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(new Patient());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
