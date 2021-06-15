package com.m2i.formation.jpamagasin.services;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.formation.jpamagasin.dtos.GetProduitsDTO;
import com.m2i.formation.jpamagasin.models.Produit;
import com.m2i.formation.jpamagasin.repositories.IProduitRepository;

public class ProduitService {

	IProduitRepository repository;
	private ObjectMapper mapper; 
	
	public ProduitService(IProduitRepository repository, ObjectMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
    public List<Produit> findAllProduit(){
    	return this.repository.findAll();
    }

    public List<GetProduitsDTO> findAll() {
        List<Produit> produits = this.repository.findAll();
        List<GetProduitsDTO> GetProduitsDTO = new ArrayList<>();
        produits.forEach(produit -> {
        	GetProduitsDTO.add(
                    this.mapper.convertValue(produit, GetProduitsDTO.class)
            );
        });
        return GetProduitsDTO;
    }

    public GetProduitsDTO findById(Long id) {
        return mapper.convertValue(this.repository.findById(id), GetProduitsDTO.class);
    }

    public Produit save(Produit produit) {
        return this.repository.save(produit);
    }

    public void delete(Produit produit) {
        this.repository.delete(produit);
    }
}
