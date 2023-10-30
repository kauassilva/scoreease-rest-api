package com.scoreease.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.scoreease.api.entities.Estabelecimento;
import com.scoreease.api.repositories.EstabelecimentoRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Estabelecimento e1 = new Estabelecimento(null, "Samsung");
		Estabelecimento e2 = new Estabelecimento(null, "Vale");
		Estabelecimento e3 = new Estabelecimento(null, "Burger King");
		
		estabelecimentoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
	}

}
