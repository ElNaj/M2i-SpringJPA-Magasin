package com.m2i.formation.jpamagasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.formation.jpamagasin.models.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long>{

}
