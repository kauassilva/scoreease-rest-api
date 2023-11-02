package com.scoreease.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreease.api.entities.Estabelecimento;
import com.scoreease.api.repositories.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoRepository repository;
	
	public List<Estabelecimento> findAll() {
		return repository.findAll();
	}
	
	public Estabelecimento findById(Long id) {
		Optional<Estabelecimento> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<Estabelecimento> findByTitle(String text) {
		return repository.findByNameContainingIgnoreCase(text);
	}
	
	public Estabelecimento insert(Estabelecimento obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
