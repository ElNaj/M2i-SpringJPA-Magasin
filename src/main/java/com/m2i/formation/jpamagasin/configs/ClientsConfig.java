package com.m2i.formation.jpamagasin.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.formation.jpamagasin.repositories.IClientRepository;
import com.m2i.formation.jpamagasin.services.ClientService;

@Configuration
public class ClientsConfig {

	@Bean
	public ClientService clientService(IClientRepository clientRepository, ObjectMapper mapper) {
		return new ClientService(clientRepository, mapper);
	}
}
