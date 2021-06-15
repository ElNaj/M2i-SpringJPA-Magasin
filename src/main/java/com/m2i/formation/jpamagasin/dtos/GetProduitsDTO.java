package com.m2i.formation.jpamagasin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProduitsDTO {

	private String nom;
	private Float prix;
}
