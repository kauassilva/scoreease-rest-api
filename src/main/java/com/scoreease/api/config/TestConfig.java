package com.scoreease.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.scoreease.api.entities.Establishment;
import com.scoreease.api.repositories.EstablishmentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private EstablishmentRepository estabelecimentoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Establishment e1 = new Establishment(null, "Samsung");
		Establishment e2 = new Establishment(null, "Vale");
		Establishment e3 = new Establishment(null, "Burger King");
		
		estabelecimentoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
	}

}
