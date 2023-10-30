package com.scoreease.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scoreease.api.entities.Estabelecimento;
import com.scoreease.api.services.EstabelecimentoService;

@RestController
@RequestMapping(value = "/estabelecimentos")
public class EstabelecimentoResource {
	
	@Autowired
	private EstabelecimentoService service;
	
	@GetMapping
	public ResponseEntity<List<Estabelecimento>> findAll() {
		List<Estabelecimento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Estabelecimento> findById(@PathVariable Long id) {
		Estabelecimento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
