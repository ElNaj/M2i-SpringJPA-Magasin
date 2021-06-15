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

import com.m2i.formation.jpamagasin.dtos.GetProduitsDTO;
import com.m2i.formation.jpamagasin.models.Produit;
import com.m2i.formation.jpamagasin.services.ProduitService;

@RestController
@CrossOrigin
@RequestMapping("produits")
public class ProduitsController {

    @Autowired
    ProduitService service;

    @GetMapping
    public List<Produit> findAllProduit() {
        return this.service.findAllProduit();
    }
    @GetMapping("/dtos")
    public List<GetProduitsDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public GetProduitsDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    public Produit save(@RequestBody Produit produit) {
        return this.service.save(produit);
    }

    @PutMapping
    public Produit edit(@RequestBody Produit produit) {
        return this.service.save(produit);
    }

    @DeleteMapping
    public void delete(@RequestBody Produit produit) {
        this.service.delete(produit);
    }
}
