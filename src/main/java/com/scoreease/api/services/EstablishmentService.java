package com.scoreease.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.scoreease.api.entities.Establishment;
import com.scoreease.api.repositories.EstablishmentRepository;
import com.scoreease.api.services.exceptions.DatabaseException;
import com.scoreease.api.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EstablishmentService {
	
	@Autowired
	private EstablishmentRepository repository;
	
	public List<Establishment> findAll() {
		return repository.findAll();
	}
	
	public Establishment findById(Long id) {
		Optional<Establishment> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Establishment> findByTitle(String text) {
		return repository.findByNameContainingIgnoreCase(text);
	}
	
	public Establishment insert(Establishment obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {			
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Establishment update(Long id, Establishment obj) {
		try {
			Establishment entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Establishment entity, Establishment obj) {
		entity.setName(obj.getName());
	}

}
