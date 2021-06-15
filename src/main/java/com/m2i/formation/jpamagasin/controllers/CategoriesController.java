package com.m2i.formation.jpamagasin.controllers;

import java.util.List;

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

import com.m2i.formation.jpamagasin.dtos.GetCategoriesDTO;
import com.m2i.formation.jpamagasin.models.Categorie;
import com.m2i.formation.jpamagasin.services.CategorieService;

@RestController
@CrossOrigin
@RequestMapping("categories")
public class CategoriesController {

    @Autowired
    CategorieService service;

    @GetMapping
    public List<Categorie> findAllCategorie() {
        return this.service.findAllCategorie();
    }
    @GetMapping("/dtos")
    public List<GetCategoriesDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public GetCategoriesDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    public Categorie save(@RequestBody Categorie categorie) {
        return this.service.save(categorie);
    }

    @PutMapping
    public Categorie edit(@RequestBody Categorie categorie) {
        return this.service.save(categorie);
    }

    @DeleteMapping
    public void delete(@RequestBody Categorie categorie) {
        this.service.delete(categorie);
    }
}
