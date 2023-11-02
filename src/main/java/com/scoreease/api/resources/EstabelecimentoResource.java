package com.scoreease.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.scoreease.api.entities.Estabelecimento;
import com.scoreease.api.resources.util.URL;
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
	
	@GetMapping(value="/search")
	public ResponseEntity<List<Estabelecimento>> search(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Estabelecimento> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Estabelecimento> insert(@RequestBody Estabelecimento obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	

}
