package com.scoreease.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scoreease.api.entities.Establishment;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {

	List<Establishment> findByNameContainingIgnoreCase(String text);
	
}
