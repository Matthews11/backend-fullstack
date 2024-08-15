package com.mitocode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.repo.IGenericRepo;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public abstract class CRUDImpl<T,ID> implements ICRUD<T, ID> {

	
	protected abstract IGenericRepo<T,ID>getRepo();
	
	
	@Override
	public T save(T t) {
		// TODO Auto-generated method stub
		return getRepo().save(t);
	}

	@Override
	public T update(ID id, T t) {
		// TODO Auto-generated method stub
		return getRepo().save(t);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return getRepo().findAll();
	}

	@Override
	public T findById(ID id) {
		// TODO Auto-generated method stub
		return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("Id not found: "+id));
	}

	@Override
	public void delete(ID id) {
		// TODO Auto-generated method stub
		 getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("Id not found: "+id));
		 getRepo().deleteById(id);
	}

}
