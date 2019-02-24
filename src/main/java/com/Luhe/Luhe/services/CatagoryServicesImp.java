package com.Luhe.Luhe.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Luhe.Luhe.domains.Catagory;
import com.Luhe.Luhe.Repository.*;
@Service
public class CatagoryServicesImp implements CatagoryService{
	
	CatagoryRepository categoryRepository;
	
	@Autowired
	public CatagoryServicesImp(CatagoryRepository categoryRepository) {
		
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Catagory save(Catagory Catagories) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Catagory> saveAll(Iterable<Catagory> Catagoriess) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catagory> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Catagory> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Iterable<Catagory> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Catagory Catagories) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<Catagory> Catagoriess) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
