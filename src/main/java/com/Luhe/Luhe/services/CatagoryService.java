package com.Luhe.Luhe.services;

import java.util.Optional;

import com.Luhe.Luhe.domains.Catagory;

public interface CatagoryService {
public Catagory save(Catagory Catagories);
	
	public Iterable<Catagory> saveAll(Iterable<Catagory> Catagoriess);

	Optional<Catagory> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Catagory> findAll();

	Iterable<Catagory> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Catagory Catagories);
	
	void deleteAll(Iterable<Catagory> Catagoriess);

	void deleteAll();
}
