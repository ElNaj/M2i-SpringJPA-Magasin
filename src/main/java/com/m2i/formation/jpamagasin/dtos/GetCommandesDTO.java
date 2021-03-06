package com.m2i.formation.jpamagasin.dtos;

import java.util.Optional;

import com.m2i.formation.jpamagasin.models.Commande;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCommandesDTO {
	
	private String nom;
    private Optional<Commande> commandes;
}
