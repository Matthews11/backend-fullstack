package com.mitocode.service.impl;

import org.springframework.stereotype.Service;

import com.mitocode.model.Medic;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IMedicRepo;
import com.mitocode.service.CRUDImpl;
import com.mitocode.service.IMedicService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicServiceImpl extends CRUDImpl<Medic, Integer> implements IMedicService{
  

	private final IMedicRepo repo;

	@Override
	protected IGenericRepo<Medic, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	 
}
