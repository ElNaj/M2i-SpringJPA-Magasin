package com.m2i.formation.jpamagasin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.formation.jpamagasin.dtos.GetClientsDTO;
import com.m2i.formation.jpamagasin.dtos.GetCommandesDTO;
import com.m2i.formation.jpamagasin.models.Client;
import com.m2i.formation.jpamagasin.services.ClientService;

@RestController
@CrossOrigin
@RequestMapping("clients")
public class ClientsController {

    @Autowired
    ClientService service;

    @GetMapping
    public List<Client> findAllClient() {
        return this.service.findAllClient();
    }
    @GetMapping("/dtos")
    public List<GetClientsDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}/commande")
    public GetCommandesDTO getCommande(@PathVariable Long id) {
    	
        return this.service.getCommande(id);
    }

    @GetMapping("{id}")
    public GetClientsDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping("/name/{nom}")
    public Optional<Client> findByNom(@PathVariable String nom) {
        Optional<Client> user = this.service.findByNom(nom);
        return user;
    }

    @PostMapping
    public Client save(@RequestBody Client client) {
        return this.service.save(client);
    }

    @PutMapping
    public Client edit(@RequestBody Client client) {
        return this.service.save(client);
    }

    @DeleteMapping
    public void delete(@RequestBody Client client) {
        this.service.delete(client);
    }
}
