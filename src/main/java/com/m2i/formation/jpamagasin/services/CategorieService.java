package com.m2i.formation.jpamagasin.services;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.formation.jpamagasin.dtos.GetCategoriesDTO;
import com.m2i.formation.jpamagasin.models.Categorie;
import com.m2i.formation.jpamagasin.repositories.ICategorieRepository;

public class CategorieService {

	ICategorieRepository repository;
	private ObjectMapper mapper; 
	
	public CategorieService(ICategorieRepository repository, ObjectMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
    public List<Categorie> findAllCategorie(){
    	return this.repository.findAll();
    }

    public List<GetCategoriesDTO> findAll() {
        List<Categorie> categories = this.repository.findAll();
        List<GetCategoriesDTO> getCategoriesDTOS = new ArrayList<>();
        categories.forEach(categorie -> {
            getCategoriesDTOS.add(
                    this.mapper.convertValue(categorie, GetCategoriesDTO.class)
            );
        });
        return getCategoriesDTOS;
    }

    public GetCategoriesDTO findById(Long id) {
        return mapper.convertValue(this.repository.findById(id), GetCategoriesDTO.class);
    }

    public Categorie save(Categorie client) {
        return this.repository.save(client);
    }

    public void delete(Categorie client) {
        this.repository.delete(client);
    }

}
