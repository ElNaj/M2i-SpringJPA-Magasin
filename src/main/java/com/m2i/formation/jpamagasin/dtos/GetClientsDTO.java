package com.m2i.formation.jpamagasin.dtos;

import java.util.List;

import com.m2i.formation.jpamagasin.models.Commande;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetClientsDTO {

    private String prenom;
    private String nom;
}
