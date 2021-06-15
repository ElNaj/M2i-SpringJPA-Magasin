package com.m2i.formation.jpamagasin.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.formation.jpamagasin.repositories.ICategorieRepository;
import com.m2i.formation.jpamagasin.repositories.IClientRepository;
import com.m2i.formation.jpamagasin.repositories.ICommandeRepository;
import com.m2i.formation.jpamagasin.repositories.IProduitRepository;
import com.m2i.formation.jpamagasin.services.CategorieService;
import com.m2i.formation.jpamagasin.services.ClientService;
import com.m2i.formation.jpamagasin.services.CommandeService;
import com.m2i.formation.jpamagasin.services.ProduitService;

@Configuration
public class Config {

	@Bean
	public ClientService clientService(IClientRepository clientRepository, ObjectMapper mapper) {
		return new ClientService(clientRepository, mapper);
	}
	@Bean
	public ProduitService produitService(IProduitRepository produitRepository, ObjectMapper mapper) {
		return new ProduitService(produitRepository, mapper);
	}
	@Bean
	public CommandeService commandeService(ICommandeRepository commandeRepository, ObjectMapper mapper) {
		return new CommandeService(commandeRepository, mapper);
	}
	@Bean
	public CategorieService categorieService(ICategorieRepository categorieRepository, ObjectMapper mapper) {
		return new CategorieService(categorieRepository, mapper);
	}
}
