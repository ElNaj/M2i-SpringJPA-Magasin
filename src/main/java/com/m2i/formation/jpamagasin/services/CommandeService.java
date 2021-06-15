package com.m2i.formation.jpamagasin.services;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.formation.jpamagasin.dtos.GetCommandesDTO;
import com.m2i.formation.jpamagasin.models.Commande;
import com.m2i.formation.jpamagasin.repositories.ICommandeRepository;

public class CommandeService {

	ICommandeRepository repository;
	private ObjectMapper mapper; 
	
	public CommandeService(ICommandeRepository repository, ObjectMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
    public List<Commande> findAllCommande(){
    	return this.repository.findAll();
    }

    public List<GetCommandesDTO> findAll() {
        List<Commande> commandes = this.repository.findAll();
        List<GetCommandesDTO> getCommandesDTOS = new ArrayList<>();
        commandes.forEach(commande -> {
            getCommandesDTOS.add(
                    this.mapper.convertValue(commande, GetCommandesDTO.class)
            );
        });
        return getCommandesDTOS;
    }

    public GetCommandesDTO findById(Long id) {
        return mapper.convertValue(this.repository.findById(id), GetCommandesDTO.class);
    }

    public Commande save(Commande commande) {
        return this.repository.save(commande);
    }

    public void delete(Commande commande) {
        this.repository.delete(commande);
    }
}
