
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

import com.m2i.formation.jpamagasin.dtos.GetCommandesDTO;
import com.m2i.formation.jpamagasin.models.Commande;
import com.m2i.formation.jpamagasin.services.CommandeService;

@RestController
@CrossOrigin
@RequestMapping("commandes")
public class CommandesController {


    @Autowired
    CommandeService service;

    @GetMapping
    public List<Commande> findAllCommande() {
        return this.service.findAllCommande();
    }
    @GetMapping("/dtos")
    public List<GetCommandesDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public GetCommandesDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    public Commande save(@RequestBody Commande commande) {
        return this.service.save(commande);
    }

    @PutMapping
    public Commande edit(@RequestBody Commande commande) {
        return this.service.save(commande);
    }

    @DeleteMapping
    public void delete(@RequestBody Commande commande) {
        this.service.delete(commande);
    }
}
