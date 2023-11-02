package com.scoreease.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreease.api.entities.Establishment;
import com.scoreease.api.repositories.EstablishmentRepository;

@Service
public class EstablishmentService {
	
	@Autowired
	private EstablishmentRepository repository;
	
	public List<Establishment> findAll() {
		return repository.findAll();
	}
	
	public Establishment findById(Long id) {
		Optional<Establishment> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<Establishment> findByTitle(String text) {
		return repository.findByNameContainingIgnoreCase(text);
	}
	
	public Establishment insert(Establishment obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Establishment update(Long id, Establishment obj) {
		Establishment entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Establishment entity, Establishment obj) {
		entity.setName(obj.getName());
	}

}
