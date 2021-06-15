package com.m2i.formation.jpamagasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.formation.jpamagasin.models.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Long>{

}
