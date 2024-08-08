package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Patient;

public interface IPatientRepo extends JpaRepository<Patient, Integer> {

}
