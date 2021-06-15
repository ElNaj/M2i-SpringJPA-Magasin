package com.m2i.formation.jpamagasin.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.formation.jpamagasin.dtos.GetClientsDTO;
import com.m2i.formation.jpamagasin.dtos.GetCommandesDTO;
import com.m2i.formation.jpamagasin.models.Client;
import com.m2i.formation.jpamagasin.repositories.IClientRepository;

public class ClientService {

	IClientRepository repository;
	private ObjectMapper mapper; 
	
	public ClientService(IClientRepository repository, ObjectMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
    public Optional<Client> findByNom(String nom) {
        return this.repository.findByNom(nom);
    }
    public List<Client> findAllClient(){
    	return this.repository.findAll();
    }

    public List<GetClientsDTO> findAll() {
        List<Client> clients = this.repository.findAll();
        List<GetClientsDTO> getClientsDTOS = new ArrayList<>();
        clients.forEach(user -> {
            getClientsDTOS.add(
                    this.mapper.convertValue(user, GetClientsDTO.class)
            );
        });
        return getClientsDTOS;
    }

    public GetClientsDTO findById(Long id) {
        return mapper.convertValue(this.repository.findById(id), GetClientsDTO.class);
    }

    public Client save(Client client) {
        return this.repository.save(client);
    }

    public void delete(Client client) {
        this.repository.delete(client);
    }

    public GetCommandesDTO getCommande(Long id) {
        Optional<Client> client = this.repository.findById(id);
        System.out.println(client);
        return this.mapper.convertValue(client.get(), GetCommandesDTO.class);
    }
}
