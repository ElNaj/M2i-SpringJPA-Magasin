package com.m2i.formation.jpamagasin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetClientsDTO {

    private String prenom;
    private String nom;
}
