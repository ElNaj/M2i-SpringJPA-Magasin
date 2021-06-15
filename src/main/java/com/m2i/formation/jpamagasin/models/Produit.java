package com.m2i.formation.jpamagasin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="produit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name="nom")
	private String nom;
	@Column(name="prix")
	private Float prix;
	
	@ManyToOne
	@JoinColumn(name="categorie_id", referencedColumnName = "id")
	private Categorie categorie;
	
}
