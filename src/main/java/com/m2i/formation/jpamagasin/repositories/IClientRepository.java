package com.m2i.formation.jpamagasin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.formation.jpamagasin.models.Client;

public interface IClientRepository  extends JpaRepository<Client, Long>{
	
	 Optional<Client> findByNom(String name);
}
